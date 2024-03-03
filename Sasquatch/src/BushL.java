import java.awt.*;

public class BushL extends GameObject{
    Image bush1 = Toolkit.getDefaultToolkit().getImage("Images/bush1.png");

    public BushL(int xPos, int yPos) {
        super(xPos, yPos, Enums.Sprite.Bush);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(bush1, xPos,yPos,1000, 650, null);
    }
}
