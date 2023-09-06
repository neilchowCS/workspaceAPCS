import java.util.*;


/**
 * Implements an actor that can receive and send messages about its possessions
 * and give extra items that it doesn't need to others. The actor's objective is
 * to collect at least one of each item.
 * 
 * @author TODO Your Name
 * @version TODO date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class Actor implements Comparable<Actor>
{
    // Set <Actors> x = new TreeSet <Actors>();
    private static String[] items = { "left glove", "right glove", "hat" };

    private String name;

    private Collection<String> myPossessions;

    private Queue<Message> mailbox;

    private MailServer email;

    private boolean allSetFlag; // = false;


    /**
     * as
     * 
     * @param nm
     *            nm
     */
    public Actor( String nm )
    {
        name = nm;
        mailbox = new LinkedList<Message>();
    }


    /**
     * as
     * 
     * @param nm
     *            nm
     * @param possessions
     *            pos
     */
    public Actor( String nm, Collection<String> possessions )
    {
        name = nm;
        myPossessions = new ArrayList<String>();
        myPossessions.addAll( possessions );
        mailbox = new LinkedList<Message>();
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param server
     *            s
     */
    // Adds server as this actor's email server.
    public void addMailServer( MailServer server )
    {
        email = server;
        email.signUp( this );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return n
     */
    // returns the name of this actor.
    public String getName()
    {
        return name;
    }


    // Compares this actor to other in alphabetical
    // order of their names.
    /**
     * a
     * 
     * @param other
     *            o
     */
    public int compareTo( Actor other )
    {
        return name.compareTo( other.getName() );
    }


    // Check whether this actor's name is the same as other's.
    /**
     * s
     * 
     * @param other
     *            o
     */
    public boolean equals( Object other )
    {
        return other != null && name.equals( ( (Actor)other ).getName() );
    }


    // Returns the hashCode for this actor equal to the hashcode of its name.
    /**
     * d
     */
    public int hashCode()
    {
        return name.hashCode();
    }


    // Adds msg to this Actor's mailbox.
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param msg
     *            receive
     */
    public void receive( Message msg )
    {
        // TODO complete method
        mailbox.add( msg );
    }


    // Called by someone else to give an item to this actor.
    // Checks whether this actor still needs the item. If so,
    // sends a thank-you message to giver and returns true;
    // otherwise returns false./
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param giver
     *            g
     * @param item
     *            i
     * @return thank
     */
    public boolean receiveItem( Actor giver, String item )
    {
        if ( !myPossessions.contains( item ) )
        {
            myPossessions.add( item );
            email.add( new Message( this, giver, "thanks for the " + item ) );
            return true;
        }
        else
            return false;
    }


    // 1. Checks possessions for this actor and sends a "need <item>"
    // message to the list for each missing item.
    //
    // 2. Removes and processes messages from the mailbox,
    // one by one.
    // Processing messages:
    // i) Takes action only for messages with the text
    // "need <item>", "have <item>", or "ship <item>".
    // where <item> is the name of the item, such as "hat",
    // "left glove", or "right glove".
    // Skips all other messages.
    // ii) If this is a "need" message and this actor has an extra item
    // requested, it replies with a "have <item>" message.
    // iii) If this is a "have" message and this actor is missing the offered
    // item,
    // it replies with a "ship <item>" message.
    // iv) If this is a "ship" message and this actor still has an extra item,
    // then it calls sender's receiveItem method. If receiveItem
    // returns true, removes item from this actor's possessions.
    //
    // 3. If allSetFlag is not set and this actor is all set, that is has
    // one of each item, sends "thanks, i'm all set" to the list.
    /**
     * 
     * TODO Write your method description here.1. C
     */
    public void readMail()
    {
        for ( String item : items )
        {
            if ( countPossessions( item ) < 1 )
                announce( "need " + item );
        }

        // TODO complete method
        while ( !mailbox.isEmpty() )
        {
            Message msg = mailbox.remove();
            String act = msg.getText().substring( 0, 4 );
            String item = msg.getText().substring( 5 );
            if ( act == "need" )
            {
                for ( String s : myPossessions )
                {
                    if ( item == s )
                    {
                        myPossessions.remove( s );
                        reply( msg.getSender(), "have " + item );
                    }
                }
            }
            else if ( act == "have" )
            {
                reply( msg.getSender(), "ship " + item );
            }
            else if ( act == "ship" )
            {
                if ( msg.getSender().receiveItem( this, item ) )
                {
                    myPossessions.remove( item );
                }
            }
        }

        if ( !allSetFlag && allSet() )
            announce( "thanks, i'm all set" );
    }


    /**
     * sa
     */
    public String toString()
    {
        return name + " " + myPossessions;
    }

    // *************************************************************


    // Sends text to recipient
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param recipient
     *            r
     * @param text
     *            t
     */
    private void send( Actor recipient, String text )
    {
        email.add( new Message( this, recipient, text ) );
    }


    // Announces subject to the list
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param text
     *            t
     */
    private void announce( String text )
    {
        send( null, text );
    }


    // Sends a reply to sender with the specified new subject
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param actor
     *            a
     * @param text
     *            t
     */
    private void reply( Actor actor, String text )
    {
        send( actor, text );
    }


    // Returns the number of times item occurs in myPossessions
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param item
     *            i
     * @return r
     */
    private int countPossessions( String item )
    {
        int count = 0;

        for ( String str : myPossessions )
            if ( item.equals( str ) )
                count++;

        return count;
    }


    // Checks whether this actor has one of each items
    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    private boolean allSet()
    {
        for ( String item : items )
        {
            if ( countPossessions( item ) != 1 )
                return false;
        }
        allSetFlag = true;
        return true;
    }


    // *************************************************************
    // Accessors for testing purposes only
    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    protected Collection<String> getMyPossessions()
    {
        return myPossessions;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    protected Queue<Message> getMailbox()
    {
        return mailbox;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return e
     */
    protected MailServer getEmail()
    {
        return email;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return a
     */
    protected boolean getAllSetFlag()
    {
        return allSetFlag;
    }
}
