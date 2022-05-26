import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World our hero lives in
 * 
 * @author Zhengfei
 * @version May 25 2022 
 */
public class MyWorld extends World
{
    public int trackScore = 0;
    Label score;
    int level = 1;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Creates a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        // Creates the pig object.
        Pig pig = new Pig();
        addObject(pig, 300, 300);
        // Creates a label
        score = new Label(0, 100);
        addObject(score, 50, 50);
        
        createApple();
    }
    
    /**
     * Ends the game and shows "GameOver" on the screen.
     */
    public void gameOver()
    {
        Label gameOver = new Label("Game Over", 100);
        addObject(gameOver, 300, 200);
    }
    
    /**
     * Increases the score
     */
    public void increaseScore()
    {
        trackScore++;
        score.setValue(trackScore);
        
        if(trackScore % 5 == 0)
        {
            level += 1;
        }
    }
    
    /**
     * Creates a new apple at random location at top of screen/
     */
    public void createApple()
    {     
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}