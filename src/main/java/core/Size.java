package core;

/**
 * size, a class to told you how big the object is
 */
public record Size(int width, int height) {
    /**
     * make a Size object
     */
    public Size {

    }

    /**
     * get width of the object
     */
    public int width() {
        return this.width;
    }

    /**
     * get height of object
     */
    public int height() {
        return this.height;
    }
}
