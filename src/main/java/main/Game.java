package main;

import config.FrmConfig;
import frm.Camera;
import frm.Frm;
import gameObject.GameObject;
import input.MouseInput;

import java.awt.*;
import java.util.ArrayList;

/**
 * most of the logic here
 */
public class Game {
    private static Game game = null;

    private ArrayList<GameObject> objects = new ArrayList<>();
    private ArrayList<GameObject> guis = new ArrayList<>();

    private Game() {
    }

    /**
     * get game object
     */
    public static Game get() {
        if (game == null) {
            game = new Game();
        }
        return game;
    }

    public void render() {
        Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().setColor(Color.black);
        Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().fillRect(0, 0, Integer.valueOf(FrmConfig.WIDTH.getData()), Integer.valueOf(FrmConfig.HEIGHT.getData()));

        objects.forEach(gameObject -> {
            int x = gameObject.getPosition().getIntX() - Camera.get().getPosition().getIntX();
            int y = gameObject.getPosition().getIntY() - Camera.get().getPosition().getIntY();
            Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().drawImage(gameObject.render(), x, y, null);
        });

        guis.forEach(gameObject -> {
            int x = gameObject.getPosition().getIntX();
            int y = gameObject.getPosition().getIntY();
            Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().drawImage(gameObject.render(), x, y, null);
        });

        Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().dispose();
        Frm.get().getCanvas().getBufferStrategy().show();
    }

    public void update() {
        if (MouseInput.get().isClicked()) {
            objects.forEach(gameObject -> gameObject.mouseClick());
            guis.forEach(gameObject -> gameObject.mouseClick());
            MouseInput.get().resetClickStat();
        }
        objects.forEach(gameObject -> gameObject.update());
        guis.forEach(gameObject -> gameObject.update());
        Camera.get().update();
    }

    /**
     * add a gameObject to frame
     */
    public void addObject(GameObject gameObject) {
        objects.add(gameObject);
    }

    /**
     * delete a gameObject
     */
    public void deleteObject(GameObject gameObject) {
        if (objects.contains(gameObject)) {
            objects.remove(gameObject);
        }
    }

    /**
     * add a gui to frame (always above all gameObject)
     */
    public void addGui(GameObject gameObject) {
        guis.add(gameObject);
    }

    /**
     * delete a gui
     */
    public void deleteGui(GameObject gameObject) {
        if (guis.contains(gameObject)) {
            guis.remove(gameObject);
        }
    }
}
