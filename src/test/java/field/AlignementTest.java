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
   public void setUp(){
       alignement = new Alignement(2,4,Directions.North);
   }



    @Test
    public void advanceNorth(){
        alignement.move();

        Assert.assertEquals(5, alignement.getY());

    }

    @Test
    public void advanceEast(){

        alignement.right();
        alignement.move();
        Assert.assertEquals(3, alignement.getX());

    }

    @Test
    public void advanceWest(){

        alignement.left();
        alignement.move();
        Assert.assertEquals(1, alignement.getX());

    }

    @Test
    public void advanceSouth(){

        alignement.left();
        alignement.left();
        alignement.move();
        Assert.assertEquals(3, alignement.getY());

    }


    @Test
    public void turnLeft(){
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
    public void turnRigth(){
        Directions one = alignement.right();
        Directions two = alignement.right();
        Directions three = alignement.right();
        Directions four = alignement.right();

        Assert.assertEquals(Directions.Est, one);
        Assert.assertEquals(Directions.South, two);
        Assert.assertEquals(Directions.West, three);
        Assert.assertEquals(Directions.North, four);
    }

    @Test
    public void withBounds(){
        alignement.withBounds(new Position(5,4));

        Assert.assertTrue(alignement.hasBounds());
    }
}
