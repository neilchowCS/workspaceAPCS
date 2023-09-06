import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.*;


/**
 * 
 * TODO Main class.
 *
 * @author neilchow
 * @version May 16, 2020
 * @author Period: TODO
 * @author Assignment: MTG
 *
 * @author Sources: TODO
 */
public class Game
{

    private static ArrayList<Card> deck = new ArrayList<Card>();

    private static ArrayList<Card> hand = new ArrayList<Card>();

    private static ArrayList<Card> battlefield = new ArrayList<Card>();

    private static JFrame frame = new JFrame( "Frame" );

    // hand
    private static JPanel panel = new JPanel();

    // battlefield
    private static JPanel panelCenter = new JPanel();

    // next
    private static JPanel panelLineEnd = new JPanel();

    // display
    private static JPanel panelLineStart = new JPanel();

    // b2
    private static JPanel panelPageStart = new JPanel();

    // display child
    private static JLabel manaP = new JLabel();

    // display child
    private static JLabel stepP = new JLabel();

    // display child
    private static JLabel lifeP = new JLabel();

    // display child
    private static JLabel lifeP2 = new JLabel();

    private static int[] mana;

    private static int stepCounter;

    private static boolean landPlayed;

    private static int life;

    private static int life2;

    private static int totalDamage;


    /**
     * 
     * TODO Returns step.
     * 
     * @return step
     */
    public static int getStepCounter()
    {
        return stepCounter;
    }


    /**
     * 
     * TODO fills deck, draws n cards
     * 
     * @param n
     *            n
     */
    public static void startingHand( int n )
    {
        for ( int i = 0; i < 20; i++ )
        {
            deck.add( new GrizzlyBears() );
        }
        for ( int i = 0; i < 10; i++ )
        {
            deck.add( new LeatherbackBaloth() );
        }
        for ( int i = 0; i < 30; i++ )
        {
            deck.add( new Forest() );
        }
        Collections.shuffle( deck );

        for ( int i = 0; i < n; i++ )
        {
            hand.add( deck.remove( 0 ) );
        }

        for ( int i = 0; i < hand.size(); i++ )
        {
            CardButton b = new CardButton( hand.get( i ) );
            panel.add( b );
        }
    }


    /**
     * 
     * TODO Draws a card
     */
    public static void draw()
    {
        hand.add( deck.remove( 0 ) );
        CardButton b = new CardButton( hand.get( hand.size() - 1 ) );
        panel.add( b );
    }


    /**
     * 
     * TODO removes card from hand, adds to battlefield
     * 
     * @return whether card was played
     * @param c
     *            card to play
     */
    public static boolean playCard( Card c )
    {
        if ( c.getCardType().contains( "Land" ) && !landPlayed )
        {
            int i = hand.indexOf( c );
            hand.remove( c );
            battlefield.add( c );
            CardButton b = new CardButton( c );
            panelCenter.add( b );
            panel.remove( i );
            panel.repaint();
            panel.revalidate();
            System.out.println( c.getCardName() );
            landPlayed = true;
            return true;
        }
        else if ( c.getCardType().contains( "Creature" )
            && c.getCost() <= mana[0] )
        {
            int i = hand.indexOf( c );
            hand.remove( c );
            battlefield.add( c );
            CardButton b = new CardButton( c );
            mana[0] -= c.getCost();
            panelCenter.add( b );
            panel.remove( i );
            panel.repaint();
            panel.revalidate();
            System.out.println( c.getCardName() );
            refresh();
            return true;
        }

        return false;
    }


    /**
     * 
     * TODO Spaces out labels.
     */
    public static void addSpacing()
    {
        JPanel temp = new JPanel();
        panelLineStart.add( temp );
    }


    /**
     * 
     * TODO Add one mana to mana pool.
     */
    public static void addMana()
    {
        mana[0]++;
    }


    /**
     * 
     * TODO returns mana
     * 
     * @return mana array
     */
    public static int[] getMana()
    {
        return mana;
    }


    /**
     * 
     * TODO Adds to total damage
     * 
     * @param i
     *            value
     */
    public static void addDamage( int i )
    {
        totalDamage += i;
    }


    /**
     * 
     * TODO Reduces player life total.
     * 
     * @param i
     *            value
     */
    public static void takeDamage( int i )
    {
        life -= i;
        if ( life <= 0 )
        {
            System.exit( 0 );
        }
    }


    /**
     * 
     * TODO Adds card to opponent's battlefield.
     * 
     * @param c
     *            card
     */
    public static void panelPageStartAdd( Card c )
    {
        CardButton b = new CardButton( c );
        for ( ActionListener g : b.getActionListeners() )
        {
            b.removeActionListener( g );
        }
        panelPageStart.add( b );
        panelPageStart.repaint();
        panelPageStart.revalidate();
        System.out.println( c.getCardName() );
    }


    /**
     * 
     * TODO Refresh screen.
     */
    public static void refresh()
    {
        manaP.setText( "Mana Pool: " + mana[0] );

        lifeP.setText( "Health: " + life );

        lifeP2.setText( "OP Health: " + life2 );

        if ( stepCounter == 0 )
        {
            stepP.setText( "Pre-Combat Main" );
        }
        else if ( stepCounter == 1 )
        {
            stepP.setText( "Combat" );
        }
        else if ( stepCounter == 2 )
        {
            stepP.setText( "Post-Combat Main" );
        }
        else
        {
            stepP.setText( "Opponent's turn" );
        }

        frame.setVisible( true );

    }


    /**
     * 
     * TODO Main
     * 
     * @param args
     *            a
     */
    public static void main( String[] args )
    {
        Opponent OP = new Opponent();
        OP.opponentInit( 5 );
        mana = new int[] { 0 };
        stepCounter = 0;
        landPlayed = false;
        totalDamage = 0;
        life = 20;
        life2 = 20;

        panel.setPreferredSize( new Dimension( 1200, 200 ) );
        panelCenter.setPreferredSize( new Dimension( 1100, 300 ) );
        panelCenter.setBackground( Color.LIGHT_GRAY );
        panelLineEnd.setPreferredSize( new Dimension( 100, 500 ) );
        panelLineStart.setPreferredSize( new Dimension( 150, 100 ) );
        panelPageStart.setPreferredSize( new Dimension( 1100, 300 ) );
        manaP.setPreferredSize( new Dimension( 150, 20 ) );
        stepP.setPreferredSize( new Dimension( 150, 20 ) );
        lifeP.setPreferredSize( new Dimension( 150, 20 ) );
        lifeP2.setPreferredSize( new Dimension( 150, 20 ) );

        JButton next = new JButton( "Next" );
        next.setPreferredSize( new Dimension( 100, 50 ) );
        next.addActionListener( new ActionListener()
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                mana = new int[] { 0 };

                if ( stepCounter == 0 )
                {
                    stepCounter++;
                }
                else if ( stepCounter == 1 )
                {
                    life2 -= totalDamage;
                    totalDamage = 0;
                    stepCounter++;
                    if ( life2 <= 0 )
                    {
                        System.exit( 0 );
                    }
                }
                else if ( stepCounter == 2 )
                {
                    stepCounter++;
                }
                else
                {
                    // opponent's turn
                    OP.opponentPlay();
                    // upkeep
                    stepCounter = 0;
                    draw();
                    landPlayed = false;
                    for ( int i = 0; i < battlefield.size(); i++ )
                    {
                        battlefield.get( i ).setTap( false );
                        battlefield.get( i ).setSick( false );
                    }
                }

                refresh();
            }
        } );

        frame.add( panelCenter, BorderLayout.CENTER );
        frame.add( panelLineEnd, BorderLayout.LINE_END );
        panelLineEnd.add( next );
        frame.add( panel, BorderLayout.PAGE_END );
        frame.add( panelLineStart, BorderLayout.LINE_START );
        frame.add( panelPageStart, BorderLayout.PAGE_START );
        panelLineStart.setLayout( new BoxLayout( panelLineStart, 1 ) );

        panelLineStart.add( lifeP2 );
        addSpacing();
        panelLineStart.add( stepP );
        addSpacing();
        panelLineStart.add( manaP );
        addSpacing();
        panelLineStart.add( lifeP );

        manaP.setText( "Mana Pool: " + mana[0] );
        stepP.setText( "Pre-Combat Main" );
        lifeP.setText( "Health: " + life );
        lifeP2.setText( "OP Health: " + life2 );

        startingHand( 5 );

        frame.pack();
        frame.setVisible( true );

    }


    /**
     * 
     * TODO returns total damage
     * 
     * @return totalDamage
     */
    public static int getDamage()
    {
        // TODO Auto-generated method stub
        return totalDamage;
    }

}
