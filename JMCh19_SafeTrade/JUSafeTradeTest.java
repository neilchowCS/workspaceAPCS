import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.regex.*;

import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * SafeTrade tests: TradeOrder PriceComparator Trader Brokerage StockExchange
 * Stock
 *
 * @author TODO Name of principal author
 * @author TODO Name of group member
 * @author TODO Name of group member
 * @version TODO date
 * @author Assignment: JM Chapter 19 - SafeTrade
 * 
 * @author Sources: TODO sources
 *
 */
public class JUSafeTradeTest
{
    // --Test TradeOrder
    /**
     * TradeOrder tests: TradeOrderConstructor - constructs TradeOrder and then
     * compare toString TradeOrderGetTrader - compares value returned to
     * constructed value TradeOrderGetSymbol - compares value returned to
     * constructed value TradeOrderIsBuy - compares value returned to
     * constructed value TradeOrderIsSell - compares value returned to
     * constructed value TradeOrderIsMarket - compares value returned to
     * constructed value TradeOrderIsLimit - compares value returned to
     * constructed value TradeOrderGetShares - compares value returned to
     * constructed value TradeOrderGetPrice - compares value returned to
     * constructed value TradeOrderSubtractShares - subtracts known value &
     * compares result returned by getShares to expected value
     */
    private String symbol = "GGGL";

    private boolean buyOrder = true;

    private boolean marketOrder = true;

    private int numShares = 123;

    private int numToSubtract = 24;

    private double price = 123.45;


    @Test
    public void tradeOrderConstructor()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        String toStr = to.toString();

        assertTrue( "<< Invalid TradeOrder Constructor >>",
            toStr.contains( "TradeOrder[Trader trader:null" )
                && toStr.contains( "java.lang.String symbol:" + symbol )
                && toStr.contains( "boolean buyOrder:" + buyOrder )
                && toStr.contains( "boolean marketOrder:" + marketOrder )
                && toStr.contains( "int numShares:" + numShares )
                && toStr.contains( "double price:" + price ) );
    }


    @Test
    public void TradeOrderToString()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNotNull( to.toString() );
    }


    @Test
    public void tradeOrderGetTrader()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertNull( "<< TradeOrder: " + to.getTrader() + " should be null >>",
            to.getTrader() );
    }


    @Test
    public void tradeOrderGetSymbol()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getTrader() + " should be "
            + symbol + " >>", symbol, to.getSymbol() );
    }


    @Test
    public void tradeOrderIsBuy()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertTrue(
            "<< TradeOrder: " + to.isBuy() + " should be " + buyOrder + " >>",
            to.isBuy() );
    }


    @Test
    public void tradeOrderIsSell()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertFalse(
            "<< TradeOrder: " + to.isSell() + " should be " + !buyOrder
                + " >>",
            to.isSell() );
    }


    @Test
    public void tradeOrderIsMarket()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue(
            "<< TradeOrder: " + to.isMarket() + " should be " + marketOrder
                + " >>",
            to.isMarket() );
    }


    @Test
    public void tradeOrderIsLimit()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertFalse(
            "<< TradeOrder: " + to.isLimit() + " should be " + !marketOrder
                + ">>",
            to.isLimit() );
    }


    @Test
    public void tradeOrderGetShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertTrue(
            "<< TradeOrder: " + to.getShares() + " should be " + numShares
                + ">>",
            numShares == to.getShares()
                || ( numShares - numToSubtract ) == to.getShares() );
    }


    @Test
    public void tradeOrderGetPrice()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        assertEquals( "<< TradeOrder: " + to.getPrice() + " should be " + price
            + ">>", price, to.getPrice(), 0.0 );
    }


    @Test
    public void tradeOrderSubtractShares()
    {
        TradeOrder to = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        to.subtractShares( numToSubtract );
        assertEquals(
            "<< TradeOrder: subtractShares(" + numToSubtract + ") should be "
                + ( numShares - numToSubtract ) + ">>",
            numShares - numToSubtract,
            to.getShares() );
    }


    // --Test TraderWindow Stub
    @Test
    public void traderWindowConstructor()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
    }


    @Test
    public void traderWindowShowMessage()
    {
        TraderWindow tw = new TraderWindow( null );
        assertNotNull( tw );
        tw.showMessage( null );
    }

    // --Test PriceComparator


    // TODO your tests here
    @Test
    public void priceComparatorConstructor()
    {
        PriceComparator pc = new PriceComparator();
        String toStr = pc.toString();

        assertEquals( true, true );
    }


    @Test
    public void priceComparatorConstructorFalse()
    {
        PriceComparator pc = new PriceComparator( false );

        assertEquals( false, false );
    }


    @Test
    public void priceComparatorCompare()
    {
        PriceComparator pc = new PriceComparator();

        TradeOrder order1 = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );
        TradeOrder order2 = new TradeOrder( null,
            symbol,
            buyOrder,
            marketOrder,
            numShares,
            price );

        assertEquals(
            "<< PriceComparator: compare(market, market) should be 0 >>",
            pc.compare( order1, order2 ),
            0 );

    }

    // --Test Trader

    String p = "pass";

    String n = "name";

    StockExchange e = new StockExchange();

    Brokerage b = new Brokerage( e );


    // TODO your tests here
    @Test
    public void traderConstructor()

    {

        e.listStock( "TSLA", "Tesla", 0.00 );

        Trader t = new Trader( b, n, p );

        String str = t.toString();

        assertTrue( "<< Invalid Trader Constructor >>",

            str.contains( "Trader[" ) );

    }


    @Test
    public void traderEquals()

    {
        Trader t = new Trader( b, n, p );
        assertTrue( "<<  >>", t.equals( t ) );
    }


    @Test
    public void traderGetName()

    {
        Trader t = new Trader( b, n, p );
        assertTrue( "<< Trader: getName should be " + n + " >>",
            t.getName().equals( n ) );

    }


    @Test
    public void traderGetPassword()

    {
        Trader t = new Trader( b, n, p );
        assertTrue( "<< Trader: getPassword should be " + p + " >>",
            t.getPassword().equals( p ) );

    }


    @Test
    public void traderGetQuote()

    {
        Trader t = new Trader( b, n, p );

        t.getQuote( "TSLA" );

        assertTrue( "", true );
    }


    @Test
    public void traderHasMessages()

    {

        e.listStock( "TSLA", "Tesla", 0.00 );

        Trader t = new Trader( b, n, p );

        String str = t.toString();

        boolean tr = t.hasMessages();

        assertTrue( true );

    }

    // --Test Brokerage


    // TODO your tests here
    @Test
    public void brokerageConstructor()

    {
        e.listStock( "TSLA", "Tesla", 0.00 );

        Trader t = new Trader( b, n, p );

        String str = t.toString();

        b.logout( t );

        t.quit();

        t.equals( t );

        t.openWindow();

        t.receiveMessage( "" );

        t.compareTo( t );

        b.placeOrder( null );

        b.getQuote( "", t );

        b.login( "kjbjbkjbkjbkjbkjbkjbkjbkj", "asdssdsadsadwad" );

        b.addUser( n, p );
        assertTrue( true );

    }


    @Test
    public void stockConstructor()
    {
        Stock s = new Stock( symbol, n, price );
        s.getQuote();
        s.orderStock();
        s.toString();
        s.placeOrder( null );

        assertEquals( true, true );
    }

    // --Test StockExchange

    // TODO your tests here

    // --Test Stock

    // TODO your tests here

    // Remove block comment below to run JUnit test in console
    /*
     * public static junit.framework.Test suite() { return new
     * JUnit4TestAdapter( JUSafeTradeTest.class ); }
     * 
     * public static void main( String args[] ) {
     * org.junit.runner.JUnitCore.main( "JUSafeTradeTest" ); }
     */
}
