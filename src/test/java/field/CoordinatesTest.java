package field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoordinatesTest {
    private Coordinates coordinates;

    @Before
    public void setUp() throws Exception {
	coordinates = new Coordinates(2, 2);
    }

    @Test
    public void moveNorth() {
	coordinates.north();

	Assert.assertEquals(new Coordinates(2, 3), coordinates);
    }

    @Test
    public void moveSouth() {
	coordinates.south();
	Assert.assertEquals(new Coordinates(2, 1), coordinates);
    }

    @Test
    public void moveEst() {
	coordinates.est();
	Assert.assertEquals(new Coordinates(3, 2), coordinates);
    }

    @Test
    public void moveWest() {
	coordinates.west();
	Assert.assertEquals(new Coordinates(1, 2), coordinates);
    }
}
