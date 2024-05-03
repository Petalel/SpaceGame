import greenfoot.*;

public class Heart extends Actor {

    public Heart() {
        GreenfootImage heartImage = new GreenfootImage("heart.png");
                heartImage.scale(heartImage.getWidth() / 10, heartImage.getHeight() / 10); // Scale the image to half its original size
// Assuming "heart.png" is the image file for the heart icon
        setImage(heartImage);
    }
}