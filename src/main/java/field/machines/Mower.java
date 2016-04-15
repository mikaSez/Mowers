package field.machines;

import command.MachineCommandFactory;

import field.Alignement;
import field.Directions;

/**
 * A simple mower it can turn, it can advance Actions : turn (G)Left - (D)Right
 * - (A)dvance
 */
public class Mower implements Machine {
    private Alignement alignement;
    private static final MachineCommandFactory factory = MachineCommandFactory
	    .init();

    public Mower(int x, int y, Directions dir) {
	this.alignement = new Alignement(x, y, dir);
    }

    @Override
    public String toString() {
	return alignement.toString();
    }

    /**
     * Execute given set of commands on this mower <br/>
     * Available commands are : <br/>
     * <dl>
     * <dt>A</dt>
     * <dd>Advance the mower one case at a time</dd>
     * </dl>
     */
    public void execute(String command) {
	command.chars().forEach(c -> factory.execute(c, this));

    }

    @Override
    public void advance() {
	alignement.move();
    }

    @Override
    public void right() {
	alignement.right();
    }

    @Override
    public void left() {
	alignement.left();
    }

}
