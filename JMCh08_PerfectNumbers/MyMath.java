import java.util.Arrays;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author TODO your name
 * @version TODO the date
 * @author Period: TODO
 * @author Assignment: JMCh08_PerfectNumbers
 *
 * @author Sources: TODO list collaborators
 */
public class MyMath
{
    /**
     * Returns true if n is a prime; otherwise returns false.
     * 
     * @param n
     *            number to check if prime
     * @return true if n is a prime; otherwise returns false
     */
    public static boolean isPrime( int n )
    {
        if ( n <= 1 )
            return false;

        int m = 2;

        while ( m * m <= n )
        {
            if ( n % m == 0 )
                return false;
            m++;
        }

        return true;
    }


    /**
     * Question 8-15 Returns the n-th Fibonacci number
     * 
     * Find and read a few informative websites dedicated to Fibonacci numbers.
     * The following recursive method returns the n-th Fibonacci number:
     * 
     * // Returns the n-th Fibonacci number. // Precondition: n >= 1 public
     * static long fibonacci(int n) { if (n == 1 || n == 2) return 1; else
     * return fibonacci(n - 1) + fibonacci(n - 2); } Rewrite it without
     * recursion, using one loop.
     *
     * @param n
     *            Fibonacci number to find
     * @return n-th Fibonacci number
     */
    public static long fibonacci( int n )
    {
        int count = 1;
        int i = 0;
        int j = 1;
        int k = 0;
        while ( count < n )
        {
            k = i + j;
            i = j;
            j = k;

            count++;
        }

        return k;
    }


    /**
     * Returns true if n is a perfect number, false otherwise.
     * 
     * @param n
     *            number to test
     * @return true if n is a perfect number, false otherwise.
     */
    public static boolean isPerfect( int n )
    {

        // TODO your code here
        int sum = 0;
        for ( int i = 1; i < n - 1; i++ )
        {
            if ( n % i == 0 )
            {
                sum += i;
            }
        }

        if ( sum == n )
        {
            return true;
        }

        return false; // ** FIX THIS
    }


    /**
     * Prints the first n perfect numbers
     * 
     * @param n
     *            number of perfect numbers to print
     */
    public static void printPerfectNums( int n )
    {
        System.out.println( "Perfect numbers: " );
        int count = 0;
        for ( int k = 1; count < n; k++ )
        {
            if ( isPerfect( k ) )
            {
                System.out.print( k + " " );
                count++;
            }
        }
        System.out.println();
    }


    /**
     * Prints the first n Mersenne primes
     * 
     * @param n
     *            number of Mersenne primes to print
     */
    public static void printMersennePrimes( int n )
    {
        System.out.println( "Mersenne primes: " );

        // TODO your code here
        int check = 0;
        int formula;
        int primes[] = { 2 };
        int formulalist[] = {};

        while ( formulalist.length < n )
        {
            check++;
            formula = (int)( Math.pow( 2, check ) - 1 );
            // System.out.println( formula );

            while ( (int)formula > (int)primes[primes.length - 1] )
            {
                // star primes
                boolean done = false;
                int starting = primes[primes.length - 1];
                while ( !done )
                {
                    starting++;
                    // System.out.println(starting);
                    for ( int j = 0; j <= primes.length - 1; j++ )
                    {
                        if ( starting % primes[j] == 0 )
                        {
                            // System.out.println( starting );
                            break;
                        }
                        else if ( j == primes.length - 1 )
                        {
                            done = true;
                            primes = Arrays.copyOf( primes,
                                primes.length + 1 );
                            primes[primes.length - 1] = starting;
                            // System.out.println( primes[primes.length - 1] );
                        }
                    }
                } // end primes
            }
            boolean a = false;
            for ( int i = 0; i < primes.length; i++ )
            {
                if ( formula == primes[i] )
                {
                    a = true;
                    break;
                }
            }
            if ( a )
            {
                formulalist = Arrays.copyOf( formulalist,
                    formulalist.length + 1 );
                formulalist[formulalist.length - 1] = formula;
                System.out.println( formulalist[formulalist.length - 1] );
            }
        }
    }


    /**
     * Prints the first n even perfect numbers
     */
    public static void printEvenPerfectNums( int n )
    {
        System.out.println( "Even perfect numbers: " );

        // TODO your code here
        int check = 0;
        int formula;
        int primes[] = { 2 };
        int formulalist[] = {};

        while ( formulalist.length < n )
        {
            check++;
            formula = (int)( Math.pow( 2, check ) - 1 );
            // System.out.println( formula );

            while ( (int)formula > (int)primes[primes.length - 1] )
            {
                // star primes
                boolean done = false;
                int starting = primes[primes.length - 1];
                while ( !done )
                {
                    starting++;
                    // System.out.println(starting);
                    for ( int j = 0; j <= primes.length - 1; j++ )
                    {
                        if ( starting % primes[j] == 0 )
                        {
                            // System.out.println( starting );
                            break;
                        }
                        else if ( j == primes.length - 1 )
                        {
                            done = true;
                            primes = Arrays.copyOf( primes,
                                primes.length + 1 );
                            primes[primes.length - 1] = starting;
                            // System.out.println( primes[primes.length - 1] );
                        }
                    }
                } // end primes
            }
            boolean a = false;
            for ( int i = 0; i < primes.length; i++ )
            {
                if ( formula == primes[i] )
                {
                    a = true;
                    break;
                }
            }
            if ( a )
            {
                formulalist = Arrays.copyOf( formulalist,
                    formulalist.length + 1 );
                formulalist[formulalist.length - 1] = formula;
            }
        }
        for ( int i = 0; i < n; i++ )
        {
            int findn = (int)( Math.log( formulalist[i] ) / Math.log( 2 ) )
                + 1;
            System.out.println( (long)( Math.pow( 2, findn - 1 )
                * ( Math.pow( 2, findn ) - 1 ) ) );
            // System.out.println(Math.pow( 2, findn ) - 1);

        }

    }


    /*********************************************************************/

    public static void main( String[] args )
    {
        int n = 19;
        System.out.println( n + "-th Fibonacci number = " + fibonacci( n ) );

        printPerfectNums( 4 );
        printMersennePrimes( 6 );
        printEvenPerfectNums( 6 );
    }
}
/*
 * 19-th Fibonacci number = 4181 Perfect numbers: 6 28 496 8128 Mersenne primes:
 * 3 7 31 127 8191 131071 524287 Even perfect numbers: 6 28 496 8128 33550336
 * 8589869056 137438691328
 */