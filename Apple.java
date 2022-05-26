import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Food for our pig
 * 
 * @author Zhengfei
 * @version May 25 2022
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    
    public void act()
    {
        // Apple falls down.
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        // Removes apple and shows gme over when apple gets to the bottom of the screen.
        MyWorld world = (MyWorld) getWorld();
        if(getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}