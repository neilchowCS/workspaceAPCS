import java.util.ArrayList;
import java.util.Collections;


/**
 * 
 * TODO Opponent, initializes deck, hand, plays the game
 *
 * @author neilchow
 * @version May 26, 2020
 * @author Period: TODO
 * @author Assignment: MTG
 *
 * @author Sources: TODO
 */
public class Opponent
{

    private static ArrayList<Card> OPdeck = new ArrayList<Card>();

    private static ArrayList<Card> OPhand = new ArrayList<Card>();

    private static ArrayList<Card> OPbattlefield = new ArrayList<Card>();


    /**
     * constructor
     */
    public Opponent()
    {

    }


    /**
     * 
     * TODO Creates deck, hand
     * 
     * @param n
     *            number of cards in opening hand
     */
    public void opponentInit( int n )
    {
        for ( int i = 0; i < 30; i++ )
        {
            OPdeck.add( new GrizzlyBears() );
        }
        for ( int i = 0; i < 30; i++ )
        {
            OPdeck.add( new Forest() );
        }
        Collections.shuffle( OPdeck );

        for ( int i = 0; i < n; i++ )
        {
            OPhand.add( OPdeck.remove( 0 ) );
        }
    }


    /**
     * 
     * TODO One turn of the opponent
     */
    public void opponentPlay()
    {
        for ( int i = 0; i < OPbattlefield.size(); i++ )
        {
            OPbattlefield.get( i ).setSick( false );
            OPbattlefield.get( i ).setTap( false );
        }
        OPhand.add( OPdeck.remove( 0 ) );
        boolean hasLand = false;
        for ( int i = 0; i < OPhand.size(); i++ )
        {
            if ( hasLand == false
                && OPhand.get( i ).getCardType().contains( "Land" ) )
            {
                hasLand = true;
                Game.panelPageStartAdd( OPhand.get( i ) );
                OPbattlefield.add( OPhand.remove( i ) );
                i--;
            }
        }
        int manaCount = 0;
        for ( int i = 0; i < OPbattlefield.size(); i++ )
        {
            if ( OPbattlefield.get( i ).getCardType().contains( "Land" ) )
            {
                manaCount++;
            }
        }
        for ( int i = 0; i < OPhand.size(); i++ )
        {
            if ( OPhand.get( i ).getCardType().contains( "Creature" )
                && OPhand.get( i ).getCost() <= manaCount )
            {
                manaCount -= OPhand.get( i ).getCost();
                Game.panelPageStartAdd( OPhand.get( i ) );
                OPbattlefield.add( OPhand.remove( i ) );
                i--;
            }
        }
        for ( int i = 0; i < OPbattlefield.size(); i++ )
        {
            if ( OPbattlefield.get( i ).getCardType().contains( "Creature" )
                && !OPbattlefield.get( i ).getSick()
                && !OPbattlefield.get( i ).getTap() )
            {
                Game.takeDamage( OPbattlefield.get( i ).getPower() );
            }
        }
    }

}
