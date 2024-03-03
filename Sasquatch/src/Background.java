import java.awt.*;

public class Background extends GameObject{
     Image sky = Toolkit.getDefaultToolkit().getImage("Images/sky.png");
     Image grass =Toolkit.getDefaultToolkit().getImage("Images/grass.png");
    private int xPos, yPos;
    Background(int xPos, int yPos){
        super(xPos,yPos,Enums.Sprite.Background);
    }

    @Override
    public void tick() {

    }

    public void render(Graphics g) {
        g.drawImage(sky, 0,0,1200, 500, null);
        g.drawImage(grass, 0,600,1200, 500, null);
    }
}
