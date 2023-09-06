
import javax.swing.ImageIcon;


/**
 * 
 * The almighty card that encompasses all things
 *
 * @author neilchow
 * @version May 26, 2020
 * @author Period: TODO
 * @author Assignment: MTG
 *
 * @author Sources: TODO
 */
public class Card
{
    private String cardName;

    private String cardType;

    private String cardSubtype;

    private ImageIcon image;

    private int currentZone;

    private int cost;

    private boolean tapped;

    private boolean sick;

    private int power;


    /**
     * Card Constructor
     * 
     * @param n
     *            name
     * @param t
     *            type
     * @param s
     *            subtype
     * @param i
     *            image
     * @param c
     *            cost
     * @param p
     *            power
     */
    public Card( String n, String t, String s, ImageIcon i, int c, int p )
    {
        cardName = n;
        cardType = t;
        cardSubtype = s;
        image = i;
        currentZone = 0;
        cost = c;
        tapped = false;
        sick = true;
        power = p;
    }


    /**
     * 
     * TODO Returns name.
     * 
     * @return cardName
     */
    public String getCardName()
    {
        return cardName;
    }


    /**
     * 
     * TODO Returns card type.
     * 
     * @return cardType
     */
    public String getCardType()
    {
        return cardType;
    }


    /**
     * 
     * TODO Returns subtype.
     * 
     * @return cardSubtype
     */
    public String getCardSubtype()
    {
        return cardSubtype;
    }


    /**
     * 
     * TODO Returns image.
     * 
     * @return image
     */
    public ImageIcon getImage()
    {
        return image;
    }


    /**
     * 
     * TODO Returns zone card is in.
     * 
     * @return currentZone
     */
    public int getCurrentZone()
    {
        return currentZone;
    }


    /**
     * 
     * TODO Returns cost.
     * 
     * @return cost
     */
    public int getCost()
    {
        return cost;
    }


    /**
     * 
     * TODO Returns power.
     * 
     * @return power
     */
    public int getPower()
    {
        return power;
    }


    /**
     * 
     * TODO Returns tap.
     * 
     * @return boolean tap
     */
    public boolean getTap()
    {
        return tapped;
    }


    /**
     * 
     * TODO Returns summoning sickness.
     * 
     * @return boolean sick
     */
    public boolean getSick()
    {
        return sick;
    }


    /**
     * 
     * TODO sets tap.
     * 
     * @param i
     *            value
     */
    public void setTap( boolean i )
    {
        tapped = i;
    }


    /**
     * 
     * TODO sets sick.
     * 
     * @param i
     *            value
     */
    public void setSick( boolean i )
    {
        sick = i;
    }


    /**
     * 
     * TODO sets zone.
     * 
     * @param i
     *            value
     */
    public void setCurrentZone( int i )
    {
        currentZone = i;
    }
}
