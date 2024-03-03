import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.io.Serial;
import javax.imageio.ImageIO;
import java.awt.*;

public class Driver extends Canvas implements Runnable{

    @Serial
    private static final long serialVersionUID = -8908591903108801309L;
    public static final int WIDTH = 1200, Height=WIDTH/12*8;
    private Thread thread;
    private boolean running=false;
    private Manager manager;
    private Image backgroundImage; // Image for the background


    public Driver(){
        new Window(WIDTH, Height,"Sass the Quatche's Berry Bad Day", this);
        try {
            backgroundImage = ImageIO.read(getClass().getResource("Images/background"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        manager=new Manager();
        manager.addObject(new Sasquatch(WIDTH/2, Height/2));
        manager.addObject(new Berries(200, 200));
        manager.addObject(new Berries(0, 100));
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

    private void tick(){
     manager.tick();
    }

    public void render(){
        BufferStrategy buffer= this.getBufferStrategy();

        if(buffer==null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics2D graphics = (Graphics2D) buffer.getDrawGraphics();
        graphics.drawImage(backgroundImage, 0, 0, WIDTH, HEIGHT, null);

        graphics.setColor(Color.green);
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
