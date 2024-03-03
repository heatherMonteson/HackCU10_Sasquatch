import javax.swing.*;
import java.awt.*;
import java.io.Serial;

//https://www.youtube.com/watch?v=1gir2R7G9ws

public class Window extends Canvas {

    @Serial
    private static final long serialVersionUID = -8255319694373975038L;

    Window( int w, int h, String title, Driver game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(w,h));
        frame.setMaximumSize(new Dimension(w,h));
        frame.setMinimumSize(new Dimension(w,h));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}
