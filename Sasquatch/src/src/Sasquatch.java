import java.awt.*;

public class Sasquatch extends GameObject{
    public Sasquatch(int xPos, int yPos) {
        super(xPos, yPos, Enums.Sprite.Sasquatch);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.blue);
        g.fillRect(xPos, yPos, 32, 32);
    }
}
