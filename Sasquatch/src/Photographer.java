import java.awt.*;

public class Photographer extends GameObject{

    Image photographer = Toolkit.getDefaultToolkit().getImage("Images/photo.png");
    int count;
    boolean pic;

    public Photographer(int xPos, int yPos) {
        super(xPos, yPos, Enums.Sprite.BushPhotographer);
        count=0;
        pic=true;
    }

    @Override
    public void tick() {
        if(count>=200){
            pic=false;
            xPos+=2;
        }

        if(xPos>600 && pic){
            xPos-=2;
        }
        count++;
    }

    @Override
    public void render(Graphics g)  {
        g.drawImage(photographer, xPos,yPos,300, 400, null);

    }

    public Rectangle getBounds() {
        return new Rectangle(xPos+200, yPos, 300, 400); // Adjust the dimensions as needed
    }
}
