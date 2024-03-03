import java.awt.*;

public class Berries extends GameObject{
    Image berries = Toolkit.getDefaultToolkit().getImage("Images/berryToss.png");

    public Berries(int xPos, int yPos) {
        super(xPos, yPos, Enums.Sprite.Berry);
        this.xVel=5;
    }

    @Override
    public void tick() {
        xPos+=xVel;
        yPos+=yVel;
        xVel=xVel- (1/9);
    }

    @Override
    public void render(Graphics g)  {
        g.drawImage(berries, xPos,yPos,200, 200, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(xPos, yPos, 200, 200); // Adjust the dimensions as needed
    }
}
