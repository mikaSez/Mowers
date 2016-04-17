package field.position;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import position.Alignment;
import position.Directions;

public class AlignmentTest {
    private Alignment alignment;

    @Before
    public void setUp() {
	alignment = new Alignment(2, 4, Directions.North);
    }

    @Test
    public void advanceNorth() {
	Alignment result = new Alignment(2, 5, Directions.North);

	alignment.move();

	Assert.assertEquals(result, alignment);

    }

    @Test
    public void advanceEast() {
	Alignment result = new Alignment(3, 4, Directions.Est);
	alignment.right();
	alignment.move();
	Assert.assertEquals(result, alignment);

    }

    @Test
    public void advanceWest() {

	Alignment result = new Alignment(1, 4, Directions.West);
	alignment.left();
	alignment.move();
	Assert.assertEquals(result, alignment);

    }

    @Test
    public void advanceSouth() {

	Alignment result = new Alignment(2, 3, Directions.South);
	alignment.left();
	alignment.left();
	alignment.move();
	Assert.assertEquals(result, alignment);

    }

    @Test
    public void turnLeft() {
	Directions one = alignment.left();
	Directions two = alignment.left();
	Directions three = alignment.left();
	Directions four = alignment.left();

	Assert.assertEquals(Directions.West, one);
	Assert.assertEquals(Directions.South, two);
	Assert.assertEquals(Directions.Est, three);
	Assert.assertEquals(Directions.North, four);
    }

    @Test
    public void turnRigth() {
	Directions one = alignment.right();
	Directions two = alignment.right();
	Directions three = alignment.right();
	Directions four = alignment.right();

	Assert.assertEquals(Directions.Est, one);
	Assert.assertEquals(Directions.South, two);
	Assert.assertEquals(Directions.West, three);
	Assert.assertEquals(Directions.North, four);
    }

}
