package field;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FieldTest {

    private Field field;

    @Before
    public void setUp() {
	field = new Field(5, 3);
    }

    @Test
    public void fieldInit() {
	Assert.assertEquals(5, field.getWidth());
	Assert.assertEquals(3, field.getHeight());
    }

    @Test
    public void addMower() {
	field.addMower(2, 2, Directions.North);

	field.addMower(0, 0, Directions.South);
	field.addMower(5, 3, Directions.West);

	Assert.assertEquals(3, field.getMowers().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mowerShouldBeInField() {
	field.addMower(2, -4, Directions.Est);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mowerShouldBeInField2() {
	field.addMower(-2, 2, Directions.North);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mowerShouldBeInField3() {
	field.addMower(6, 2, Directions.North);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mowerShouldBeInField4() {
	field.addMower(5, 4, Directions.North);
    }
}
