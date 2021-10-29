package engine.control;

import java.awt.event.KeyEvent;

public class MouvementController extends Controller{
    private int upkey = KeyEvent.VK_UP;
    private int downKey = KeyEvent.VK_DOWN;
    private int leftkey = KeyEvent.VK_LEFT;
    private int rightKey = KeyEvent.VK_RIGHT;


    public MouvementController() {
        int[] key = {upkey,downKey,leftkey,rightKey} ;
        bindKeys(key);
    }

    public boolean isLeftPressed() {
        return isKeypresssed(leftkey);
    }

    public boolean isRightPressed() {
        return isKeypresssed(rightKey);
    }

    public boolean isUpPressed() {
        return isKeypresssed(upkey);
    }

    public boolean isDownPressed() {
        return isKeypresssed(downKey);
    }

    public void setUpkey(int upkey) {
        removeKey(this.upkey);
       bindKey(upkey);
       this.upkey = upkey;
    }

    public boolean isMoving() {  // on controle si le movement est bien effectué
        return isLeftPressed() || isDownPressed() || isUpPressed() || isRightPressed();
    }

    public void setDownKey(int downKey) {
        removeKey(this.downKey);
        bindKey(downKey);
        this.downKey = downKey;
    }

    public void setLeftkey (int leftkey) {
        removeKey(this.leftkey);
        bindKey(leftkey);
        this.leftkey= leftkey;
    }

    public void setRightKey(int rightKey) {
        removeKey(this.rightKey);
        bindKey(rightKey);
        this.rightKey = rightKey;
    }
}
