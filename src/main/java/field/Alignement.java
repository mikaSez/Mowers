package field;

/**
 * Created by MikaSez on 14/04/2016.
 */
public class Alignement {
   private int x;
   private int y;
   private Directions direction;


   public Alignement(int x, int y, Directions dir) {
      this.x = x;
      this.y = y;
      this.direction = dir;
   }

   public Directions left() {
      direction = direction.nextLeft();
      return direction;
   }

   public Directions right() {
      direction = direction.nextRight();
      return direction;
   }

   public int getX() {
      return x;
   }

   public int getY() {
      return y;
   }

   public void move() {
      switch (direction){
         case North:
            y++;
            break;
         case Est:
            x++;
            break;
         case West:
            x--;
            break;
         case South:
            y--;
            break;
      }
   }

   @Override
   public String toString()
   {
      StringBuilder sb = new StringBuilder();
      sb.append(x);
      sb.append(' ');
      sb.append(y);
      sb.append(' ');
      sb.append(direction.getCommand());
      return sb.toString();
   }

   public void withBounds(Position position) {
   }
}
