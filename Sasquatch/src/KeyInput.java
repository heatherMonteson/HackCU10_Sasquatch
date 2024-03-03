import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {

    private Sasquatch sasquatch;

    public KeyInput(Sasquatch sasquatch) {
        this.sasquatch = sasquatch;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_SPACE) {
            sasquatch.startThrowingAnimation();
        }
    }

    // Implement other KeyListener methods if needed

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}