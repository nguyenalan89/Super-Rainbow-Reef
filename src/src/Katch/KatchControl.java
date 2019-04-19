package Katch;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KatchControl implements KeyListener {

    private Katch k1;
    private final int right;
    private final int left;


    public KatchControl(Katch k1,int right, int left) {

        this.k1 =k1;
        this.left = left;
        this.right = right;
    }

    @Override
    public void keyTyped(KeyEvent ke) {

    }

    @Override
    public void keyPressed(KeyEvent ke) {
        int keyPressed = ke.getKeyCode();
        if (keyPressed == left) {
            this.k1.toggleLeftPressed();
        }
        if (keyPressed == right) {
            this.k1.toggleRightPressed();
        }


    }

    @Override
    public void keyReleased(KeyEvent ke) {
        int keyReleased = ke.getKeyCode();
        if (keyReleased == left) {
            this.k1.unToggleLeftPressed();
        }
        if (keyReleased == right) {
            this.k1.unToggleRightPressed();
        }

    }
}
