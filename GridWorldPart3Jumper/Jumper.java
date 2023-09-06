import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;


/**
 * A <code>Jumper</code> is an actor that will jump over Rocks and Flowers and
 * turn. A jumper can remove another jumper by jumping on them.
 * 
 * @author TODO Your Name(s)
 * @version TODO Date
 * @author Period: TODO
 * @author Assignment: GridWorld_Part3_Jumper
 * 
 * @author Sources: TODO
 */
public class Jumper extends Bug implements Edible
{
    // TODO constructor(s)

    // TODO method(s)
    public void act()
    {
        if ( canMove() )
        {
            move();
        }
        else
        {
            turn();
        }
    }


    public void move()
    {
        Grid<Actor> gr = getGrid();
        if ( gr == null )
            return;
        Location loc = getLocation();
        Location next = getAdjacentLocation();
        //System.out.println( next.getCol() );
        Actor neighbor = gr.get( next );
        if ( neighbor != null && neighbor instanceof Edible )
        {
            neighbor.removeSelfFromGrid();
        }
        if ( gr.isValid( next ) )
            moveTo( next );
        else
            removeSelfFromGrid();

    }


    /**
     * Tests whether this bug can move forward into a location that is empty or
     * contains a flower.
     * 
     * @return true if this bug can move.
     */
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if ( gr == null )
            return false;

        Location next = getAdjacentLocation();
        if ( !gr.isValid( next ) )
            return false;

        Actor neighbor = gr.get( next );
        return ( neighbor == null ) || ( neighbor instanceof Edible );
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }


    public Location getAdjacentLocation()
    {
        Location loc = getLocation();
        int dc = 0;
        int dr = 0;
        if ( getDirection() == Location.EAST )
            dc = 2;
        else if ( getDirection() == Location.SOUTHEAST )
        {
            dc = 2;
            dr = 2;
        }
        else if ( getDirection() == Location.SOUTH )
            dr = 2;
        else if ( getDirection() == Location.SOUTHWEST )
        {
            dc = -2;
            dr = 2;
        }
        else if ( getDirection() == Location.WEST )
            dc = -2;
        else if ( getDirection() == Location.NORTHWEST )
        {
            dc = -2;
            dr = -2;
        }
        else if ( getDirection() == Location.NORTH )
            dr = -2;
        else if ( getDirection() == Location.NORTHEAST )
        {
            dc = 2;
            dr = -2;
        }

        Location next = new Location( loc.getRow() + dr, loc.getCol() + dc );

        return next;
    }

}