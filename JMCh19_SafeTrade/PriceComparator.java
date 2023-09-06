import java.lang.reflect.Field;

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
public class PriceComparator implements java.util.Comparator<TradeOrder>
{

    // TODO complete class

    private boolean asc;


    /**
     * a
     */
    public PriceComparator()
    {
        asc = true;
    }


    /**
     * a
     * 
     * @param a
     *            a
     */
    public PriceComparator( boolean a )
    {
        asc = a;
    }


    /**
     * c
     * 
     * @param order1
     *            o
     * @param order2
     *            o
     *            @return r
     */
    public int compare( TradeOrder order1, TradeOrder order2 )
    {
        if ( order1.isLimit() && order2.isMarket() )
        {
            return 1;
        }
        if ( order1.isMarket() && order2.isMarket() )
        {
            return 0;
        }
        if ( order1.isMarket() && order2.isLimit() )
        {
            return -1;
        }

        if ( asc )
        {
            return (int)( ( order1.getPrice() - order2.getPrice() ) * 100 );
        }
        else
        {
            return (int)( ( order2.getPrice() - order1.getPrice() ) * 100 );
        }
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
