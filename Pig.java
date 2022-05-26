import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Pig, our hero.
 * 
 * @author Zhengfei
 * version May 25 2022
 */
public class Pig extends Actor
{
    /**
     * Act - do whatever the Pig wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootSound pigSound = new GreenfootSound("PigSounds.mp3");
    GreenfootImage[] imageRight;
    GreenfootImage[] imageLeft;
    SimpleTimer animationTimer = new  SimpleTimer();
    
    /**
     * Constructor: Runs everytime when an object is created.
     */
    
    public Pig()
    {
        imageRight = new GreenfootImage[8];
        imageLeft = new GreenfootImage[8];
        for(int i = 0; i < imageRight.length; i++)
        {
            imageRight[i] = new GreenfootImage("images/pigs/pig" + i + ".png");
            imageRight[i].scale(150, 100);
            imageLeft[i] = new GreenfootImage("images/pigs/pig" + i + ".png");
            imageLeft[i].scale(150, 100);
            imageLeft[i].mirrorHorizontally();
        }
        
        animationTimer.mark();
        
        // Initial pig image.
        setImage(imageRight[0]);
    }
    
    /**
     * Animate the pig.
     */
    int imageIndex = 0;
    public void animationPig()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(Greenfoot.isKeyDown("d"))
        {
            setImage(imageRight[imageIndex]);
            imageIndex = (imageIndex + 1) % imageRight.length;
        }
        else if(Greenfoot.isKeyDown("a"))  
        {
            setImage(imageLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % imageLeft.length;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("d"))
        {
            move(2);
        }
        else if(Greenfoot.isKeyDown("a"))
        {
            move(-2);
        }
        // Remove apple when the pig eats it.
        eat();
        
        // Animate the pig.
        animationPig();
    }
    
    /**
     * Eat the apple and spawn a new apple when an apple is being eaten.
     */
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            pigSound.play();
        }
    }
}