package main;

import frm.Frm;
import main.timers.Render;
import main.timers.Stat;
import main.timers.Update;

import java.util.ArrayList;

/**
 * a loop
 */
public class GameLoop implements Runnable {
    private static GameLoop gameloop = null;

    private boolean running;
    public int updateTime, renderTime;
    public int fps, ups;

    private ArrayList<Timer> timers = new ArrayList<>();

    private GameLoop() {
    }

    public static GameLoop get() {
        if (gameloop == null) {
            gameloop = new GameLoop();
        }
        return gameloop;
    }

    @Override
    public void run() {
        Frm frm = Frm.get(0);
        frm.show();

        Timer upsTimer = new Update();
        Timer fpsTimer = new Render();
        Timer statTimer = new Stat();

        timers.add(upsTimer);
        timers.add(fpsTimer);
        timers.add(statTimer);

        running = true;
        while (running) {
            timers.forEach(timer -> timer.update());
        }
    }

    public int getFps() {
        return fps;
    }

    public int getUps() {
        return ups;
    }
}
