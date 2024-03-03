import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Sasquatch extends GameObject{

    Image sas;
    Image sasStanding =Toolkit.getDefaultToolkit().getImage("Images/squatchA.png");
    private ArrayList<Image> throwingAnimation;
    private int throwIndex;
    private boolean tossing;

    public Sasquatch(int xPos, int yPos) {
        super(xPos, yPos, Enums.Sprite.Sasquatch);
         sas= sasStanding;
        throwingAnimation = new ArrayList<>();
        throwIndex = 0;
        tossing = false;
        loadThrowingAnimation(); // Load throwing animation images
    }

    private void loadThrowingAnimation() {
        ArrayList<String> preFilledList = new ArrayList<>(Arrays.asList("A","B", "B","C","C","D","D", "E","E", "F", "F", "D", "D", "C", "C", "B","B", "A"));

        for (String imgLetter : preFilledList) {
             String fileName = "Images/squatch" + imgLetter + ".png";
             sas= Toolkit.getDefaultToolkit().getImage(fileName);
             throwingAnimation.add(sas);
         }
    }

    public void startThrowingAnimation() {
        tossing = true;
        throwIndex = 0; // Start from the beginning of the animation
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        if (tossing && throwIndex < throwingAnimation.size()) {
            // If tossing, render throwing animation
            Image currentImage = throwingAnimation.get(throwIndex);
            g.drawImage(currentImage, xPos, yPos, 300, 300, null);
            throwIndex++;

            if(throwIndex==12){
                Driver.manager.addObject(new Berries(375, 300));
            }

            // If throwIndex exceeds the animation size, stop tossing
            if (throwIndex >= throwingAnimation.size()) {
                tossing = false;
                throwIndex = 0; // Reset throwIndex for the next toss
            }
        } else {
            // If not tossing, render standing image
            g.drawImage(sasStanding, xPos, yPos, 300, 300, null);
        }
    }



}

