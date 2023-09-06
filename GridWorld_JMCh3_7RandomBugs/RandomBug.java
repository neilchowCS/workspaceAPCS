import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.awt.Color;


/**
 * A subclass of Bug that adds the turnAround method and redefines Bug's act
 * method so that this bug makes a U-turn when it can't move
 * 
 * @author TODO Your Name
 * @version TODO Date
 *
 * @author Period - TODO Your Period
 * @author Assignment - Random Bugs - UTurnBug
 *
 * @author Sources - TODO list collaborators
 */
public class RandomBug extends Bug
{
    public RandomBug()
    {
        setColor( Color.YELLOW );
    }


    public RandomBug( Color bugColor )
    {
        setColor( bugColor );
    }


    public void turn( int angle )
    {
        int i = 0;
        while ( i < angle / 45 )
        {
            setDirection( getDirection() + Location.HALF_RIGHT );
            i++;
        }

    }


    // Overrides Bug's act method
    public void act()
    {
        if ( canMove() )
        {
            move();
            int angle = 45 * (int)( Math.random() * 8 );
            turn( angle );
        }
        else
        {
            int angle = 45 * (int)( Math.random() * 8 );
            turn( angle );
        }
    }
}
