import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Title Screen
 * 
 * @author Zhengfei 
 * @version May 25 2022
 */
public class TitleScreen extends World
{
    Label title = new Label("🍏 Hungry Piggy 🐖 ", 70);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 

        addObject(title, getWidth()/2, getHeight()/2);
        prepare();
    }

    /**
     * The main world act loop.
     */
    public void act()
    {
        // Start the game if the user presses the space bar.
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Label label = new Label("Press <space> to Start", 40);
        addObject(label,285,274);
        label.setLocation(290,350);
        Label label2 = new Label("Use 'a' and 'd' to Move", 30);
        addObject(label2,165,268);
        label2.setLocation(298,259);
    }
}
