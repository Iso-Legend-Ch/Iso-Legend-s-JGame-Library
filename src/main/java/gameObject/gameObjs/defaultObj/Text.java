package gameObject.gameObjs.defaultObj;

import core.Position;
import core.Size;
import gameObject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * an object to display some text
 */
public class Text extends GameObject {
    String text;

    public Text(String text, Position position) {
        super();
        this.position = position;
        this.text = text;
        FontMetrics fontMetrics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics().getFontMetrics();
        this.size = new Size(fontMetrics.stringWidth(text), fontMetrics.getFont().getSize());
    }

    @Override
    public void update() {
    }

    @Override
    public Image render() {
        Image image = new BufferedImage(size.width(), size.height(), BufferedImage.TYPE_INT_ARGB);

        image.getGraphics().drawString(text, 0, 10);
        image.getGraphics().dispose();

        return image;
    }

    @Override
    public void mouseClick() {
    }

    public void setText(String text) {
        this.text = text;
        FontMetrics fontMetrics = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB).getGraphics().getFontMetrics();
        this.size = new Size(fontMetrics.stringWidth(text), fontMetrics.getFont().getSize());
    }
}
