import greenfoot.*; 

public class GameOver extends World
{
 
    public GameOver()
    {    
        super(600, 600, 1);
        GreenfootImage title = new GreenfootImage("GAME OVER", 36, Color.RED, new Color(0, 0, 0, 0)); // Red color text with a transparent background
        getBackground().drawImage(title, getWidth() / 2 - title.getWidth() / 2, getHeight() / 2 - 190);
    
        showText("So sorry that you lost!", getWidth() / 2, getHeight() / 2 +0);
        showText("Do not leave evil chickens win", getWidth() / 2, getHeight() / 2 + 25 );
        showText("Score: " + Spaceship.score, getWidth() / 2, getHeight() / 2 - 100);  
        
        GreenfootImage startText = new GreenfootImage("Press SPACE to restart", 26, Color.WHITE, new Color(0, 0, 0, 0)); // Yellow color text
        getBackground().drawImage(startText, getWidth() / 2 - startText.getWidth() / 2, getHeight() / 2 + 150);

        Greenfoot.start();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new newWorld());
    }
}