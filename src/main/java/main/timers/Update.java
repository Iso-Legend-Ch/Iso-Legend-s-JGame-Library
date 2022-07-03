package main.timers;

import config.GameConfig;
import main.Game;
import main.GameLoop;
import main.Timer;

public class Update extends Timer {

    public Update() {
        super(1d / Integer.valueOf(GameConfig.MAX_UPS.getData()).doubleValue());
    }

    @Override
    public void action() {
        Game.get().update();

        GameLoop.get().updateTime++;
    }
}
