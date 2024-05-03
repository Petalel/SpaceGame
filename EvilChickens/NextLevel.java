import greenfoot.*; 

public class NextLevel extends World
{
    
    public NextLevel()
    {    
        super(600, 600, 1);
        GreenfootImage title = new GreenfootImage("Congrats!", 36, Color.GREEN, new Color(0, 0, 0, 0)); // Red color text with a transparent background
        getBackground().drawImage(title, getWidth() / 2 - title.getWidth() / 2, getHeight() / 2 - 190);
    
        showText("Lets go to the next level!", getWidth() / 2, getHeight() / 2 +0);
         showText("Try killing 50 chickens", getWidth() / 2, getHeight() / 2 + 30);
        showText("Score: " + Spaceship.score, getWidth() / 2, getHeight() / 2 - 100);        
        
        GreenfootImage startText = new GreenfootImage("Press SPACE to move to the next level", 26, Color.WHITE, new Color(0, 0, 0, 0)); // Yellow color text
        getBackground().drawImage(startText, getWidth() / 2 - startText.getWidth() / 2, getHeight() / 2 + 150);

        Greenfoot.start();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new newWorld());

    }
    
}