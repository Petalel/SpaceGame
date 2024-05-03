import greenfoot.*;  

public class Laser extends Actor {
    private int life;

    public Laser() {  
        life = 60;
        setImage("shoot.png");  
        resizeImage();
    }

    public void act() { 
        if (life <= 0) {
            getWorld().removeObject(this);
        } else {
            setLocation(getX(), getY() - 7);
            life--;
        }
    }

    public void removeLaser() {
        getWorld().removeObject(this);
    }

    private void drawDebug() {
        GreenfootImage img = getImage();
        img.setColor(Color.RED);  
        img.drawRect(0, 0, img.getWidth() - 1, img.getHeight() - 1);
        setImage(img);
    }

    private void resizeImage() {
        GreenfootImage original = getImage();
        int width = original.getWidth();
        int height = original.getHeight();
        int minX = width, maxX = 0, minY = height, maxY = 0;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (original.getColorAt(x, y).getAlpha() > 0) {
                    if (x < minX) minX = x;
                    if (x > maxX) maxX = x;
                    if (y < minY) minY = y;
                    if (y > maxY) maxY = y;
                }
            }
        }

        
        if (minX <= maxX && minY <= maxY) {
            GreenfootImage croppedImage = new GreenfootImage(maxX - minX + 1, maxY - minY + 1);
            croppedImage.drawImage(original, -minX, -minY);
            setImage(croppedImage);
        }
    }
}
