import greenfoot.*;  
import java.util.List;

public class Chicken extends Actor {
    
    private GreenfootImage[] images;
    private int imageIndex;
    private int animationCycle;

    public Chicken() {
        images = new GreenfootImage[5];  // Assuming you have 5 images
        for (int i = 0; i < images.length; i++) {
            images[i] = new GreenfootImage("Chicken" + (i + 1) + ".png");
            int newWidth = images[i].getWidth() / 4;
            int newHeight = images[i].getHeight() / 4;
            images[i].scale(newWidth, newHeight);
        }
        setImage(images[0]);  // Set the initial image
        imageIndex = 0;
        animationCycle = 0;
    }

    public void act() {
        animateMovement();
        driveDown();
        if (getY() >= getWorld().getHeight() - 1) {
            getWorld().removeObject(this);
        } else {
            checkLaserCollision();
        }
    }

      private void drawDebug() {
        GreenfootImage img = getImage();
        img.setColor(Color.RED);
        img.drawRect(0, 0, img.getWidth() - 1, img.getHeight() - 1);
        setImage(img);
    }
    private void animateMovement() {
        animationCycle++;
        if (animationCycle % 5 == 0) {  
            imageIndex = (imageIndex + 1) % images.length;
            setImage(images[imageIndex]);
        }
    }

    private void driveDown() {
        setLocation(getX(), getY() + 3);
    }

    private void checkLaserCollision2() {
        Laser laser = (Laser) getOneIntersectingObject(Laser.class);
        if (laser != null) {
            explodeAndScore();
            laser.removeLaser();
        }
    }
    
    

    private void checkLaserCollision() {
    List<Laser> lasers = getIntersectingObjects(Laser.class);
    for (Laser laser : lasers) {
        // Get bounds of the chicken
        int chickenMinX = getX() - getImage().getWidth() / 2;
        int chickenMaxX = getX() + getImage().getWidth() / 2;
        int chickenMinY = getY() - getImage().getHeight() / 2;
        int chickenMaxY = getY() + getImage().getHeight() / 2;

        // Get bounds of the laser
        int laserMinX = laser.getX() - laser.getImage().getWidth() / 2;
        int laserMaxX = laser.getX() + laser.getImage().getWidth() / 2;
        int laserMinY = laser.getY() - laser.getImage().getHeight() / 2;
        int laserMaxY = laser.getY() + laser.getImage().getHeight() / 2;

        // Check for actual overlap
        if ((laserMaxX >= chickenMinX && laserMinX <= chickenMaxX) &&
            (laserMaxY >= chickenMinY && laserMinY <= chickenMaxY)) {
            explodeAndScore();
            laser.removeLaser();
            break; // Stop checking after the first collision to avoid multiple scoring from a single laser
        }
    }
}


    private void explodeAndScore() {
        Explode explosion = new Explode();
        getWorld().addObject(explosion, getX(), getY());
        Greenfoot.playSound("bomb.wav");
        explosion.act();  
        getWorld().removeObject(this);
        Spaceship.score++;
    }
}
