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
public class UPS extends GameObject {
    int loopUps;

    private static UPS ups = null;

    private UPS() {
        this.position = new Position(0, 35);
        this.size = new Size(1, 1);
    }

    public static UPS get() {
        if (ups == null) {
            ups = new UPS();
        }
        return ups;
    }

    @Override
    public void update() {
        loopUps = GameLoop.get().getUps();
    }

    @Override
    public Image render() {
        String text = "UPS: " + loopUps;
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
