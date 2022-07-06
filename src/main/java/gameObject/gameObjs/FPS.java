package gameObject.gameObjs;

import config.FrmConsts;
import core.Position;
import core.Size;
import gameObject.GameObject;
import main.GameLoop;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * an object for FPS displaying
 */
public class FPS extends GameObject {
    int loopFps;

    private static FPS fps = null;

    private FPS() {
        this.position = new Position(0, 0);
        this.size = FrmConsts.FRM_SIZE;
    }

    public static FPS get() {
        if (fps == null) {
            fps = new FPS();
        }
        return fps;
    }

    @Override
    public void update() {
        loopFps = GameLoop.get().getFps();
    }

    @Override
    public Image render() {
        Image image = new BufferedImage(FrmConsts.FRM_SIZE.getWidth()
                , FrmConsts.FRM_SIZE.getHeight()
                , BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.drawString("FPS: " + loopFps, 0, 10);
        graphics.dispose();

        return image;
    }

    @Override
    public void mouseClick() {

    }
}
