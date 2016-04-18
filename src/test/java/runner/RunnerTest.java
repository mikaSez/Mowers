package runner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import position.Alignment;
import position.Directions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RunnerTest {
    private Runner runner;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setUp() throws Exception {
        runner = new Runner();
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void validField(){
        runner.setField("5 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidField(){
        runner.setField("greg 4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidArgumentCount(){
        runner.setField("4 3 4");
    }

    @Test
    public void randomSpaces(){
        runner.setField("3     4");
    }

    @Test
    public void argumentsWithTrailingSpaces(){
        runner.setField("  3 4  ");
    }

    @Test
    public void addMachine(){
        runner.setField(" 3 4");
        runner.addMachine("1 4 N");
    }

    @Test
    public void addMachineWithSpaces(){
        runner.setField(" 3 4");
        runner.addMachine("  1 2 N");
    }

    @Test
    public void addMachineWithRandomSpaces(){
        runner.setField("4 5");
        runner.addMachine("1  2   E");
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidDirection(){
        runner.setField("3 4");
        runner.addMachine("1 2 F");
    }

    @Test
    public void commandExecution(){
        runner.setField("4 5");
        runner.addMachine("1 3 E");
        runner.executeCommand("AADDFER");
    }

    @Test
    public void correctCommandExecution(){
        runner.setField("5 5");
        runner.addMachine("1 2 N");
        Alignment al = runner.executeCommand("GAGAGAGAA");
        Assert.assertEquals("1 3 N", al.toString());
    }

    @Test
    public void validScenario(){
        String[] scenario = {"3 4","1 3 N", "AADGAD"};
        runner.runScenario(Arrays.asList(scenario));
    }

    @Test(expected = AssertionError.class)
    public void nullScenario(){
        runner.runScenario(null);
    }
    @Test
    public void givenScenario(){
        String[] scenario = {"5 5", "1 2 N", "GAGAGAGAA", "3 3 E", "AADAADADDA"};
        List<Alignment> alignments = new ArrayList<Alignment>(){{
            add(new Alignment(1, 3, Directions.North));
            add(new Alignment(5, 1, Directions.Est));
        }};


        List<Alignment> result = runner.runScenario(Arrays.asList(scenario));


        Assert.assertEquals("1 3 N\n5 1 E\n", outContent.toString());
        Assert.assertEquals(alignments, result);
    }
}