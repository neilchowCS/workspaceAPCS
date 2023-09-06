
// Implements the list of messages for teletext

import java.awt.Graphics;


/**
 * 
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author neilchow
 * @version Jan 7, 2020
 * @author Period: TODO
 * @author Assignment: JMCh20_7Teletext
 *
 * @author Sources: TODO
 */
public class TeletextList
{
    private ListNode2<String> heading;

    private ListNode2<String> topNode;


    /**
     * Creates a circular list of headlines. First creates a circular list with
     * one node, "Today's headlines:". Saves a reference to that node in
     * heading. Adds a node holding an empty string before heading and another
     * node holding an empty string after heading. Appends all the strings from
     * headlines to the list, after the blank line that follows heading,
     * preserving their order. Sets topNode equal to heading.
     * 
     * @param headlines
     *            Strings to add to circular list
     */
    public TeletextList( String[] headlines )
    {
        // TODO complete constructor
        heading = new ListNode2<String>( "Today's headlines:",
            heading,
            heading );
        ListNode2<String> node = new ListNode2<String>( "", heading, heading );
        heading.setPrevious( node );
        ListNode2<String> node2 = new ListNode2<String>( "", heading, node );
        heading.setNext( node2 );
        node.setPrevious( node2 );

        for ( int i = 0; i < headlines.length; i++ )
        {
            insert( headlines[i] );
        }

        topNode = heading;

    }


    /**
     * Inserts a node with msg into the headlines list after the blank /line
     * that follows heading.
     * 
     * @param msg
     *            String to add to headlines list
     */
    public void insert( String msg )
    {
        // TODO complete method
        ListNode2<String> temp = new ListNode2<String>( msg,
            heading.getNext(),
            heading.getNext().getNext() );
        heading.getNext().setNext( temp );
        heading.getNext().getNext().getNext().setPrevious( temp );
    }


    /**
     * Deletes the node that follows topNode from the headlines list, unless
     * that node happens to be heading or the node before or after heading that
     * holds a blank line.
     */
    public void delete()
    {
        // TODO complete method
        ListNode2<String> delete = topNode.getNext();
        if ( !( delete == heading || delete == heading.getPrevious()
            || delete == heading.getNext() ) )
        {
            ListNode2<String> temp = delete.getNext();
            topNode = heading.getNext().getNext();

            heading.getNext().setNext( temp );
            topNode.setPrevious( temp );
        }

    }


    /**
     * Scrolls up the headlines list, advancing topNode to the next node.
     */
    public void scrollUp()
    {
        // TODO complete method
        topNode = topNode.getNext();
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param node
     *            node
     * @param msg
     *            msg
     * @return new node
     */
    private ListNode2<String> addBefore( ListNode2<String> node, String msg )
    {
        ListNode2<String> newNode = new ListNode2<String>( msg,
            node.getPrevious(),
            node );
        node.getPrevious().setNext( newNode );
        node.setPrevious( newNode );
        return newNode;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param node
     *            node
     * @param msg
     *            msg
     * @return new node
     */
    private ListNode2<String> addAfter( ListNode2<String> node, String msg )
    {
        // TODO complete method
        ListNode2<String> temp = new ListNode2<String>( msg,
            node.getPrevious(),
            node );
        node.getNext().setNext( temp );
        node.setNext( temp );
        return temp;
        // return null; // fix this
    }


    /**
     * Removes a given node from the list.
     */
    private void remove( ListNode2<String> node )
    {
        // TODO complete method
        boolean done = false;
        ListNode2<String> temp = heading;
        while ( !done )
        {
            temp = temp.getNext();
            if ( temp == node )
            {
                temp.getPrevious().setNext( temp.getNext() );
                temp.getNext().setPrevious( temp.getPrevious() );
            }

        }
    }


    /**
     * 
     * TODO Draws nLines headlines in g, starting with topNode at x, y and
     * incrementing y by lineHeight after each headline.
     * 
     * @param g
     *            g
     * @param x
     *            x
     * @param y
     *            y
     * @param lineHeight
     *            l
     * @param nLines
     *            n
     */
    public void draw( Graphics g, int x, int y, int lineHeight, int nLines )
    {
        ListNode2<String> node = topNode;
        for ( int k = 1; k <= nLines; k++ )
        {
            g.drawString( node.getValue(), x, y );
            y += lineHeight;
            node = node.getNext();
        }
    }


    /**
     * Returns a string representation of this TeletextList.
     * 
     * @return a string representation of this TeletextList.
     */
    public String toString()
    {
        String str = getClass().getName() + "[";
        String separator = "";

        for ( ListNode2<String> node = heading; node
            .getNext() != heading; node = node.getNext() )
        {
            str += ( separator + node.getValue() );
            separator = ", ";
        }

        return str + "]";
    }
}
