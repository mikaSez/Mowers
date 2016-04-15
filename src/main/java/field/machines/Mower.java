package field.machines;

import field.Alignement;
import field.Directions;


/**
 * A simple mower it can turn, it can advance Actions : turn (G)Left - (D)Right
 * - (A)dvance
 */
public class Mower {
   private Alignement alignement;

   public Mower(int x, int y, Directions dir) {
      this.alignement = new Alignement(x,y,dir);
   }

   public int getPositionX() {
      return alignement.getX();
   }

   public int getPositionY() {
      return alignement.getY();
   }

   @Override
   public String toString()
   {
      return alignement.toString();
   }

}
