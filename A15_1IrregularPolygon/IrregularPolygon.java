
import java.awt.geom.*;
import java.util.*;
import gpdraw.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author TODO Your Name
 * @version TODO Date
 *
 * @author Period - TODO Your Period
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class IrregularPolygon
{
    private DrawingTool pen; // = new DrawingTool(new SketchPad(300, 300, 0));

    private ArrayList<Point2D.Double> myPolygon;


    // constuctors
    /**
     * constructor
     */
    public IrregularPolygon()
    {
        myPolygon = new ArrayList<Point2D.Double>();
    }


    // public methods
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param aPoint
     *            point to add
     */
    public void add( Point2D.Double aPoint )
    {
        myPolygon.add( aPoint );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return polygon perim
     */
    public double perimeter()
    {
        double perimeter = 0;

        for ( int i = 1; i < myPolygon.size(); i++ )
        {
            perimeter += myPolygon.get( i ).distance( myPolygon.get( i - 1 ) );
            if ( myPolygon.size() > 2 && i == myPolygon.size() - 1 )
            {
                perimeter += myPolygon.get( i ).distance( myPolygon.get( 0 ) );
            }
        }

        return perimeter; // fix this!
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return poly area
     */
    public double area()
    {
        double area = 0;
        int j = myPolygon.size() - 1;
        for ( int i = 0; i < myPolygon.size(); i++ )
        {
            area += ( myPolygon.get( j ).x + myPolygon.get( i ).x )
                * ( myPolygon.get( j ).y - myPolygon.get( i ).y );
            j = i;
        }

        return Math.abs( area / 2 );
    }


    /**
     * draws polygon w/ pen TODO Write your method description here.
     */
    public void draw()
    {
        pen.up();
        if ( myPolygon.size() > 1 )
        {
            pen.move( myPolygon.get( 0 ).x, myPolygon.get( 0 ).y );
            pen.down();
            for ( int i = 1; i < myPolygon.size(); i++ )
            {
                pen.move( myPolygon.get( i ).x, myPolygon.get( i ).y );
            }
            pen.move( myPolygon.get( 0 ).x, myPolygon.get( 0 ).y );
        }

    }
}
