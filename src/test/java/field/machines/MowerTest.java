package field.machines;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import field.Alignement;
import field.Directions;

public class MowerTest {

    private Mower mower;

    @Before
    public void setUp() {
	mower = new Mower(2, 4, Directions.North);
    }

    @Test
    public void print() {
	Assert.assertEquals(new Alignement(2, 4, Directions.North).toString(),
		mower.toString());
	Assert.assertEquals("2 4 N", mower.toString());
    }

    @Test
    public void advanceCommand() {
	mower.execute("A");
	Assert.assertEquals("2 5 N", mower.toString());
    }

    @Test
    public void leftCommand() {
	mower.execute("G");
	Assert.assertEquals("2 4 W", mower.toString());
    }

    @Test
    public void rightCommand() {
	mower.execute("D");
	Assert.assertEquals("2 4 E", mower.toString());
    }
}
