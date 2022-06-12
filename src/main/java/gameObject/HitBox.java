package gameObject;

import core.Position;
import core.Size;

import java.awt.*;

/**
 * hitbox is for scanning is two game object hit together
 */
public class HitBox {
    private static HitBox hitBox;

    private Rectangle rectangle;

    /**
     * create a hitbox
     */
    public HitBox(Position position, Size size) {
        rectangle = new Rectangle(position.getIntX(), position.getIntY(), size.getWidth(), size.getHeight());
    }

    /**
     * create a hitbox which always return "not hit together"
     */
    public static HitBox getNoHittingHitBox() {
        if (hitBox == null) {
            hitBox = new HitBox();
        }
        return hitBox;
    }

    private HitBox() {
        rectangle = new Rectangle();
    }

    /**
     * check is two hitbox hit together and return
     */
    public boolean isHit(HitBox hitBox) {
        boolean isHit;
        if (this.rectangle.isEmpty() || hitBox.getRectangle().isEmpty()) {
            isHit = false;
        } else {
            isHit = this.rectangle.contains(hitBox.getRectangle());
        }
        return isHit;
    }

    /**
     * get a rectangle which size is same with hitbox
     */
    public Rectangle getRectangle() {
        return rectangle;
    }
}
