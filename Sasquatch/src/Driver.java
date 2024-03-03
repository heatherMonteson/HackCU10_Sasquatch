import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serial;
import javax.imageio.ImageIO;
import java.awt.*;
import java.util.Objects;

public class Driver extends Canvas implements Runnable{

    @Serial
    private static final long serialVersionUID = -8908591903108801309L;
    public static final int WIDTH = 1200, Height=WIDTH/12*8;
    private Thread thread;
    private boolean running=false;
    public static Manager manager;
    private Background bg;
    private KeyInput keyInput;
    private Sasquatch sasquatch;
    private Photographer photographer;
    private int count;
    public boolean pic;

    public Driver(){
        new Window(WIDTH, Height,"Sass the Quatch's Berry Bad Day", this);
        pic=false;
        count=0;
        manager=new Manager();

        manager.addObject(new Background(5, 90));

        manager.addObject(new BushL(5, 90));
        manager.addObject(new BushR(500, 90));
        manager.addObject(new BushR(-400, 90));
        manager.addObject(new BushL(200, 90));

        manager.addObject(new Tree(-5, 60));
        manager.addObject(new Tree(745, 60));



        sasquatch=new Sasquatch(250, 325);

        manager.addObject(sasquatch);
        keyInput = new KeyInput(sasquatch);
        this.addKeyListener(keyInput);
        this.setFocusable(true);
    }

    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;
    }

    public synchronized void stop(){
        try {
            thread.join();
            running=false;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void tick() {
        count++;
        manager.tick();

        // Check for collision between berries and photographer
        for (GameObject obj : manager.getObjects()) {
            if (obj instanceof Berries) {
                for (GameObject obj2 : manager.getObjects()) {
                    if (obj2 instanceof Photographer) {
                        if (((Berries) obj).getBounds().intersects(((Photographer) obj2).getBounds())) {

                            manager.removeObject(obj2);
                            manager.removeObject(obj);
                            break;
                        }
                    }
                }
            }
        }

        if (count % 297 == 0) {
            manager.addObject(new Photographer(1000, 250));
        }
    }

    public void render(){
        BufferStrategy buffer= this.getBufferStrategy();

        if(buffer==null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D graphics = (Graphics2D) buffer.getDrawGraphics();
        graphics.fillRect(0,0,WIDTH, Height);

        manager.render(graphics);
        graphics.dispose();
        buffer.show();
    }



    @Override
//    https://www.youtube.com/watch?v=1gir2R7G9ws
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks= 60.0; //frames per second
        double ns = 1000000000/amountOfTicks;
        double delta =0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running){
            long now = System.nanoTime();
            delta = delta+ (now-lastTime)/ns;
            lastTime=now;
            //updates information about character position
            while (delta>=1){
                tick();
                delta--;
            }
            //update visuals from position update
            if(running)
                render();
            frames=frames+1;
            if(System.currentTimeMillis()-timer>1000){
                timer= timer+1000;
                System.out.println("FPS"+frames);
                frames=0;
            }

        }
    }
}
