import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
// import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

// import java.awt.Color;


/**
 * TODO Write a one-sentence summary of your class here TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author TODO Your Name
 * @version TODO Date
 * @author Period: TODO Your Period
 * @author Assignment: BlusterCritter - GridWorld Part4 Exercise 4
 *
 * @author Sources: TODO I received help from ...
 */
public class BlusterCritter extends Critter
{
    // TODO instance variable(s)
    private int c;


    /**
     * construct
     * 
     * @param c
     *            courage
     */
    public BlusterCritter( int c )
    {
        // TODO complete constructor
        this.c = c;
    }


    /**
     * TODO Write your method description here <br />
     * Postcondition: The state of all actors is unchanged.
     * 
     * @return a list of actors that this critter wishes to process.
     */
    public ArrayList<Actor> getActors()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();

        // TODO complete method
        for ( int i = 0; i < gr.getOccupiedLocations().size(); i++ )
        {
            if ( Math
                .abs( gr.getOccupiedLocations().get( i ).getCol()
                    - this.getLocation().getCol() ) <= 2
                && Math.abs( gr.getOccupiedLocations().get( i ).getRow()
                    - this.getLocation().getRow() ) <= 2 )
            {
                if ( !gr.getOccupiedLocations()
                    .get( i )
                    .equals( this.getLocation() ) )
                {
                    System.out
                        .println( gr.getOccupiedLocations().get( i ).getRow()
                            + " " + gr.getOccupiedLocations().get( i ).getCol()
                            + " " + this.getLocation().getRow() + " "
                            + this.getLocation().getCol() );

                    // System.out.println();

                    actors.add( gr.get( gr.getOccupiedLocations().get( i ) ) );
                }
            }
        }

        System.out.println( actors.size() );
        return actors;

    }


    /**
     * TODO Write your method description here <br />
     * Postcondition: (1) The state of all actors in the grid other than this
     * critter and the elements of <code>actors</code> is unchanged. (2) The
     * location of this critter is unchanged.
     * 
     * @param actors
     *            the actors to be processed
     */
    public void processActors( ArrayList<Actor> actors )
    {
        if ( getActors().size() < c )
        {
            lighten();
        }
        if ( getActors().size() > c )
        {
            darken();
        }

    }


    /**
     * TODO Write your method description here
     */
    private void darken()
    {
        // TODO complete method
        // see act method of flower for example
        setColor( this.getColor().darker() );
    }


    /**
     * TODO Write your method description here
     */
    private void lighten()
    {
        // TODO complete method
        // see act method of flower for example
        setColor( this.getColor().brighter() );
    }
}
