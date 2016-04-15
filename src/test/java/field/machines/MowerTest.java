package field.machines;


import field.Directions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MowerTest {

    private Mower mower;

    @Before
    public void setUp(){
        mower = new Mower(2,4, Directions.North);
    }

    @Test
    public void initTest(){

    }

}
