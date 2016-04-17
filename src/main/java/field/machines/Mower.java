package field.machines;

import command.CommandFactory;
import position.Alignment;
import position.Coordinates;
import position.Directions;

/**
 * A simple mower it can turn, it can advance Actions : turn Left - Right
 * - Advance
 */
public class Mower implements Machine {
    private final Alignment alignment;



    public Mower(int x, int y, Directions dir) {

        this.alignment = new Alignment(x, y, dir);

    }

    @Override
    public String toString() {
	return alignment.toString();
    }


    /**
     * Forcibly change current mower position without changing its coordinates
     * */
    public void forceCoordinates(Coordinates coordinates) {
        alignment.setCoordinates(coordinates);
    }


    public void advance() {
	    alignment.move();
    }


    public void right() {
	alignment.right();
    }


    public void left() {
	alignment.left();
    }

    @Override
    public Alignment getAlignment(){
        return alignment;
    }


    public Coordinates getCoordinates() {
        return alignment.getCoordinates();
    }


}


