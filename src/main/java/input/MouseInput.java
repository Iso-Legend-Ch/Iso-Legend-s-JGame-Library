package input;

import core.Position;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * implements mouseListener and mouseMotionListener to know what mouse input
 */
public class MouseInput implements MouseListener, MouseMotionListener {
    private static MouseInput mouseinput = null;

    private boolean isClicked;
    private final ArrayList<Boolean> isPressed;
    private Position mousePosition;

    private MouseInput() {
        isClicked = false;
        isPressed = new ArrayList<>();
        mousePosition = new Position(0, 0);
    }

    public static MouseInput get() {
        if (mouseinput == null) {
            mouseinput = new MouseInput();
        }
        return mouseinput;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void resetClickStat() {
        isClicked = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        isClicked = true;
    }

    private void setStat(int code, boolean stat) {
        for (int i = isPressed.size(); i <= code; i++) {
            isPressed.add(false);
        }
        isPressed.set(code, stat);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.setStat(e.getButton(), true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.setStat(e.getButton(), false);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        mousePosition = new Position(e.getX(), e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mousePosition = new Position(e.getX(), e.getY());
    }

    public Position getMousePosition() {
        return mousePosition;
    }

    public boolean getIsPressed(int keyCode) {
        for (int i = isPressed.size(); i <= keyCode; i++) {
            isPressed.add(false);
        }
        return isPressed.get(keyCode);
    }
}
