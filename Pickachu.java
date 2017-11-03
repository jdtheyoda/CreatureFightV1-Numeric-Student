import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * This is my class Pickachu.
 * 
 * @author (Jazzdin Eulalia) 
 * @version (November, 3, 2017)
 */
public class Pickachu extends Creature
{
    public Pickachu( World w )
    {
       super(700, false, "Electric");
       getImage().scale( 150, 100 );
       w.addObject( getHealthBar(), 100, 25); 
            
    }
    
    public void attack( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature enemy = world.getPlayerOne();
        String enemyType = enemy.getType();
        
        if (idx == 0)
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        {
            enemy.getHealthBar().add( -65 );
        }
        world.setTurnNumber(true);       
    }    
    
    /**
     * Act - do whatever the Pickachu wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        if( getHealthBar().getCurrent() <= 0 )
        {
        getWorld().showText("Pickachu has fainted...", getWorld().getWidth()/2,getWorld().getHeight()/2 + 26);
        Greenfoot.delay(30);
        }
        
    }    
}
