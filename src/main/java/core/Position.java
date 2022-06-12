package core;

/**
 * position, an important class here
 */
public class Position {
    private double x, y;

    /**
     * make a Position object
     */
    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get x of the object in int
     */
    public int getIntX() {
        return (int) this.x;
    }

    /**
     * get y of the object in int
     */
    public int getIntY() {
        return (int) this.y;
    }

    /**
     * get x of the object in double
     */
    public double getX() {
        return this.x;
    }

    /**
     * get y of the object in double
     */
    public double getY() {
        return this.y;
    }
}
