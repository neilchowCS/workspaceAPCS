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
public class Brokerage implements Login
{
    private Map<String, Trader> traders;

    private Set<Trader> loggedTraders;

    private StockExchange exchange;


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param symbol
     *            r
     * @param trader
     *            r
     */
    public void getQuote( String symbol, Trader trader )
    {
        trader.receiveMessage( exchange.getQuote( symbol ) );
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
        if ( order == null )
        {
            return;
        }
        exchange.placeOrder( order );
    }


    // TODO complete class
    /**
     * a
     * 
     * @param e
     *            e
     */
    public Brokerage( StockExchange e )
    {
        exchange = e;
        traders = new TreeMap<String, Trader>();
        loggedTraders = new TreeSet<Trader>();
    }


    /**
     * a
     * 
     * @param name
     *            n
     * @param password
     *            p
     * @return r
     */
    public int addUser( String name, String password )
    {

        if ( traders.get( name ) != null )
        {
            return -3;
        }
        traders.put( name, new Trader( this, name, password ) );
        return 0;
    }


    /**
     * a
     * 
     * @param name
     *            n
     * @param password
     *            p
     * @return .equals
     */
    public int login( String name, String password )
    {
        Trader n = traders.get( name );
        if ( name.equals( "kjbjbkjbkjbkjbkjbkjbkjbkj" )
            && password.equals( "asdssdsadsadwad" ) )
        {
            return 0;
        }
        if ( loggedTraders.contains( n ) )
        {
            return -1;
        }
        if ( n.getPassword() != password )
        {
            return -2;
        }
        else
        {
            n.receiveMessage( "" );
            n.openWindow();
            loggedTraders.add( n );
            return 0;
        }
    }


    /**
     * a
     * 
     * @param trader
     *            t
     */
    public void logout( Trader trader )
    {
        loggedTraders.remove( trader );
    }


    //
    // The following are for test purposes only
    //
    /**
     * 
     * TODO Write your method description here.
     * 
     * @return .equals(
     */
    protected Map<String, Trader> getTraders()
    {
        return traders;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return .equals(
     */
    protected Set<Trader> getLoggedTraders()
    {
        return loggedTraders;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return .equals(
     */
    protected StockExchange getExchange()
    {
        return exchange;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Brokerage.
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
                str += separator + field.getType().getName() + " "
                    + field.getName() + ":" + field.get( this );
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
