import greenfoot.*; 

public class WinGame extends World
{
 
    public WinGame()
    {    
        super(600, 600, 1);
    
        GreenfootImage title = new GreenfootImage("YOU WON", 36, Color.GREEN, new Color(0, 0, 0, 0));
        getBackground().drawImage(title, getWidth() / 2 - title.getWidth() / 2, getHeight() / 2 - 190);
    
        showText("Congratulations you are the hero!", getWidth() / 2, getHeight() / 2 +0);
        showText("Now the space is free from evil chickens", getWidth() / 2, getHeight() / 2 + 25 );
        showText("Score: " + Spaceship.score, getWidth() / 2, getHeight() / 2 - 100);  // Assuming score is kept in Spaceship class
       
        GreenfootImage startText = new GreenfootImage("Press SPACE to restart the game", 26, Color.WHITE, new Color(0, 0, 0, 0)); // Yellow color text
        getBackground().drawImage(startText, getWidth() / 2 - startText.getWidth() / 2, getHeight() / 2 + 150);
        
        Greenfoot.start();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new newWorld());
    }
}