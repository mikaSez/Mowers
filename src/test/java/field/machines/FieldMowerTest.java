package field.machines;

import command.CommandFactory;
import command.MachineCommandFactory;
import position.Directions;
import field.Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 */
public class FieldMowerTest {

    private Machine machine;
    private final Field field = new Field(2, 3);

    @Before
    public void setUp() throws Exception {
        machine = new FieldMower(new Mower(1,2, Directions.North), field);

    }

    @Test
    public void canAdvance(){
        machine.advance();
        Assert.assertEquals("1 3 N", machine.toString());
    }

    @Test
    public void cannotExitField(){
        machine.advance();
        machine.advance();
        Assert.assertEquals("1 3 N", machine.toString());
    }
    @Test
    public void cannotExitFieldWithCommand(){
        CommandFactory factory = MachineCommandFactory.init(machine);
        factory.runCommands("AA");
        Assert.assertEquals("1 3 N", machine.toString());
    }
    @Test
    public void canTurnRight(){
        machine.right();
        Assert.assertEquals("1 2 E", machine.toString());
    }
    @Test
    public void canTurnLeft(){
        machine.left();
        Assert.assertEquals("1 2 W", machine.toString());
    }
}

