import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Move here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Move  extends Actor
{
        public static final double LASER_SPEED = 8.0; // Dosen't do much now but want a speed of the laser.
        public int speed = 4; //sets speed of trees for later use, trying to adjust it but working out bugs.
        
        public void move()
        {
            move(LASER_SPEED);
        }
    
        
        public void move(double distance) // this it what allows me to shoot out of the front of my image/car.
        {
            double angle = Math.toRadians( getRotation() );
           
            int x = (int) Math.round(getX() + Math.cos(angle) * distance);
            int y = (int) Math.round(getY() + Math.sin(angle) * distance);
            setLocation(x, y);
        }
        
    
//     public int fix(int speed)  //work in progress trying to make speed adjustable. trying to make speed adjust the trees so it appears u are going faster.
//     {
//         
//         if(Greenfoot.isKeyDown("up"))
//         {
//             speed++;
//             
//         }
//         if(Greenfoot.isKeyDown("down"))
//         {
//             speed--;
//         }
//         return speed;
//     }
}
