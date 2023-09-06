import java.lang.reflect.*;
import java.util.*;


/**
 * 
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  neilchow
 *  @version Apr 19, 2020
 *  @author  Period: TODO
 *  @author  Assignment: JMCh19_SafeTrade
 *
 *  @author  Sources: TODO
 */
public class StockExchange
{
    private Map<String, Stock> listedStocks;


    // TODO complete class
    /**
     * c
     */
    public StockExchange()
    {
        listedStocks = new HashMap<String, Stock>();
    }

/**
 * 
 * TODO Write your method description here.
 * @param symbol s
 * @return r
 */
    public String getQuote( String symbol )
    {
        if ( symbol == null )
        {
            return "";
        }

        if ( listedStocks.get( symbol ) != null )
        {
            return listedStocks.get( symbol ).getQuote();
        }

        return "";
    }

/**
 * 
 * TODO Write your method description here.
 * @param symbol s
 * @param name n
 * @param price p
 */
    public void listStock( String symbol, String name, double price )
    {
        listedStocks.put( symbol, new Stock( symbol, name, price ) );
    }

/**
 * 
 * TODO Write your method description here.
 * @param order o s
 */
    public void placeOrder( TradeOrder order )
    {
        Stock s = listedStocks.get( order.getSymbol() );
        if ( s != null )
        {
            s.placeOrder( order );
            return;
        }
        String str = order.getSymbol() + " not found";
        order.getTrader().receiveMessage( str );
    }


    //
    // The following are for test purposes only
    //
    /**
     * 
     * TODO Write your method description here.
     * @return private PriorityQueue<TradeOrder>
     */
    protected Map<String, Stock> getListedStocks()
    {
        return listedStocks;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this StockExchange.
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
