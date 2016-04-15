package field;

/**
 * Created by MikaSez on 14/04/2016.
 */
public enum Directions {
    South("West", "Est"), West("North", "South"), Est("South", "North"), North("Est", "West");


    private final String right;
    private final String left;

     Directions(String right, String left){
        this.left = left;
        this.right = right;
    }

    public Directions nextLeft(){
        return Directions.valueOf(left);
    }
    public Directions nextRight(){
        return Directions.valueOf(right);
    }
}
