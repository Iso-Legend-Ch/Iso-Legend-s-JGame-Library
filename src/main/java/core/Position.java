package core;

/**
 * position, an important class here
 */
public record Position(double x, double y) {
    /**
     * make a Position object
     */
    public Position {
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
    @Override
    public double x() {
        return this.x;
    }

    /**
     * get y of the object in double
     */
    @Override
    public double y() {
        return this.y;
    }
}
