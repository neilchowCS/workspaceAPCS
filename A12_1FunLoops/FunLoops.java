
/**
 * A class to solve various loop problems
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 *          Period - TODO Your Period Assignment - A12.1 - FunLoops
 * 
 *          Sources - TODO list collaborators
 */
public class FunLoops
{
    /**
     * 
     * finds first n magic squares
     * 
     * @param n
     *            numbers of squares
     */
    public void magicsquare( int n )
    {
        System.out.println( "Magic Squares" );
        // TODO Your Code Here
        // System.out.println(Math.sqrt( n ));

        int i = 0;
        long j = 2;
        while ( i < n )
        {

            if ( i == 0 )
            {
                System.out.println( "1: 1" );
                i++;
            }

            if ( Math
                .sqrt( (double)j ) == (double)(int)Math.sqrt( (double)j ) )
            {
                boolean sum = false;
                long increment = 0;

                for ( long count = 0; count < j; count++ )
                {
                    increment += count;
                    if ( increment == j )
                    {
                        sum = true;
                        break;
                    }
                }

                if ( sum )
                {
                    i++;
                    System.out.println( i + ": " + j );
                    j++;
                }
                else
                {
                    j++;
                }

            }
            else
            {
                j++;
            }
        }

    }


    /**
     * 
     * finds lcm of a and b
     * 
     * @param a
     *            first int
     * @param b
     *            second int
     * @return lcm
     */
    public int lcm( int a, int b )
    {
        // TODO Your Code Here
        int output = 1;
        while ( true )
        {
            if ( output % a == 0 && output % b == 0 )
            {
                return output;
            }
            else
            {
                output++;
            }
        }

    }


    /**
     * 
     * main
     * 
     * @param args
     *            args
     */
    public static void main( String[] args )
    {
        FunLoops fun = new FunLoops();

        fun.magicsquare( 4 );
        System.out.println();

        System.out.println( "LCM (15, 18) = " + fun.lcm( 15, 18 ) );
        System.out.println( "LCM (40, 12) = " + fun.lcm( 40, 12 ) );
        System.out.println( "LCM (2, 7) = " + fun.lcm( 2, 7 ) );
        System.out.println( "LCM (100, 5) = " + fun.lcm( 100, 5 ) );
        System.out.println();

        fun.magicsquare( 10 );
    }
}
