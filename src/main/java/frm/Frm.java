package frm;

import config.FrmConsts;
import config.GameConsts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

/**
 * Frm, a good thing you can display thing to user
 */
public class Frm {
    private static ArrayList<Frm> frm = null;

    public JFrame frame;
    public Canvas canvas;

    private Frm() {
        frame = new JFrame();
        frame.setVisible(false);
        frame.setResizable(false);

        canvas = new Canvas();
        canvas.setFocusable(false);
        canvas.setSize(new Dimension(FrmConsts.FRM_SIZE.getWidth(), FrmConsts.FRM_SIZE.getHeight()));

        frame.setTitle(GameConsts.FRM_TITLE);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(canvas);
        frame.setLocation(100, 100);
        frame.pack();

        canvas.createBufferStrategy(3);
    }

    /**
     * get frm with a number (0 is for main game loop)
     */
    public static Frm get(int frameNum) {
        if (frm == null) {
            frm = new ArrayList<>();
        }
        if (frm.size() <= frameNum) {
            for (int i = frm.size(); i <= frameNum; i++) {
                frm.add(new Frm());
            }
        }
        return frm.get(frameNum);
    }

    /**
     * get frm of main game loop
     */
    public static Frm get() {
        return Frm.get(0);
    }

    /**
     * make frm visible
     */
    public void show() {
        frame.setVisible(true);
    }

    /**
     * get the canvas of the frm
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * add a keyListener for your frm
     */
    public void addKeyListener(KeyListener keyListener) {
        this.frame.addKeyListener(keyListener);
    }

    /**
     * add a mouseListener for your frm
     */
    public void addMouseListener(MouseListener mouseListener) {
        this.canvas.addMouseListener(mouseListener);
    }

    /**
     * add a mouseMotionListener for your frm
     */
    public void addMouseMotionListener(MouseMotionListener mouseMotionListener) {
        this.canvas.addMouseMotionListener(mouseMotionListener);
    }
}
