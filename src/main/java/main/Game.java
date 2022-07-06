package main;

import config.FrmConsts;
import core.Position;
import frm.Camera;
import frm.Frm;
import gameObject.GameObject;
import gameObject.HitBox;
import input.MouseInput;

import java.awt.*;
import java.util.ArrayList;

/**
 * most of the logic here
 */
public class Game {
    private static Game game = null;

    private final ArrayList<GameObject> objects = new ArrayList<>();
    private final ArrayList<GameObject> guis = new ArrayList<>();

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
        Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().fillRect(0, 0, FrmConsts.FRM_SIZE.getWidth(), FrmConsts.FRM_SIZE.getHeight());

        objects.forEach(gameObject -> {
            if (new HitBox(Camera.get().getPosition(), FrmConsts.FRM_SIZE).isHit(new HitBox(gameObject.getPosition(), gameObject.getSize()))) {
                int x = gameObject.getPosition().getIntX() - Camera.get().getPosition().getIntX();
                int y = gameObject.getPosition().getIntY() - Camera.get().getPosition().getIntY();
                Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().drawImage(gameObject.render(), x, y, null);
            }
        });

        guis.forEach(gameObject -> {
            if (new HitBox(new Position(0, 0), FrmConsts.FRM_SIZE).isHit(new HitBox(gameObject.getPosition(), gameObject.getSize()))) {
                int x = gameObject.getPosition().getIntX() - Camera.get().getPosition().getIntX();
                int y = gameObject.getPosition().getIntY() - Camera.get().getPosition().getIntY();
                Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().drawImage(gameObject.render(), x, y, null);
            }
        });

        Frm.get().getCanvas().getBufferStrategy().getDrawGraphics().dispose();
        Frm.get().getCanvas().getBufferStrategy().show();
    }

    public void update() {
        if (MouseInput.get().isClicked()) {
            objects.forEach(GameObject::mouseClick);
            guis.forEach(GameObject::mouseClick);
            MouseInput.get().resetClickStat();
        }
        objects.forEach(GameObject::update);
        guis.forEach(GameObject::update);
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
        objects.remove(gameObject);
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
        guis.remove(gameObject);
    }
}
