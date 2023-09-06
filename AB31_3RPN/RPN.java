import java.util.*;
import java.util.regex.Pattern;


/**
 * RPN Calculator
 *
 * @author TODO Your Name
 * @version TODO Date
 * @author Period: TODO Your Period
 * @author Assignment: AB31RPN Calculator
 *
 * @author Sources: TODO List Collaborators
 */
public class RPN
{
    Scanner scan = new Scanner( System.in );

    private Stack<Integer> myStack;

    private Queue<String> myQ;


    /**
     * Constructs an RPN Calculator
     */
    public RPN()
    {
        // TODO complete constructor
        myStack = new Stack<Integer>();
        myQ = new LinkedList<String>();
    }


    /**
     * **** Used for testing - Do Not Remove ***
     * 
     * Constructs an RPN Calculator and then redirects the Scanner input to the
     * supplied string.
     * 
     * @param console
     *            replaces console input
     */
    public RPN( String console )
    {
        this();
        scan = new Scanner( console );
    }


    /**
     * TODO Write your method description here.
     */
    public void calculate()
    {
        // TODO complete method
        qInput();
        while ( myQ.peek() != null && !myQ.peek().equals( "q" )
            && !myQ.peek().equals( "Q" ) )
        {
            String value = myQ.remove();
        }
    }


    // TODO: additional helper methods
    public void qInput()
    {
        Scanner s = new Scanner( System.in );
        String input = s.nextLine();
        myQ.add( input );
        while ( !input.equals( "Q" ) && !input.equals( "q" ) )
        {
            input = s.nextLine();
            // System.out.println( input == "q" );
            myQ.add( input );
        }
        System.out.println( myQ );
    }


    /**
     * Instantiates an RPN Calculator and invokes it calculate method
     * 
     * @param args
     *            command-line arguments (not used)
     */
    public static void main( String[] args )
    {
        RPN rpn = new RPN();

        rpn.calculate();
    }
}