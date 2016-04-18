package field;

import java.util.ArrayList;
import java.util.List;

import field.machines.FieldMower;
import field.machines.Machine;
import field.machines.Mower;
import position.Coordinates;
import position.Directions;

/**
 * The field limiting mowers movements
 */
public class Field {
    private Coordinates coordinates;
    private List<Machine> machines;

    public Field(int x, int y) {
        coordinates = new Coordinates(x, y);
        machines = new ArrayList<>();
    }


    public List<Machine> getMowers() {
        return machines;
    }

    /**
     * Adds a new mower to be used on the field
     *
     * @param x : position on H-axis, counted from bottom-left
     * @param y : position on V-axis, counted from bottom-left
     * @throws IllegalArgumentException x is not in field bounds (from 0 to width)
     * @throws IllegalArgumentException y is not in field bounds (from 0 to height)
     */
    public Machine addMower(int x, int y, Directions dir) {
        if (x > coordinates.getX() || x < 0) {
            throw new IllegalArgumentException(
                    "X should be in field bounds : 0 - " + coordinates.getX());
        }
        if (y > coordinates.getY() || y < 0) {
            throw new IllegalArgumentException(
                    "Y should be in field bounds : 0 - " + coordinates.getY());
        }
        Mower m = new Mower(x, y, dir);
        machines.add(new FieldMower(m, this));
        return m;
    }

    public boolean InBounds(Coordinates c) {
        if (c.getX() > coordinates.getX() || c.getX() < 0) {
            return false;
        }
        if (c.getY() > coordinates.getY() || c.getY() < 0) {
            return false;
        }
        return true;
    }
}
