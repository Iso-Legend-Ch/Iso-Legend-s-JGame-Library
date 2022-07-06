package main.timers;

import config.GameConsts;
import main.Game;
import main.GameLoop;
import main.Timer;

public class Render extends Timer {
    public Render() {
        super(1d / Integer.valueOf(GameConsts.MAX_FPS).doubleValue());
    }

    @Override
    public void action() {
        Game.get().render();

        GameLoop.get().renderTime++;
    }
}
