import java.lang.reflect.*;


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
public class TradeOrder
{
    private Trader trader;

    private String symbol;

    private boolean buyOrder;

    private boolean marketOrder;

    private int numShares;

    private double price;


    // TODO complete class
    /**
     * b
     * 
     * @param t
     *            r
     * @param s
     *            r
     * @param b1
     *            r
     * @param b2
     *            r
     * @param n
     *            r
     * @param p
     *            r
     */
    public TradeOrder(
        Trader t,
        String s,
        boolean b1,
        boolean b2,
        int n,
        double p )
    {
        trader = t;
        symbol = s;
        buyOrder = b1;
        marketOrder = b2;
        numShares = n;
        price = p;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public Trader getTrader()
    {
        return trader;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public String getSymbol()
    {
        return symbol;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public boolean getBuy()
    {
        return buyOrder;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public boolean getMarket()
    {
        return marketOrder;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public int getShares()
    {
        return numShares;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public double getPrice()
    {
        return price;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param n
     *            r
     */
    public void subtractShares( int n )
    {
        numShares -= n;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public boolean isBuy()
    {
        return buyOrder;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public boolean isLimit()
    {
        return !marketOrder;
    }


    /**
     * r TODO Write your method description here.
     * 
     * @return r
     */
    public boolean isMarket()
    {
        return marketOrder;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public boolean isSell()
    {
        return !buyOrder;
    }


    //
    // The following are for test purposes only
    //
    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this TradeOrder.
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
