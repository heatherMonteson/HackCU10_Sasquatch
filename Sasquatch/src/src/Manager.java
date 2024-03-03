import java.awt.*;
import java.util.LinkedList;

public class Manager {

    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    public void render(Graphics2D g){
        int len= gameObjects.size();

        for (int i=0; i<len;  i++){
            GameObject temp = gameObjects.get(i);
            temp.render(g);
        }
    }

    public void tick(){
        int len= gameObjects.size();
        for (int i=0; i<len;  i++){
            GameObject temp = gameObjects.get(i);
            temp.tick();
        }
    }

    public void addObject(GameObject object){
        this.gameObjects.add((object));
    }

    public void removeObject(GameObject object){
        this.gameObjects.remove((object));
    }
}
