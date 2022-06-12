package config;

/**
 * a config for frame
 */
public enum FrmConfig {
    /**
     * config frm size
     */
    WIDTH("800"),

    /**
     * config frm size
     */
    HEIGHT("600"),


    ;

    private String data;

    FrmConfig(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
