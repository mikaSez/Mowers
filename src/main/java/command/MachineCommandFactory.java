package command;

import java.util.HashMap;
import java.util.logging.Logger;

import field.machines.Machine;

/**
 * Implémentation classique : https://en.wikipedia.org/wiki/Command_pattern
 */
public class MachineCommandFactory {
    private final HashMap<Integer, Command> commands;
    private final static Logger log = Logger
	    .getLogger(MachineCommandFactory.class.getName());

    private MachineCommandFactory() {
	commands = new HashMap<Integer, Command>(4);
    }

    private void addCommand(Integer name, Command command) {
	commands.put(name, command);
    }

    public void execute(Integer c, Machine m) {
	final Command command = commands.get(c);
	if (command != null) {
	    command.execute(m);
	} else {
	    log.warning("Invalid command : " + (char) c.intValue());
	}

    }

    /**
     * Return a MachineCommandFactory with some preset commands <br/>
     * */
    public static MachineCommandFactory init() {
	MachineCommandFactory cf = new MachineCommandFactory();
	// if we want to enjoy the String stream we accommodate ourself with
	// casts here
	cf.addCommand((int) 'A', m -> m.advance());
	cf.addCommand((int) 'G', m -> m.left());
	cf.addCommand((int) 'D', m -> m.right());
	return cf;
    }

}
