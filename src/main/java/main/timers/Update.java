package main.timers;

import config.GameConsts;
import main.Game;
import main.GameLoop;
import main.Timer;

public class Update extends Timer {

    public Update() {
        super(1d / Integer.valueOf(GameConsts.MAX_UPS).doubleValue());
    }

    @Override
    public void action() {
        Game.get().update();

        GameLoop.get().updateTime++;
    }
}
