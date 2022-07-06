package main;

public abstract class Timer {
    private final double updateRate;
    double lastUpdate, currentTimeMillis;
    double accumulator = 0;

    public Timer(double updateRate) {
        this.updateRate = updateRate;
        lastUpdate = System.currentTimeMillis();
    }

    public void update() {
        currentTimeMillis = System.currentTimeMillis();
        accumulator += currentTimeMillis - lastUpdate;
        lastUpdate = currentTimeMillis;
        if (accumulator > updateRate * 1000d) {
            action();
            accumulator -= updateRate * 1000d;
        }
    }

    public abstract void action();
}
