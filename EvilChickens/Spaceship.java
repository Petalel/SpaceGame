import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot, and MouseInfo)
import java.util.List;

public class Spaceship extends Actor {
    
    private GreenfootImage[] images;
    private int imageIndex;
    private int animationCycle;
    private int gunDelay;
    private int minGunDelay;
    private int damage;
    public static int score;
    public static int lifes = 3;
    
    public Spaceship() {
        damage = 97;
        gunDelay = 0;
        minGunDelay = 20;
        images = new GreenfootImage[4];  // Adjust the size if more images are used
        images[0] = new GreenfootImage("images/spaceship1.png");
        images[1] = new GreenfootImage("images/spaceship2.png");
        images[2] = new GreenfootImage("images/spaceship3.png");
        images[3] = new GreenfootImage("images/spaceship2.png");
    
    
        // Scale images to 50% of their original size
        int scalePercent = 30; 
        for (int i = 0; i < images.length; i++) {
            int newWidth = images[i].getWidth() * scalePercent / 100;
            int newHeight = images[i].getHeight() * scalePercent / 100;
            images[i].scale(newWidth, newHeight);
        }
    
        setImage(images[0]);  // Set initial image
        imageIndex = 0;
        animationCycle = 0;
    }
        
    public void act() {
        checkKeyPress();
        checkCollision();
        updateGunDelay();
        animate();
    }

    
    private void animate() {
        animationCycle++;
        if (animationCycle % 3 == 0) {  // Change image every 3 acts
            imageIndex = (imageIndex + 1) % images.length;
            setImage(images[imageIndex]);
        }
    }
    
    public void checkCollision2() {
        Actor actor = getOneIntersectingObject(Chicken.class);
        if (actor != null) {
            lifes--;
            getWorld().removeObject(actor);
            Greenfoot.playSound("crash.wav");
        }
        if (lifes <= 0) {
            Greenfoot.stop();
            restartLifes();
            restartScore();
        }
    }
    

    public void checkCollision() {
        List<Chicken> chickens = getIntersectingObjects(Chicken.class);
        for (Chicken chicken : chickens) {
            // Calculate the boundaries of the spaceship
            
            int spaceshipMinX = getX() - getImage().getWidth() / 2;
            int spaceshipMaxX = getX() + getImage().getWidth() / 2;
            int spaceshipMinY = getY() - getImage().getHeight() / 2;
            int spaceshipMaxY = getY() + getImage().getHeight() / 2;
    
            // Calculate the boundaries of the chicken
            int chickenMinX = chicken.getX() - chicken.getImage().getWidth() / 2;
            int chickenMaxX = chicken.getX() + chicken.getImage().getWidth() / 2;
            int chickenMinY = chicken.getY() - chicken.getImage().getHeight() / 2;
            int chickenMaxY = chicken.getY() + chicken.getImage().getHeight() / 2;
    
            // Check if there is an overlap
            if ((chickenMaxX >= spaceshipMinX && chickenMinX <= spaceshipMaxX) &&
                (chickenMaxY >= spaceshipMinY && chickenMinY <= spaceshipMaxY)) {
                lifes--;
                getWorld().removeObject(chicken);
                Greenfoot.playSound("crash.wav");
                break;  // Exit the loop after processing the first collision
            }
        }
}

    
    public void moveLeft() {
        if(getX() > 210) {  // Adjust the boundary to fit your world's layout
            setLocation(getX() - 5, getY());  // Increased movement speed for more responsiveness
        }
    }

    public void moveRight() {
        if(getX() < 390) {  // Adjust the boundary to fit your world's layout
            setLocation(getX() + 5, getY());  // Increased movement speed for more responsiveness
        }
    }

   
    public void moveUp() {
        if(getY() > 100) {  // Adjust based on your game's upper boundary needs
            setLocation(getX(), getY() - 5);
        }
    }

    public void moveDown() {
        if(getY() < 500) {  // Adjust based on your game's lower boundary needs
            setLocation(getX(), getY() + 5);
        }
    }

    public void fire() {
        if(gunDelay == 0) {
            Laser laser = new Laser();
            getWorld().addObject(laser, getX(), getY() - getImage().getHeight() / 2);
            gunDelay = minGunDelay;
        }
    }
    
    private void updateGunDelay() {
        if (gunDelay > 0) {
            gunDelay--;
        }
    }

    public void checkKeyPress() {
        if(Greenfoot.isKeyDown("left")) {
            moveLeft();
        }
        if(Greenfoot.isKeyDown("right")) {
            moveRight();
        }
        if(Greenfoot.isKeyDown("up")) {
            moveUp();
        }
        if(Greenfoot.isKeyDown("down")) {
            moveDown();
        }
        if(Greenfoot.isKeyDown("space")) {
            fire();
        }
        // Removed 'e' key press functionality for music to simplify the example
    }

    public void restartScore() {
        score = 0;
    }
    
    public void restartLifes() {
        lifes = 3;
    }

    public int getScore() {
        return score;
    }

    public int getLifes() {
        return lifes;
    }
    
}
