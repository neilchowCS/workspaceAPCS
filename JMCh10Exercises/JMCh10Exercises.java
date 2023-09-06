import java.util.*;
import java.util.regex.Pattern;


/**
 * Java Methods Chapter 10 Exercises 2, 6 - 11, 14 - 15, 20 & 22
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - Ch10Exercises
 * 
 * @author Sources - TODO list collaborators
 */
public class JMCh10Exercises
{
    Scanner scan;


    /**
     * Constructs a Scanner for input from the console.
     */
    public JMCh10Exercises()
    {
        scan = new Scanner( System.in );
    }


    /**
     * Constructs a Scanner to evaluate passed input (used for testing).
     * 
     * @param str
     *            input for the various methods
     */
    public JMCh10Exercises( String str )
    {
        scan = new Scanner( str );
    }


    // 10-2(a)
    public boolean endsWithStar( String s )
    {
        // TODO complete method
        if ( s.charAt( s.length() - 1 ) == '*' )
        {
            return true;
        }

        return false; // FIX THIS!!!
    }


    // 10-2(b)
    public boolean endsWith2Stars( String s )
    {
        // TODO complete method
        if ( s.charAt( s.length() - 1 ) == '*'
            && s.charAt( s.length() - 2 ) == '*' )
        {
            return true;
        }

        return false; // FIX THIS!!!
    }


    // 10-6
    public String scroll( String s )
    {
        // TODO complete method

        return s.substring( 1 ) + s.charAt( 0 ); // FIX THIS!!!
    }


    // 10-7
    public String convertName( String name )
    {
        // TODO complete method
        int start = name.indexOf( ',' );

        return ( name.substring( start + 1 ) + " "
            + name.substring( 0, start ) ).trim(); // FIX
        // THIS!!!
    }


    // 10-8
    public String negate( String str )
    {
        // TODO complete method
        String a = str.replace( '0', '*' );
        String b = a.replace( '1', '0' );

        return b.replace( '*', '1' ); // FIX THIS!!!
    }


    // 10-9
    public boolean isConstant( String s )
    {
        // TODO complete method
        for ( int i = 1; i < s.length(); i++ )
        {
            if ( s.charAt( i ) != s.charAt( i - 1 ) )
            {
                break;
            }
            if ( i == s.length() - 1 )
            {
                return true;
            }
        }

        return false; // FIX THIS!!!
    }


    // 10-10
    public String removeComment( String str )
    {
        // TODO complete method
        String output = "";
        // System.out.println( str.indexOf( "/*" ) );
        // System.out.println( str.indexOf( "*/" ) );
        if ( str.indexOf( "/*" ) != -1 && str.indexOf( "*/" ) != -1 )
        {
            output += str.substring( 0, str.indexOf( "/*" ) );

            output += str.substring( str.indexOf( "*/" ) + 2 );
        }

        return str; // FIX THIS!!!
    }


    // 10-11
    public String cutOut( String s, String s2 )
    {
        // TODO complete method
        if ( s.indexOf( s2 ) != -1 )
        {
            return ( s.substring( 0, s.indexOf( s2 ) )
                + s.substring( s.indexOf( s2 ) + s2.length() ) );
        }

        return s; // FIX THIS!!!
    }


    // 10-14
    public String removeHtmlTags( String str )
    {
        // TODO complete method
        Pattern pattern = Pattern.compile( "<\\w>" );
        Pattern pattern2 = Pattern.compile( "</\\w>" );

      //  if ( pattern.matcher( str ).lookingAt()
      //     && pattern2.matcher( str ).lookingAt() )
        {
            String a = str.replaceFirst( "<\\w>", "" );
            String b = a.replaceFirst( "</\\w>", "" );
            return b;
        }

        //return str; // FIX THIS!!!
    }


    // 10-15
    public boolean onlyDigits( String s )
    {
        // TODO complete method
        for ( int i = 1; i < s.length(); i++ )
        {
            if ( !Character.isDigit( s.charAt( i ) ) )
            {
                break;
            }
            if ( i == s.length() - 1 )
            {
                return true;
            }
        }

        return false; // FIX THIS!!!
    }


    // 10-20
    public static boolean isValidISBN( String isbn )
    {
        // TODO complete method
        //Pattern pattern = Pattern.compile( "\\d*9[\\dX]" );
        //System.out.println(Pattern.matches( "\\d{9}[\\dX]", isbn ));
        if (Pattern.matches( "\\d{9}[\\dX]", isbn)){
            if (isbn.charAt( 9 ) == 'X') {
                int sum = 0;
                for (int i = 0; i < 10; i++) {
                    sum += (10-i)*Character.getNumericValue( isbn.charAt( i ) );
                    //System.out.println(i + " " + Character.getNumericValue( isbn.charAt( i )) + " " + sum);
                }
                sum += 10;
                //System.out.println(sum);
                return (sum % 11 == 0);
            }else {
                int sum = 0;
                for (int i = 0; i <10; i++) {
                    sum += (10-i)*Character.getNumericValue( isbn.charAt( i ) );
                }
                return (sum % 11 == 0);
            }
        }

        return false; // FIX THIS!!!
    }


    // 10-22
    public String shuffle( String s )
    {
        // TODO complete method
        StringBuffer b = new StringBuffer(s);
        int x = s.length() - 1;
        while (x > 0) {
            int n = (int)Math.random()*x + 1 ;
            Character temp = b.charAt( x );
            b.setCharAt( x, b.charAt( n ) );
            b.setCharAt( n, temp );
            x--;
        }

        return b.toString(); // FIX THIS!!!
    }


    /**
     * Testing method: instantiates a Ch18Ex1to5 object and then invokes each
     * method.
     * 
     * @param args
     *            command line parameters (not used)
     */
    public static void main( String[] args )
    {

        Scanner kbd = new Scanner( System.in );
        boolean done = false;

        JMCh10Exercises exercise = new JMCh10Exercises();
        //System.out.println(exercise.shuffle( "hello" ));

        do
        {
            System.out.println();
            System.out.println();
            System.out.println( "Make a selection" );
            System.out.println();
            System.out.println( "   (1) 10-2(a) endsWithStar( String s )" );
            System.out.println( "   (2) 10-2(b) endsWith2Stars( String s )" );
            System.out.println( "   (3) 10-6 scroll( String s )" );
            System.out.println( "   (4) 10-7 convertName( String name )" );
            System.out.println( "   (5) 10-8 negate( String str )" );
            System.out.println( "   (6) 10-9 isConstant( String s )" );
            System.out.println( "   (7) 10-10 removeComment( String str )" );
            System.out.println( "   (8) 10-11 cutOut( String s, String s2 )" );
            System.out.println( "   (9) 10-14 removeHtmlTags( String str )" );
            System.out.println( "   (A) 10-15 onlyDigits( String s )" );
            System.out.println( "   (B) 10-20 isValidISBN( String isbn )" );
            System.out.println( "   (C) 10-22 shuffle( String s )" );
            System.out.println( "   (Q) Quit" );
            System.out.println();
            System.out.print( "Enter a choice:  " );
            String response = kbd.nextLine();

            if ( response.length() > 0 )
            {
                System.out.println();

                switch ( response.charAt( 0 ) )
                {
                    case '1':
                        String end1Star = "**endsWith**Star*";
                        System.out.println( "endsWithStar(" + end1Star + ") = "
                            + exercise.endsWithStar( end1Star ) );
                        String ends0Star = "**endsWith**Star*No";
                        System.out.println( "endsWithStar(" + ends0Star
                            + ") = " + exercise.endsWithStar( ends0Star ) );
                        break;
                    case '2':
                        String end2Str = "**endsWith**2Stars**";
                        System.out.println( "endsWith2Stars(" + end2Str
                            + ") = " + exercise.endsWith2Stars( end2Str ) );
                        String endsWith1Star = "**endsWith**2Stars*";
                        System.out.println(
                            "endsWith2Stars(" + endsWith1Star + ") = "
                                + exercise.endsWith2Stars( endsWith1Star ) );
                        break;
                    case '3':
                        String scrollStr = "bdfhjlnprtvxz";
                        System.out
                            .println( "scroll(\"" + scrollStr + "\") --> "
                                + "\"" + exercise.scroll( scrollStr ) + "\"" );
                        break;
                    case '4':
                        String convStr = "von Neumann, John";
                        System.out.println(
                            "convertName(\"" + convStr + "\") --> " + "\""
                                + exercise.convertName( convStr ) + "\"" );
                        break;
                    case '5':
                        String negStr = "1001110001010101110";
                        System.out.println( "negate(\"" + negStr + "\") --> "
                            + "\"" + exercise.negate( negStr ) + "\"" );
                        break;
                    case '6':
                        String constStr1 = "0000000000000000000";
                        String constStr2 = "1001110001010101110";
                        System.out.println( "isConstant(\"" + constStr1
                            + "\") = " + exercise.isConstant( constStr1 ) );
                        System.out.println( "isConstant(\"" + constStr2
                            + "\") = " + exercise.isConstant( constStr2 ) );
                        break;
                    case '7':
                        String comment = "/* this should be gone */ int a = 0;";
                        String notComment = "/* this should stay /* int a = 0;";
                        System.out.println(
                            "removeComment(\"" + comment + "\") --> " + "\""
                                + exercise.removeComment( comment ) + "\"" );
                        System.out.println( "removeComment(\"" + notComment
                            + "\") --> " + "\""
                            + exercise.removeComment( notComment ) + "\"" );
                        break;
                    case '8':
                        String cutstr = "Hi-ho, hi-ho";
                        String cutOutstr = "-ho";
                        System.out.println( "cutOut(\"" + cutstr + "\", \""
                            + cutOutstr + "\") --> " + "\""
                            + exercise.cutOut( cutstr, cutOutstr ) + "\"" );
                        break;
                    case '9':
                        String htmlStr = "Strings are <b>immutable</b>";
                        System.out.println(
                            "removeHtmlTags(\"" + htmlStr + "\") --> " + "\""
                                + exercise.removeHtmlTags( htmlStr ) + "\"" );
                        break;
                    case 'A':
                    case 'a':
                        String digitStr = "123456789";
                        String dStr = "1234V5678";
                        System.out.println( "onlyDigits(\"" + digitStr
                            + "\") = " + exercise.onlyDigits( digitStr ) );
                        System.out.println( "onlyDigits(\"" + dStr + "\") = "
                            + exercise.onlyDigits( dStr ) );
                        break;
                    case 'B':
                    case 'b':
                        String validISBN = "096548534X";
                        String invalidISBN = "1234567890";
                        System.out.println( "isValidISBN(\"" + validISBN
                            + "\") = " + exercise.isValidISBN( validISBN ) );
                        System.out.println( "isValidISBN(\"" + invalidISBN
                            + "\") = " + exercise.isValidISBN( invalidISBN ) );
                        break;
                    case 'C':
                    case 'c':
                        String str = "The quick brown fox";
                        System.out.println( "shuffle(\"" + str + "\") --> "
                            + "\"" + exercise.shuffle( str ) + "\"" );
                        System.out.println( "shuffle(\"" + str + "\") --> "
                            + "\"" + exercise.shuffle( str ) + "\"" );
                        break;
                    default:
                        if ( response.toLowerCase().charAt( 0 ) == 'q' )
                        {
                            done = true;
                        }
                        else
                        {
                            System.out.print( "Invalid Choice" );
                        }
                        break;
                }
            }
        } while ( !done );
        System.out.println( "Goodbye!" );
    }
}
