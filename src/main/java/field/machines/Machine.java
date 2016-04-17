package field.machines;

import position.Alignment;



public interface Machine {

    /**
     * Move the machine forward one case based on its current {@link Alignment}
     * */
    void advance();

    /**
     * Turns the machine on the right based on its current {@link Alignment}
     * */
    void right();

    /**
     * Turns the machine on the left based on its current {@link Alignment}
     * */
    void left();

    /**
     * Return it's alignment. It contains its current position and the cardinal direction it's currently facing.
     * For details:  {@link Alignment}
     * */
    Alignment getAlignment();

}
