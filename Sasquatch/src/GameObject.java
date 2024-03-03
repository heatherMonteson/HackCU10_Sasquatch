import java.awt.*;

public abstract class GameObject {
    protected int xPos, yPos;
    protected int xVel, yVel;
    protected Enums.Sprite id;

    public GameObject(int xPos, int yPos, Enums.Sprite id){
        this.xPos = xPos;
        this.yPos=yPos;
        this.id=id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public int getXpos(){return xPos;}
    public int getYpos(){return yPos;}
    public int getXvel(){return xVel;}
    public int getYvel(){return yVel;}

    public void setXpos(int pos){this.xPos=pos;}
    public void setYpos(int pos){this.yPos=pos;}
    public void setXvel(int vel){this.xVel=vel;}
    public void setYvel(int vel){this.yVel=vel;}

}

