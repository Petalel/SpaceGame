import greenfoot.*;  

public class Explode  extends Move 
{
    
    private int timer = 10;
    
    public void act() 
    {
        timer--;
         
        if (timer <= 0) {
                getWorld().removeObject(this);
            }
    }  
    
}
