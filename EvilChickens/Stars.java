import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This makes stars appear on each side of the road and random points.
 * @author Hubert Jackson Black III
 * @version v0.10
 */
public class Stars  extends Move
{
    
    public void act() // main for the stars it will keep doing these over and over
    {
        starsMove();
        starsGone();
    }  
    
    public void starsMove() //this moves the stars down the screen. I added a speed still working out bugs to make the trees move faster or slower depending on up or down.
    {
        setLocation(getX(), getY() + speed);   // was trying to adjust speed. work in progress variable does not seem to change.
        checkDoubleStar();
    }
    
     public void checkDoubleStar() // removes stars if they spawn on top of eachother.
     {
         Actor star = getOneIntersectingObject(Stars.class);
         if(star != null)
         {
             getWorld().removeObject(star);
         }
     }
    
     public void starsGone() // removes stars when they reach the bottom of the world.
     {
         if(getY() >= getWorld().getHeight() -1)
         {
             getWorld().removeObject(this);
         }
     }
}

