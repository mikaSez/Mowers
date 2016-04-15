package field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by MikaSez on 14/04/2016.
 */
public class AlignementTest {
    private Alignement alignement;

    @Before
    public void setUp() {
	alignement = new Alignement(2, 4, Directions.North);
    }

    @Test
    public void advanceNorth() {
	Alignement result = new Alignement(2, 5, Directions.North);

	alignement.move();

	Assert.assertEquals(result, alignement);

    }

    @Test
    public void advanceEast() {
	Alignement result = new Alignement(3, 4, Directions.Est);
	alignement.right();
	alignement.move();
	Assert.assertEquals(result, alignement);

    }

    @Test
    public void advanceWest() {

	Alignement result = new Alignement(1, 4, Directions.West);
	alignement.left();
	alignement.move();
	Assert.assertEquals(result, alignement);

    }

    @Test
    public void advanceSouth() {

	Alignement result = new Alignement(2, 3, Directions.South);
	alignement.left();
	alignement.left();
	alignement.move();
	Assert.assertEquals(result, alignement);

    }

    @Test
    public void turnLeft() {
	Directions one = alignement.left();
	Directions two = alignement.left();
	Directions three = alignement.left();
	Directions four = alignement.left();

	Assert.assertEquals(Directions.West, one);
	Assert.assertEquals(Directions.South, two);
	Assert.assertEquals(Directions.Est, three);
	Assert.assertEquals(Directions.North, four);
    }

    @Test
    public void turnRigth() {
	Directions one = alignement.right();
	Directions two = alignement.right();
	Directions three = alignement.right();
	Directions four = alignement.right();

	Assert.assertEquals(Directions.Est, one);
	Assert.assertEquals(Directions.South, two);
	Assert.assertEquals(Directions.West, three);
	Assert.assertEquals(Directions.North, four);
    }

}
