package gameObject.gameObjs.sysObjs;

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
        this.position = new Position(0, 20);
        this.size = new Size(1, 1);
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
        String text = "FPS: " + loopFps;
        FontMetrics fontMetrics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics().getFontMetrics();
        this.size = new Size(fontMetrics.stringWidth(text), fontMetrics.getFont().getSize());

        Image image = new BufferedImage(size.width()
                , size.height()
                , BufferedImage.TYPE_INT_ARGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.drawString(text, 0, 10);
        graphics.dispose();

        return image;
    }

    @Override
    public void mouseClick() {

    }
}
