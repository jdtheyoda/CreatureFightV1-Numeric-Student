import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * This is a class TextBox.
 * 
 * @author (Jazzdin Eulalia) 
 * @version (November, 3, 2017)
 */
public class TextBox extends Actor
{
    private GreenfootImage img;
    private boolean border = false;
    private int fontSize;
    private Color foreground;
    private Color background;
    private String text;
    
    public TextBox( String message, int fs, boolean hasBorder, Color fg, Color bg )
    {
        fontSize = fs;
        border = hasBorder;
        foreground = fg;
        background = bg;
        
        text = message;
        
        img = new GreenfootImage( text, fontSize, foreground, background );
        
        display();
    }
    
    /**
     * display will display the border of the CreatureWorld
     * 
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void display()
    {     
        if( border == true )
        {
            img.setColor( Color.BLACK );
            img.drawRect( 0, 0, img.getWidth() - 1, img.getHeight() - 1 );
        }
        
        setImage( img );
    }
    
    /**
     * getText will get the text in the CreatureWorld
     * 
     * @param There are no parameters
     * @return an object of the creature world type
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * setText will set the message, GreenfootImage, and the displays of the CreatureWorld
     * 
     * @param String message that will show the string text 
     * @return Nothing is returned
     */
    public void setText( String message )
    {
        text = message;
        img = new GreenfootImage( text, fontSize, foreground, background );
        display();
    }
    
    /**
     * Act - do whatever the TextBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
