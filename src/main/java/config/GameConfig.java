package config;

/**
 * a config for the game
 */
public enum GameConfig {
    /**
     * sorry but not done yet
     */
    DEBUG_MODE("true"),

    /**
     * yes, and I will add MAX_UPS later
     */
    MAX_FPS("100"),

    /**
     * just the default title of frame
     */
    FRM_TITLE("Game"),
    ;

    private String data;

    GameConfig(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
