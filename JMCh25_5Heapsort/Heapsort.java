
import java.util.PriorityQueue;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class Heapsort
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Mergesort algorithm
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param a
     *            a
     */
    public static void sort( double[] a )
    {
        int n = a.length;
        for ( int i = n / 2; i >= 1; i-- )
            reheapDown( a, i, n );
        // TODO complete method
        while ( n > 1 )
        {

            double temp = a[0];
            a[0] = a[n - 1];
            a[n - 1] = temp;
            n--;
            reheapDown( a, 1, n );
        }
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param a
     *            A
     * @param i
     *            I
     * @param n
     *            N
     */
    // Should be private - made public for testing
    public static void reheapDown( double[] a, int i, int n )
    {

        int root = i - 1;
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        while ( l < n && a[l] > a[i] || r < n && a[r] > a[i] )
        {
            if ( r < n) {
                if ( a[r] > a[i] && a[r] > a[l] )
                {
                    double temp = a[i];
                    a[i] = a[r];
                    a[r] = temp;
                    i = r;
                    l = i * 2 + 1;
                    r = i * 2 + 2;
                }
                else
                {
                    double temp = a[i];
                    a[i] = a[l];
                    a[l] = temp;
                    i = l;
                    l = i * 2 + 1;
                    r = i * 2 + 2;
                }
            }else if (a[l] > a[i]) {
                double temp = a[i];
                a[i] = a[l];
                a[l] = temp;
                i = l;
                l = i * 2 + 1;
                r = i * 2 + 2;
            }
            

        }
    }
}
