package field;

import field.machines.Mower;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MikaSez on 14/04/2016.
 */
public class Field {
    private int height;
    private int width;
    private List<Mower> mowers;

    public Field(int x, int y) {
        height = y;
        width = x;
        mowers = new ArrayList<Mower>();
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Mower> getMowers() {
        return mowers;
    }


    /**
     * Adds a new mower to be used on the field
     *
     * @param x : position on H-axis, counted from bottom-left
     * @param y : position on V-axis, counted from bottom-left
     * @throws IllegalArgumentException  x is not in field bounds (from 0 to width)
     * @throws IllegalArgumentException y is not in field bounds (from 0 to height)
     * */
    public void addMower(int x, int y, Directions north) {
        if(x > width || x < 0){
            throw new IllegalArgumentException("X should be in field bounds : 0 - " + width);
        }
        if(y > height || y < 0){
            throw new IllegalArgumentException("Y should be in field bounds : 0 - " + height);
        }


        mowers.add(new Mower(x,y,north));
    }


}
