package position;

/**
 * Cardinal directions available in the application <br/>
 * It tracks the direction on the right and on the left <br/>
 * 
 */
public enum Directions {
    South("West", "Est"), West("North", "South"), Est("South", "North"), North(
	    "Est", "West");

    private final String right;
    private final String left;

    Directions(String right, String left) {
	this.left = left;
	this.right = right;
    }

    /**
     * Returns the next cardinal direction on the left of the current one
     * */
    public Directions nextLeft() {
	return Directions.valueOf(left);
    }

    /**
     * Returns the next cardinal direction on the right of the current one
     * */
    public Directions nextRight() {
	return Directions.valueOf(right);
    }

    /**
     * Returns the first letter of the current direction
     * */
    public Object getCommand() {
	return this.name().charAt(0);
    }
}
