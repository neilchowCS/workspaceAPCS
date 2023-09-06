
import javax.swing.ImageIcon;


/**
 * 
 * TODO Extends card, has additional methods dealing with damage
 *
 * @author neilchow
 * @version May 26, 2020
 * @author Period: TODO
 * @author Assignment: MTG
 *
 * @author Sources: TODO
 */
public class Creature extends Card
{

    private int toughness;

    private int damage;


    /**
     * Constructor
     * 
     * @param n
     *            name
     * @param t
     *            type
     * @param s
     *            subtype
     * @param i
     *            image
     * @param p
     *            power
     * @param tough
     *            toughness
     * @param cost
     *            cost
     */
    public Creature(
        String n,
        String t,
        String s,
        ImageIcon i,
        int p,
        int tough,
        int cost )
    {
        // TODO Auto-generated constructor stub
        super( n, t, s, i, cost, p );
        toughness = tough;
        damage = 0;
    }


    /**
     * 
     * TODO Returns toughness.
     * 
     * @return toughness
     */
    public int getToughness()
    {
        return toughness;
    }


    /**
     * 
     * TODO Returns damage.
     * 
     * @return damage
     */
    public int getDamage()
    {
        return damage;
    }


    /**
     * 
     * TODO Increments self damage.
     * 
     */
    public void dealDamage( int n )
    {
        damage += n;
    }


    /**
     * 
     * TODO Sets self damage to 0.
     */
    public void refreshDamage()
    {
        damage = 0;
    }


    /**
     * to string
     * 
     * @return string
     */
    public String toString()
    {
        return ( getCardName() );

    }

}
