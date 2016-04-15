package field;

/**
 * Class handling current position and direction of a moving element
 */
public class Alignement {
    private Coordinates coordinates;
    private Directions direction;

    /**
     * We begin counting from bottom left
     * */
    public Alignement(int x, int y, Directions dir) {
	coordinates = new Coordinates(x, y);
	this.direction = dir;
    }

    /**
     * This function merely turns the object to the left <br/>
     * Object doesn't move
     * 
     * @return The current facing direction
     * */
    public Directions left() {
	direction = direction.nextLeft();
	return direction;
    }

    /**
     * This function merely turns the object to the right <br/>
     * Object doesn't move
     * 
     * @return The current facing direction
     * */
    public Directions right() {
	direction = direction.nextRight();
	return direction;
    }

    /**
     * Moves the object in the currently facing direction<br/>
     * */
    public void move() {
	switch (direction) {
	case North:
	    coordinates.north();
	    break;
	case Est:
	    coordinates.est();
	    break;
	case West:
	    coordinates.west();
	    break;
	case South:
	    coordinates.south();
	    break;
	}
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder();
	sb.append(coordinates);
	sb.append(' ');
	sb.append(direction.getCommand());
	return sb.toString();
    }

    public void withBounds(Coordinates position) {
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((coordinates == null) ? 0 : coordinates.hashCode());
	result = prime * result
		+ ((direction == null) ? 0 : direction.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	Alignement other = (Alignement) obj;
	if (coordinates == null) {
	    if (other.coordinates != null) {
		return false;
	    }
	} else if (!coordinates.equals(other.coordinates)) {
	    return false;
	}
	if (direction != other.direction) {
	    return false;
	}
	return true;
    }

}
