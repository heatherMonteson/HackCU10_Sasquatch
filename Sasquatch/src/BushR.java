import java.awt.*;

public class BushR extends GameObject{

    Image bush2= Toolkit.getDefaultToolkit().getImage("Images/bush2.png");

    public BushR(int xPos, int yPos) {
        super(xPos, yPos, Enums.Sprite.Bush);
    }
    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bush2, xPos,yPos,1000, 650, null);
    }
}
