package main;

import config.GameConfig;
import frm.Frm;

/**
 * a loop
 */
public class GameLoop implements Runnable {
    private static GameLoop gameloop = null;

    private double updateRate = 1d / (double) Integer.valueOf(GameConfig.MAX_FPS.getData());

    private boolean running;
    private int updateTime, renderTime;
    private int fps, ups;
    private double nextStatTime;

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

        running = true;
        double lastUpdate = System.currentTimeMillis(), currentTimeMillis;
        double accumulator = 0;
        nextStatTime = System.currentTimeMillis() + 1000d;
        while (running) {
            currentTimeMillis = System.currentTimeMillis();
            accumulator += currentTimeMillis - lastUpdate;
            lastUpdate = currentTimeMillis;
            if (accumulator > updateRate * 1000d) {
                update();
                render();
                accumulator -= updateRate * 1000d;
            }
            if (nextStatTime < System.currentTimeMillis()) {
                nextStatTime += 1000d;
                stat();
            }
        }
    }

    private void update() {
        Game.get().update();

        updateTime++;
    }

    private void render() {
        Game.get().render();

        renderTime++;
    }

    private void stat() {
        fps = renderTime;
        ups = updateTime;
        renderTime = 0;
        updateTime = 0;

        System.out.println(getFps() + "/" + getUps());
    }

    public int getFps() {
        return fps;
    }

    public int getUps() {
        return ups;
    }
}
