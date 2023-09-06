
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * 
 * TODO Card UI
 *
 * @author neilchow
 * @version May 26, 2020
 * @author Period: TODO
 * @author Assignment: MTG
 *
 * @author Sources: TODO
 */
public class CardButton extends JButton
{
    private Card card;


    /**
     * Constructor
     * 
     * @param c
     *            Card
     */
    public CardButton( Card c )
    {
        // TODO Auto-generated constructor stub
        card = c;
        // setText( card.getCardName() );
        if ( card.getImage() != null )
        {
            setIcon( resizeIcon( card.getImage(), 129, 178 ) );
        }
        setMargin( new Insets( 0, 0, 0, 0 ) );
        setBorder( null );

        addActionListener( new ActionListener()
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                if ( Game.getStepCounter() == 3 )
                {
                    System.out.println( "haha no flash" );
                }
                else if ( Game.getStepCounter() == 0
                    || Game.getStepCounter() == 2 )
                {
                    if ( card.getCurrentZone() == 0 )
                    {
                        card.setCurrentZone( 1 );
                        if ( Game.playCard( card ) )
                        {
                            card.setCurrentZone( 1 );
                        }
                        else
                        {
                            card.setCurrentZone( 0 );
                        }

                    }
                    else if ( card.getCurrentZone() == 1
                        && card.getCardType().contains( "Land" )
                        && card.getTap() == false )
                    {
                        Game.addMana();
                        card.setTap( true );
                        Game.refresh();
                    }
                }
                else if ( Game.getStepCounter() == 1 && card.getTap() == false
                    && card.getSick() == false
                    && card.getCardType().contains( "Creature" )
                    && card.getCurrentZone() == 1 )
                {
                    Game.addDamage( card.getPower() );
                    System.out.println( Game.getDamage() );
                }

            }

        } );

    }


    /**
     * 
     * TODO Resizes icon.
     * 
     * @param icon
     *            image
     * @param resizedWidth
     *            width
     * @param resizedHeight
     *            height
     * @return resized Icon
     */
    private static Icon resizeIcon(
        ImageIcon icon,
        int resizedWidth,
        int resizedHeight )
    {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance( resizedWidth,
            resizedHeight,
            java.awt.Image.SCALE_SMOOTH );
        return new ImageIcon( resizedImage );
    }


    /**
     * Not used
     * 
     * @param icon
     *            i
     */
    public CardButton( Icon icon )
    {
        // TODO Auto-generated constructor stub
        super( icon );
    }


    /**
     * Not used
     * 
     * @param text
     *            t
     */
    public CardButton( String text )
    {
        // TODO Auto-generated constructor stub
        super( text );
    }


    /**
     * Not used
     * 
     * @param a
     *            a
     */
    public CardButton( Action a )
    {
        // TODO Auto-generated constructor stub
        super( a );
    }


    /**
     * Not used
     * 
     * @param text
     *            t
     * @param icon
     *            i
     */
    public CardButton( String text, Icon icon )
    {
        // TODO Auto-generated constructor stub
        super( text, icon );
    }

}
