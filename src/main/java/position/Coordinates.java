package position;

/**
 * Class handling the coordinates of any given objects <br/>
 * It operates on assumption North is up
 */
public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
	this.x = x;
	this.y = y;
    }

	public Coordinates(Coordinates c){
		this.x = c.x;
		this.y = c.y;
	}

    /**
     * Increments the Y component of the coordinates.
     */
    public void north() {
	y++;
    }

    /**
     * Decrements the Y component of the coordinates.
     */
    public void south() {
	y--;
    }

    /**
     * Increments the X component of the coordinates.
     */
    public void est() {
	x++;
    }

    /**
     * Decrements the X component of the coordinates.
     */
    public void west() {
	x--;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + x;
	result = prime * result + y;
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
        Coordinates other = (Coordinates) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder(3);
	sb.append(x);
	sb.append(' ');
	sb.append(y);
	return sb.toString();
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
