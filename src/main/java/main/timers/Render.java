package main.timers;

import config.GameConfig;
import main.Game;
import main.GameLoop;
import main.Timer;

public class Render extends Timer {
    public Render() {
        super(1d / Integer.valueOf(GameConfig.MAX_FPS.getData()).doubleValue());
    }

    @Override
    public void action() {
        Game.get().render();

        GameLoop.get().renderTime++;
    }
}
