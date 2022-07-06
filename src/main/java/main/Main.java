package main;

import config.GameConsts;
import core.Position;
import frm.Frm;
import gameObject.gameObjs.defaultObj.Text;
import gameObject.gameObjs.sysObjs.FPS;
import gameObject.gameObjs.Player;
import gameObject.gameObjs.sysObjs.UPS;
import input.KeyInput;
import input.MouseInput;

/**
 * main method here, and control here
 */
public class Main {
    private static Main main = null;

    private Main() {
    }

    public static Main get() {
        if (main == null) {
            main = new Main();
        }
        return main;
    }

    public static void main(String[] args) {
        Main.get().start();
    }

    private void start() {
        Thread thread = new Thread(GameLoop.get());
        thread.start();

        this.sysSetup();

        // do something under this 
        Game.get().addObject(Player.get());
    }

    private void sysSetup() {
        Frm frm = Frm.get();
        frm.addKeyListener(KeyInput.get());
        frm.addMouseListener(MouseInput.get());
        frm.addMouseMotionListener(MouseInput.get());

        if (GameConsts.DEBUG_MODE) {
            Game.get().addGui(new Text("You are in debug mode!", new Position(0, 5)));
            Game.get().addGui(FPS.get());
            Game.get().addGui(UPS.get());
        }
    }
}
