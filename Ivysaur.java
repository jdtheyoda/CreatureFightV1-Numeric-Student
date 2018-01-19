import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;
/**
 * This is my class Ivysaur.
 * 
 * @author (Jazzdin Eulalia) 
 * @version (November, 3, 2017)
 */
public class Ivysaur extends Creature
{
    /**
     * Ivysaur is the creatures of the CreatureWorld
     * 
     * @param w where the location indicates
     * @return Nothing is returned
     */
    public Ivysaur( World w )
    {
        super(720, true, "Grass");
        getImage().scale( 150, 100 );
        w.addObject( getHealthBar(), 300, w.getHeight() - 50);
        getHealthBar().getImage().setTransparency(0);
    }
    
    /**
     * attack is the method that will attack other creatures of the CreatureWorld
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void attack( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature enemy = world.getPlayerTwo();
        String enemyType = enemy.getType();
        attackAnimation();
        
        if(idx == 0)
        {
            enemy.getHealthBar().add( -30 );
        }
        else
        {
            if( enemyType.equalsIgnoreCase( "Electric" ) )
            {
                getWorld().showText( "It's not very effective...", getWorld().getWidth()/2, getWorld().getHeight()/2 +26 );
                enemy.getHealthBar().add( -60/2 );
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase( "Flying" ) )
            {
                getWorld().showText( "It's not very effective...", getWorld().getWidth()/2, getWorld().getHeight()/2 +26 );
                enemy.getHealthBar().add( -60/2 );
                Greenfoot.delay(30);
            }
            else if( enemyType.equalsIgnoreCase( "Water" ) )
            {
                getWorld().showText( "It super effective!", getWorld().getWidth()/2, getWorld().getHeight()/2 +26 );
                enemy.getHealthBar().add( -60*2 );
                Greenfoot.delay(30);
            }
            else
            {
                enemy.getHealthBar().add( -60 );
            }
            
        }
        world.setTurnNumber(false);       
    }
    
    /**
     * attackAnimation uses animation for the creatures of the CreatureWorld
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void attackAnimation()
    {
        int originalX = getX();
        int originalY = getY();
        for(int i = 0 ; i < 15; i++)
        {
            setLocation(getX() +1, getY() -2);
            Greenfoot.delay(1);
        }
        setLocation(originalX,originalY);        
    }
    
    /**
     * switchCreature that will switch the creatures of the CreatureWorld
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchCreature( int idx )
    {
        CreatureWorld world = (CreatureWorld)getWorld();
        Creature switchCreature;        
        if( idx == 0 )
        {
            switchCreature = world.getNewOneCreature(0);            
        }
        else 
        {
            switchCreature = world.getNewOneCreature(1);
        }        
        
        if( switchCreature.getHealthBar().getCurrent() <= 0 )
        {
            JOptionPane.showMessageDialog( null, "This creature has fainted! Please select a different creature." );
        }
        else
        {
            while( getX() > 0 )
            {
                setLocation(getX() -5, getY() );
                Greenfoot.delay(2);
            }
            getImage().setTransparency(0);
            getHealthBar().getImage().setTransparency(0);
            
            if( idx == 0 )
            {
                world.changePlayerOne("Charmander");
            }
            else
            {
                world.changePlayerOne("Golem");
            }
            switchCreature.switchedIn();
            world.setTurnNumber(false);
        }
    }
    
    /**
     * switchedIn switches in the creatures of the CreatureWorld
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    public void switchedIn()
    {
        getImage().setTransparency(255);
        getHealthBar().getImage().setTransparency(255);
        while( getX() < 75 )
        {
            setLocation( getX() +5 , getY() );
            Greenfoot.delay(2);            
        }
    }
    
    /**
     * Act - do whatever the Ivysaur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        CreatureWorld playerWorld = (CreatureWorld)getWorld();
        if( getHealthBar().getCurrent() <= 0 )
        {
            getWorld().showText( "Ivysaur has fainted...", getWorld().getWidth()/2,getWorld().getHeight()/2 + 26 );
            Greenfoot.delay(30);
            
            if( playerWorld.getNewOneCreature(0).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(0);
                playerWorld.setTurnNumber(true);
                getWorld().showText( "", getWorld().getWidth()/2 , getY()/2 +26 );
                getWorld().removeObject(this);
            }
            else if( playerWorld.getNewOneCreature(1).getHealthBar().getCurrent() > 0 )
            {
                switchCreature(1);
                playerWorld.setTurnNumber(true);
                getWorld().showText( "", getWorld().getWidth()/2 , getY()/2 +26 );
                getWorld().removeObject(this);
            }
        }
    }
}

