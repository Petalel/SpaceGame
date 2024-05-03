import java.util.List;

  import greenfoot.*; 

/** * 
 * @author Eleni Petaloti
 * @version 1.1
 */
public class newWorld  extends World
{

    
    private int lifes;
    private int score;
    public static int level = 1;

        public newWorld() {
        super(600, 600, 1);
        createStarryBackground();
        startWorld();
        addObject(new Spaceship(), 305, 550);
        
    }
    
    public void act() {
        spawnChickensAndStars();
        int spaceshipScore = getSpaceshipScore();
        score = spaceshipScore; 
        showScore();
        int spaceshipLife = getSpaceshipLife();
        lifes = spaceshipLife; 
        showLives();
        showLevel();
        checkEndofGame();
        checkLevel();
    }
  
   private void createStarryBackground() {
    GreenfootImage background = new GreenfootImage(getWidth(), getHeight());
    
    // Change background color based on the level
    background.setColor(Color.BLACK);
    background.fill();

    // Change star density or color based on the level
    if (level == 1) {
        background.setColor(Color.WHITE);
        for (int i = 0; i < 200; i++) {
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            background.fillRect(x, y, 2, 2);  
        }
    } else if (level == 2) {
        background.setColor(Color.YELLOW);  // Golden stars for variety
        for (int i = 0; i < 300; i++) {  // More stars
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            background.fillRect(x, y, 1, 1);  // Smaller stars
        }
    } else {
        background.setColor(Color.GRAY);  // Dim stars for a distant feel
        for (int i = 0; i < 250; i++) {  // Different number of stars
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            background.fillOval(x, y, 3, 3);  // Larger, but dimmer stars
        }
    }

    setBackground(background);
}

    
    private int getSpaceshipScore() {
        Spaceship spaceship = (Spaceship) getObjects(Spaceship.class).get(0);
        return spaceship.getScore(); 
    }
     
    private int getSpaceshipLife() {
        Spaceship spaceship = (Spaceship) getObjects(Spaceship.class).get(0);
        return spaceship.getLifes(); 
    }
     
    
     private void restartSpaceshipScore() {
        Spaceship spaceship = (Spaceship) getObjects(Spaceship.class).get(0);
        spaceship.restartScore(); 
    }
    
     private void restartSpaceshipLifes() {
        Spaceship spaceship = (Spaceship) getObjects(Spaceship.class).get(0);
        spaceship.restartLifes(); 
    }
    
     private void restartLevel() {
        level = 1;
    }
    
    void showScore() {
        showText("Score: " + score, getWidth() - 100, getHeight() - 20); // Display points at the bottom right corner
    }
    void showLevel() {
        showText("Level: " + level, getWidth() - 200, getHeight() - 20); // Display points at the bottom right corner
    }
    
    
    private void showLives() {
        // Remove previous life icons
        removeObjects(getObjects(Heart.class));

        // Display remaining lives as heart icons
        for (int i = 0; i < lifes; i++) {
            addObject(new Heart(), 40 + i * 50, getHeight() - 20);
        }
    }
    
    private void spawnChickensAndStars() {
        if (Greenfoot.getRandomNumber(100) < 2) {        
            addObject(new Chicken(), Greenfoot.getRandomNumber(200) + 200, 0);
        }
        if (Greenfoot.getRandomNumber(10) < 2) {
            addObject(new Stars(), Greenfoot.getRandomNumber(170), 0);
            addObject(new Stars(), Greenfoot.getRandomNumber(170) + 440, 0);
        }
    }
    
     public void startWorld() {
        // Create an instance of your subclass and set it as the world
        TitleScreen mainMenu = new TitleScreen();

        Greenfoot.setWorld(mainMenu);
        
    }
    
    public void checkLevel() {
        
        if(score == 30 && level == 1 ){
        explodeAllChickens();
        Greenfoot.delay(50);
        NextLevel nextLevel = new NextLevel();
        Greenfoot.setWorld(nextLevel);
        restartSpaceshipScore();
        restartSpaceshipLifes();
        level ++;
        }
        
    }
    
    
    
    public void checkEndofGame() {
        if(score == 50 && level == 2 ){
           
        explodeAllChickens();
        Greenfoot.delay(50);
        WinGame winGame = new WinGame();
        Greenfoot.setWorld(winGame);
        restartSpaceshipScore();
        restartSpaceshipLifes();
        restartLevel();
        }
        
        if(lifes == 0){
        GameOver gameOver = new GameOver();
        Greenfoot.setWorld(gameOver);
        restartSpaceshipScore();
        restartSpaceshipLifes();
        restartLevel();
        }
        
    }
    
    private void explodeAllChickens() {
    List<Chicken> chickens = getObjects(Chicken.class);
    for (Chicken chicken : chickens) {
        Explode explode = new Explode();
        addObject(explode, chicken.getX(), chicken.getY());
        removeObject(chicken);
        Greenfoot.delay(30);

    }
}
}
