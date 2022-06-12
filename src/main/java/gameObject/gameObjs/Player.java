package gameObject.gameObjs;

import core.Position;
import core.Size;
import gameObject.GameObject;
import input.MouseInput;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * a simple object for testing, and it'll follow your mouse
 */
public class Player extends GameObject {

    private static Player player = null;

    private Player() {
        this.size = new Size(50, 50);
    }

    public static Player get() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    @Override
    public void update() {
        //this.position = new Position(50,50);
        this.position = new Position(MouseInput.get().getMousePosition().getX(), MouseInput.get().getMousePosition().getY());
    }

    @Override
    public Image render() {
        Image image = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, 50, 50);
        graphics.dispose();

        return image;
    }

    @Override
    public void mouseClick() {

    }
}
