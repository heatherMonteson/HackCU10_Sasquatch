import java.awt.*;

public class Tree extends GameObject{
    Image tree = Toolkit.getDefaultToolkit().getImage("Images/tree.png");

    public Tree(int xPos, int yPos) {
        super(xPos, yPos, Enums.Sprite.Tree);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g)  {
        g.drawImage(tree, xPos,yPos,450, 650, null);
    }
}
