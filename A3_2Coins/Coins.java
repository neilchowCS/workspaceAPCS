import java.lang.reflect.Field;
import java.util.Scanner;


/**
 * Coins: This class accepts a certain amount of monetary change (in cents). The
 * output is a list of the number of quarters, dimes, nickels, and pennies that
 * will make that amount of change with the least number of coins possible.
 *
 * @author TODO Neil Chow
 * @version TODO 9/3/19
 * @author Period: TODO 2
 * 
 * @author Assignment: Lab Activity 3.2 - Coins
 * 
 * @author Sources: TODO: none
 */
public class Coins
{
    private int myChange;


    /** sets myChange @param change change*/
    public Coins( int change )
    {

        myChange = change;
    }


    /** calculates change */
    public void calculate()
    {
        /** new variable */
        int remaining = myChange;
        if ( remaining >= 25 )
        {
            System.out.println( "Quarter(s): " + remaining / 25 );
            remaining = remaining % 25;
        }
        else
        {
            System.out.println( "Quarter(s): " + 0 );
        }
        if ( remaining >= 10 )
        {
            System.out.println( "Dime(s): " + remaining / 10 );
            remaining = remaining % 10;
        }
        else
        {
            System.out.println( "Dime(s): " + 0 );
        }
        if ( remaining >= 5 )
        {
            System.out.println( "Nickels(s): " + remaining / 5 );
            remaining = remaining % 5;
        }
        else
        {
            System.out.println( "Nickel(s): " + 0 );
        }
        if ( remaining >= 0 )
        {
            System.out.println( "Penny(s): " + remaining );
        }
        else
        {
            System.out.println( "Penny(s): " + 0 );
        }

    }


    /**
     * Intended only for debugging.
     * 
     * <p>
     * A generic toString implementation that uses reflection to print names and
     * values of all fields <em>declared in this class</em>. Note that
     * superclass fields are left out of this implementation.
     * </p>
     * 
     * @return a string representation of this Easter.
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
                str += separator + field.getType().getName() + " " + 
            field.getName() + ":"
                    + field.get( this );
            }
            catch ( IllegalAccessException ex )
            {
                System.out.println( ex );
            }
            separator = ", ";
        }
        return str + "]";
    }


    /**
     * Tester for the Coins class.
     * 
     * @param args
     *            command line arguments - not used
     */
    public static void main( String[] args )
    {
        Scanner console = new Scanner( System.in );

        System.out.print( "Please enter the number of cents --> " );
        int cents = console.nextInt();

        Coins change = new Coins( cents );
        change.calculate();
    }
}
