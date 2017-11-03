import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * This is my class Menu.
 * 
 * @author (Jazzdin Eulalia) 
 * @version (November, 3, 2017)
 */
public class Menu extends Actor
{ 
    private TextBox titleBar;
    private TextBox menuItems;
    private MenuCommands commands;
    private int fontsize = 24;
    private boolean visible = false;
    private Color mainFG;
    private Color mainBG;
    private Color secondFG;
    private Color secondBG;
    private int titleHeight;
    private int menuHeight;
    
    public Menu( String tb, String i, int fs, Color mfg, Color mbg, Color sfg, Color sbg, MenuCommands mc )
    {
        mainFG = mfg;
        mainBG = mbg;
        secondFG = sfg;
        secondBG = sbg;
        
        titleBar = new TextBox( tb, fs, true, mainFG, mainBG );
        menuItems = new TextBox( i, fs, true, secondFG, secondBG );
        
        commands = mc;
        fontsize = fs;
    }
    
    public Menu()
    {
        this( "not initialized", "none", 24, Color.BLACK, Color.lightGray, Color.BLACK, Color.WHITE, null );
    }
    
    protected void addedToWorld (World w)
    {
        w.addObject( titleBar, getX(), getY() );
        titleHeight = titleBar.getImage().getHeight();
        menuHeight = menuItems.getImage().getHeight();
    } 
    
    /**
     * Act - do whatever the Menu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        handleMouse();
    }
    
    private void handleMouse()
   {
       CreatureWorld world = (CreatureWorld)getWorld();
       int distance;
       if( world.getTurnNumber() == true )
       {
         if( titleBar.getText().equalsIgnoreCase("Fight") )
         {
             distance = 120;
         }
         else
         {
             distance = 170;
         }
       }
       else
       {
         if( titleBar.getText().equalsIgnoreCase("Fight") )
         {
             distance = 270;
         }
         else
         {
             distance = 170;
         }
       }
       
       if( Greenfoot.mouseClicked(titleBar) )
       {
            if( visible == false )
            {
                getWorld().addObject( menuItems, getX(), getY() + (titleHeight + menuHeight)/2 );
            }
            else
            {
                getWorld().removeObject( menuItems );
            }
            
            visible = !visible;
       }
       
       if( Greenfoot.mouseClicked(menuItems) )
       {
           MouseInfo mi = Greenfoot.getMouseInfo();
           int menuIndex = ( (mi.getY() - menuItems.getY() + menuHeight / 2 ) - 1) / fontsize;
           visible = !visible;
           getWorld().removeObject(menuItems);
           commands.execute(menuIndex, getObjectsInRange( distance, Creature.class ).get(0) );
       }   

   }
     
   
      
   
}    
