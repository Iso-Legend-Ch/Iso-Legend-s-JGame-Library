package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/**
 * implements keyListener to know what keyInput
 */
public class KeyInput implements KeyListener {
    private static KeyInput keylistenerimpl = null;

    private ArrayList<Boolean> isPressed;

    private KeyInput() {
        isPressed = new ArrayList<>();
    }

    public static KeyInput get() {
        if (keylistenerimpl == null) {
            keylistenerimpl = new KeyInput();
        }
        return keylistenerimpl;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void setStat(int code, boolean stat) {
        if (isPressed.size() - 1 < code) {
            for (int i = 0; code + 1 - isPressed.size() >= 1; i++) {
                isPressed.add(false);
            }
        }
        isPressed.set(code, stat);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.setStat(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.setStat(e.getKeyCode(), true);
    }

    public boolean isKeyPressed(int keyCode) {
        return isPressed.get(keyCode);
    }
}
