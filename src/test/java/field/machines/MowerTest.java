package field.machines;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import position.Alignment;
import position.Directions;

public class MowerTest {

    private Mower mower;

    @Before
    public void setUp() {
	mower = new Mower(2, 4, Directions.North);
    }

    @Test
    public void print() {
	Assert.assertEquals(new Alignment(2, 4, Directions.North).toString(),
		mower.toString());
	Assert.assertEquals("2 4 N", mower.toString());
    }

    @Test
    public void advanceCommand() {
	mower.advance();
	Assert.assertEquals("2 5 N", mower.toString());
    }

    @Test
    public void advanceCommand2Mowers() {
        Mower second = new Mower(2,3, Directions.Est);
        mower.advance();
        second.advance();
        Assert.assertEquals("2 5 N", mower.toString());
        Assert.assertEquals("3 3 E", second.toString());
    }


    @Test
    public void leftCommand() {
	mower.left();
	Assert.assertEquals("2 4 W", mower.toString());
    }

    @Test
    public void rightCommand() {
	mower.right();
	Assert.assertEquals("2 4 E", mower.toString());
    }
}
