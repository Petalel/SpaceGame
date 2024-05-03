import greenfoot.*;  
 

public class TitleScreen extends World
{
    public TitleScreen()
    {    
        super(600, 600, 1);
        GreenfootImage title = new GreenfootImage("Welcome to SPACE EVILCHICKENS", 36, Color.YELLOW, new Color(0, 0, 0, 0)); // Red color text with a transparent background
        getBackground().drawImage(title, getWidth() / 2 - title.getWidth() / 2, getHeight() / 2 - 190);
            
        showText("RULES:", getWidth() / 2, getHeight() / 2 - 70);
        showText("1) Use arrow keys to move the aircraft", getWidth() / 2, getHeight() / 2 + 0);
        showText("2) Press SPACE to shoot chickens", getWidth() / 2, getHeight() / 2 + 25);
        showText("3) Avoid letting chickens get close to you", getWidth() / 2, getHeight() / 2 + 50);
            
            
        showText("4) First Level: first goal: 30 chickens", getWidth() / 2, getHeight() / 2 + 80);
    
        GreenfootImage startText = new GreenfootImage("Press SPACE to Start", 36, Color.WHITE, new Color(0, 0, 0, 0)); // Yellow color text
        getBackground().drawImage(startText, getWidth() / 2 - startText.getWidth() / 2, getHeight() / 2 + 150);
    
        Greenfoot.start();
    }
    public void act()
    {
        if (Greenfoot.isKeyDown("space")) Greenfoot.setWorld(new newWorld());
    }
}


