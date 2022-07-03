package main.timers;

import main.GameLoop;
import main.Timer;

public class Stat extends Timer {
    public Stat() {
        super(1d);
    }

    @Override
    public void action() {
        GameLoop.get().fps = GameLoop.get().renderTime;
        GameLoop.get().ups = GameLoop.get().updateTime;
        GameLoop.get().renderTime = 0;
        GameLoop.get().updateTime = 0;

        System.out.println(GameLoop.get().getFps() + "/" + GameLoop.get().getUps());
    }
}
