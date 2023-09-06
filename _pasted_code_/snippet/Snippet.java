package snippet;

public class Snippet
{
    public void placeOrder( TradeOrder order )
        {
            if ( order == null )
                return;
            exchange.placeOrder( order );
        }
    
}

