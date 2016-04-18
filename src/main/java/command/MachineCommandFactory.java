package command;

import field.machines.Machine;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Executes a given set of commands on a given Machine.
 */
public class MachineCommandFactory implements CommandFactory {
    private final HashMap<Integer, Command> commands;
    private final static Logger log = Logger
            .getLogger(MachineCommandFactory.class.getName());

    private MachineCommandFactory() {
        commands = new HashMap<>(4);
    }

    private void addCommand(Integer name, Command command) {
        commands.put(name, command);
    }


    public void execute(Integer c) {
        final Command command = commands.get(c);
        if (command != null) {
            command.execute();
        } else {
            log.warning("Invalid command : " + (char) c.intValue());
        }

    }



    /**
     * Execute given set of commands on the machine <br/>
     * Available commands are : <br/>
     * <dl>
     * <dt>A</dt>
     * <dd>Call the machine's advance mechanism</dd>
     * <dt>D</dt>
     * <dd>Call the machine's right mechanism</dd>
     * <dt>G</dt>
     * <dd>Call the machine's left mechanism</dd>
     * </dl>
     */
    @Override
    public void runCommands(String commands){
         commands.chars().forEach(this::execute);
    }
    /**
     * Return a MachineCommandFactory with some preset commands <br/>
     * */
    public static MachineCommandFactory init(Machine m) {
        MachineCommandFactory cf = new MachineCommandFactory();
        // if we want to enjoy the String stream we accommodate our self with
        // casts here
        cf.addCommand((int) 'A', m::advance);
        cf.addCommand((int) 'G', m::left);
        cf.addCommand((int) 'D', m::right);
        return cf;
    }

}

