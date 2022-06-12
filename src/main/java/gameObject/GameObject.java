package gameObject;

import core.Position;
import core.Size;

import java.awt.*;

/**
 * every item show with this class, GameObject
 */
abstract public class GameObject {
    protected Position position;
    protected Size size;
    protected HitBox hitBox;

    /**
     * simple setup for escaping exception
     */
    public GameObject() {
        this.position = new Position(0, 0);
        this.size = new Size(0, 0);
        this.hitBox = HitBox.getNoHittingHitBox();
    }

    /**
     * get position of this object
     */
    public Position getPosition() {
        return position;
    }

    /**
     * get size of this object
     */
    public Size getSize() {
        return size;
    }

    /**
     * get hitbox of this object
     */
    public HitBox getHitBox() {
        return hitBox;
    }

    /**
     * run ups time per sec, for updating stat of object
     */
    public abstract void update();

    /**
     * give game loop the image of object
     */
    public abstract Image render();

    /**
     * this will be called if mouse is clicked
     */
    public abstract void mouseClick();
}
