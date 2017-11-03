/**
 * This is my class FightCommands.
 * 
 * @author (Jazzdin Eulalia) 
 * @version (November, 3, 2017)
 */
public class FightCommands implements MenuCommands
{
    public void execute( int idx, Creature c )
    {
    	c.attack( idx );
    }  
}
