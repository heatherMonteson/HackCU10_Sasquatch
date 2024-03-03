import java.awt.*;

public class Berries extends GameObject{
    public Berries(int xPos, int yPos) {
        super(xPos, yPos, Enums.Sprite.Berry);
        this.xVel=1;
    }

    @Override
    public void tick() {
        xPos+=xVel;
        yPos+=yVel;
    }

    @Override
    public void render(Graphics2D g)  {
        g.setColor(Color.MAGENTA);
        g.fillRect(xPos, yPos, 32, 32);
    }
}
