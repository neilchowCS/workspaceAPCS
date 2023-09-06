import java.lang.reflect.*;
import java.util.*;


/**
 * 
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author neilchow
 * @version Apr 19, 2020
 * @author Period: TODO
 * @author Assignment: JMCh19_SafeTrade
 *
 * @author Sources: TODO
 */
public class Trader implements Comparable<Trader>
{
    private Brokerage brokerage;

    private String screenName;

    private String password;

    private Queue<String> mailbox;


    /**
     * 
     * TODO Write your method description here.
     */
    public void openWindow()
    {

        TraderWindow myWindow = new TraderWindow( this );
        while ( mailbox.peek() != null )
        {
            myWindow.showMessage( mailbox.remove() );
        }
    }


    /**
     * r
     * 
     * @param other
     *            o
     * @return private TraderWindow myWindow;
     */
    public boolean equals( Object other )
    {
        return compareTo( (Trader)other ) == 0;
    }


    // TODO complete class
    /**
     * r
     * 
     * @param b
     *            r
     * @param n
     *            r
     * @param p
     *            r
     */
    public Trader( Brokerage b, String n, String p )
    {
        brokerage = b;
        screenName = n;
        password = p;
        mailbox = new PriorityQueue<String>();
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param msg
     *            r
     */
    public void receiveMessage( String msg )
    {
        mailbox.add( msg );
    }


    /**
     * r
     * 
     * @param other
     *            o
     * @return private TraderWindow myWindow;
     */
    public int compareTo( Trader other )
    {
        return screenName.compareToIgnoreCase( other.getName() );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public String getName()
    {
        return screenName;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public String getPassword()
    {
        return password;
    }


    /**
     * 
     * TODO Write your method description here.
     */
    public void quit()
    {
        brokerage.logout( this );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public boolean hasMessages()
    {
        return mailbox.peek() != null;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param symbol
     *            r
     */
    public void getQuote( String symbol )
    {
        brokerage.getQuote( symbol, this );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param order
     *            r
     */
    public void placeOrder( TradeOrder order )
    {
        brokerage.placeOrder( order );
    }


    //
    // The following are for test purposes only
    //
    /**
     * 
     * TODO Write your method description here.
     * 
     * @return private TraderWindow myWindow;
     */
    protected Queue<String> mailbox()
    {
        return mailbox;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Trader.
     */
    public String toString()
    {
        String str = this.getClass().getName() + "[";
        String separator = "";

        Field[] fields = this.getClass().getDeclaredFields();

        for ( Field field : fields )
        {
            try
            {
                if ( field.getType().getName().equals( "Brokerage" ) )
                {
                    str += separator + field.getType().getName() + " "
                        + field.getName();
                }
                else
                {
                    str += separator + field.getType().getName() + " "
                        + field.getName() + ":" + field.get( this );
                }
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }

            separator = ", ";
        }

        return str + "]";
    }

}
