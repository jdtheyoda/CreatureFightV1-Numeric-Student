
/**
 * This is my class SwitchCommands.
 * 
 * @author (Jazzdin Eulalia) 
 * @version (November, 3, 2017)
 */
public class SwitchCommands  implements MenuCommands
{
    public void execute( int idx, Creature c )
    {
        System.out.println(idx);
        c.switchCreature(idx);
    }
}
