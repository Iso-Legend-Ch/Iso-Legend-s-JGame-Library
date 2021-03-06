package frm;

import config.FrmConsts;
import core.Position;
import gameObject.GameObject;

/**
 * Camera! Use it as the camera on your phone
 */
public class Camera {
    private static Camera camera = null;

    private GameObject gameObjectOnFocus = null;
    private Position position;

    private Camera() {
        this.position = new Position(0, 0);
    }

    /**
     * get camera
     */
    public static Camera get() {
        if (camera == null) {
            camera = new Camera();
        }
        return camera;
    }

    /**
     * auto move the camera make the object on center
     */
    public void focusOn(GameObject gameObject) {
        this.gameObjectOnFocus = gameObject;
    }

    public void update() {
        if (gameObjectOnFocus != null) {
            int objCenterX = gameObjectOnFocus.getPosition().getIntX() + (gameObjectOnFocus.getSize().width() / 2);
            int objCenterY = gameObjectOnFocus.getPosition().getIntY() + (gameObjectOnFocus.getSize().height() / 2);

            this.setPosition(objCenterX - (FrmConsts.FRM_SIZE.height() / 2),
                    objCenterY - (FrmConsts.FRM_SIZE.width() / 2));
        }
    }

    /**
     * get the position of camera
     */
    public Position getPosition() {
        return position;
    }
    /**
     * stop following the object on focus
     */
    public void focusOnNothing() {
        gameObjectOnFocus = null;
    }

    /**
     * move the camera
     */
    public void setPosition(Position position) {
        this.position = new Position(position.getIntX(), this.position.getIntY());
    }

    /**
     * move the camera
     */
    public void setPosition(int x, int y) {
        this.setPosition(new Position(x, y));
    }

    /**
     * get the object which is on focus
     */
    public GameObject getGameObjectOnFocus() {
        return gameObjectOnFocus;
    }
}
