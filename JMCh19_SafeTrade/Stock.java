import java.util.*;
import java.lang.reflect.*;
//import java.text.DecimalFormat;


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
public class Stock
{
    //private static DecimalFormat money = new DecimalFormat( "0.00" );

    private String stockSymbol;

    private String companyName;

    private double loPrice;

    private double hiPrice;

    private double lastPrice;

    private int volume;

    private PriorityQueue<TradeOrder> buyOrders;

    private PriorityQueue<TradeOrder> sellOrders;


    /**
     * s
     * 
     * @param symbol
     *            s
     * @param name
     *            n
     * @param price
     *            p
     */
    public Stock( String symbol, String name, double price )
    {
        stockSymbol = symbol;
        companyName = name;
        loPrice = price;
        hiPrice = price;
        lastPrice = price;
        volume = 0;
        sellOrders = new PriorityQueue<TradeOrder>( 10,
            new PriceComparator() );
        buyOrders = new PriorityQueue<TradeOrder>( 10,
            new PriceComparator( false ) );
    }


    // TODO complete class
    /*
     * The quote includes the last sale price, the price and number of shares
     * offered in the current highest bid and lowest “ask” (sell order), the
     * day’s high and low price for the stock, and the volume, which is the
     * total number of shares traded during the “day.”
     */
    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public String getQuote()
    {
        String ask = "Ask: ";
        String bid = "Bid: ";
        if ( sellOrders.peek() != null )
        {
            ask = " Ask: " + sellOrders.peek().getPrice() + " Size: "
                + sellOrders.peek().getShares();
        }
        if ( buyOrders.peek() != null )
        {
            bid = " Bid: " + buyOrders.peek().getPrice() + " Size: "
                + buyOrders.peek().getShares();
        }

        String quote = stockSymbol + " Price: " + lastPrice + ask + bid
            + " High: " + hiPrice + " Low: " + loPrice + " Volume: " + volume
            + "\n";

        return quote;

    }


    /**
     * r TODO Write your method description here.
     * 
     * @param order
     *            o
     */
    public void placeOrder( TradeOrder order )
    {
        if ( order == null )
        {
            return;
        }
        if ( order.getBuy() )
        {
            buyOrders.add( order );
            order.getTrader().receiveMessage( "buy order" );
        }
        else
        {
            sellOrders.add( order );
            order.getTrader().receiveMessage( "sell order" );
        }

        orderStock();
    }


    /**
     * 
     * TODO Write your method description here.
     */
    public void orderStock()
    {
        if ( buyOrders.isEmpty() || sellOrders.isEmpty() )
        {
            return;
        }

        double price = 0;
        TradeOrder buy = buyOrders.peek();
        TradeOrder sell = sellOrders.peek();
        Trader buyer = buy.getTrader();
        Trader seller = sell.getTrader();

        if ( !buy.getMarket() && !sell.getMarket()
            && buy.getPrice() >= sell.getPrice() )
        {
            price = sell.getPrice();
        }
        else if ( buy.getMarket() && sell.getMarket() )
        {
            price = lastPrice;
        }
        else if ( !buy.getMarket() && sell.getMarket() )
        {
            price = buy.getPrice();
        }
        else if ( buy.getMarket() && !sell.getMarket() )
        {
            price = sell.getPrice();
        }
        else
        {
            return;
        }

        int n = Math.min( buy.getShares(), sell.getShares() );

        buy.subtractShares( n );
        sell.subtractShares( n );
        volume += n;
        lastPrice = price;

        if ( price < loPrice )
        {
            loPrice = price;
        }

        if ( price > hiPrice )
        {
            hiPrice = price;
        }

        if ( buy.getShares() == 0 )
        {
            buyOrders.remove( buy );
        }

        if ( sell.getShares() == 0 )
        {
            sellOrders.remove( sell );
        }

        buyer.receiveMessage( "bought shares" );
        seller.receiveMessage( "bought shares" );

        if ( !buyOrders.isEmpty() && !sellOrders.isEmpty() )
        {
            orderStock();
        }
    }


    //
    // The following are for test purposes only
    //
/**
 * 
 * TODO Write your method description here.
 * @return private PriorityQueue<TradeOrder>
 */
    protected String getStockSymbol()
    {
        return stockSymbol;
    }

/**
 * 
 * TODO Write your method description here.
 * @return private PriorityQueue<TradeOrder>
 */
    protected String getCompanyName()
    {
        return companyName;
    }

/**
 * 
 * TODO Write your method description here.
 * @return private PriorityQueue<TradeOrder>
 */
    protected double getLoPrice()
    {
        return loPrice;
    }

/**
 * 
 * TODO Write your method description here.
 * @return private PriorityQueue<TradeOrder>
 */
    protected double getHiPrice()
    {
        return hiPrice;
    }

/**
 * 
 * TODO Write your method description here.
 * @return private PriorityQueue<TradeOrder>
 */
    protected double getLastPrice()
    {
        return lastPrice;
    }

/**
 * 
 * TODO Write your method description here.
 * @return private PriorityQueue<TradeOrder>
 */
    protected int getVolume()
    {
        return volume;
    }

/**
 * 
 * TODO Write your method description here.
 * @return private PriorityQueue<TradeOrder>
 */
    protected PriorityQueue<TradeOrder> getBuyOrders()
    {
        return buyOrders;
    }

/**
 * 
 * TODO Write your method description here.
 * @return private PriorityQueue<TradeOrder>
 */
    protected PriorityQueue<TradeOrder> getSellOrders()
    {
        return sellOrders;
    }


    /**
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Stock.
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
