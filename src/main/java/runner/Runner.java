package runner;


import command.MachineCommandFactory;
import field.Field;
import field.machines.Machine;
import position.Alignment;
import position.Directions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class Runner {

    private Field field;
    private Machine machine;
    public static final Logger log = Logger.getLogger(Runner.class.getName());


    public Runner(){

    }

     void setField(String field) {
        String[] str = field.trim().split(" +");
        if(str.length != 2){
            throw new IllegalArgumentException("Field should have exactly 2 parameters");
        }
         
        int width = Integer.parseInt(str[0]);
        int height = Integer.parseInt(str[1]);

        this.field = new Field(width, height);

         log.info("Created field sized: " + field);
    }


     void addMachine(String initialPosition) {
         assert(field != null): "Field cannot be null, machines runs on it";

         String []param = initialPosition.trim().split(" +");
         int x = Integer.parseInt(param[0]);
         int y = Integer.parseInt(param[1]);

         Optional<Directions> dir = Directions.valueOf(param[2].charAt(0));

         if(!dir.isPresent()){
             throw new IllegalArgumentException("Valid arguments for directions are : N E S W");
         }

         machine = field.addMower(x,y, dir.get());

         log.info("Created a new machine at : " + machine);
    }

    /**
     * @param commands to be run on the last added machine
     * @return Alignment after command execution
     * */
    Alignment executeCommand(String commands){
        assert(machine != null) : "We can execute commands only on an already existing machine";
        log.info("executing a new command set : " + commands);
        MachineCommandFactory.init(machine).runCommands(commands);
        return  machine.getAlignment();
    }

    /**
     * Sets the scenario to run <br>
     * A scenario is composed of : <br>
     * <ol>
     *     <li>Field Sizes</li>
     *     <li>Machine Instructions
     *          <ul>
     *              <li>Machine Alignment</li>
     *              <li>Machine execution list</li>
     *          </ul>
     *     </li>
     * </ol>
     * Example :
     * <pre>
     *     4 4
     *     2 1 N
     *     GGDAAADAA
     *     3 2 E
     *     GADADAGAGAA
     * </pre>
     * */
    public List<Alignment> runScenario(List<String> scenario){
        assert scenario != null : "We cannot run a null scenario";
        log.info("Got a new scenario");
        scenario.forEach(log::info);

        List<Alignment> results = new ArrayList<>();
        Iterator<String> it = scenario.iterator();

        if(it.hasNext()){
            setField(it.next());
        }
        while(it.hasNext()){
            addMachine(it.next());
            if(it.hasNext()){
                Alignment al = executeCommand(it.next());
                System.out.println(al);
                results.add(al);
            }
        }
        return results;
    }

}
