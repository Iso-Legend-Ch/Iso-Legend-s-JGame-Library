package core;

/**
 * size, a class to told you how big the object is
 */
public class Size {
    int width, height;

    /**
     * make a Size object
     */
    public Size(int w, int h) {
        this.width = w;
        this.height = h;
    }

    /**
     * get width of the object
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * get height of object
     */
    public int getHeight() {
        return this.height;
    }
}
