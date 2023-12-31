public class Quicksort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using the Quicksort algorithm.
    public void sort( double[] a )
    {
        recursiveSort( a, 0, a.length - 1 );
    }


    // Recursive helper method: sorts a[from], ..., a[to]
    private void recursiveSort( double[] a, int from, int to )
    {
        addSteps( 1 );
        if ( from >= to )
            return;

        // Choose pivot a[p]:
        addSteps( 1 );
        int p = ( from + to ) / 2;
        // The choice of the pivot location may vary:
        // you can also use p = from or p = to or use
        // a fancier method, say, the median of the above three.

        // Partition:

        addSteps( 2 );
        int i = from;
        int j = to;
        while ( i <= j )
        {
            addSteps( 1 );
            addSteps( 1 );
            if ( a[i] <= a[p] )
            {
                addSteps( 1 );
                i++;
            }
            else if ( a[j] >= a[p] )
            {
                addSteps( 1 );
                addSteps( 1 );
                j--;
            }
            else
            {
                addSteps( 1 );
                addSteps( 3 );
                addSteps( 1 );
                addSteps( 1 );
                swap( a, i, j );
                i++;
                j--;
            }
        }

        // Finish partitioning:
        addSteps( 1 );
        if ( p < j ) // place the pivot in its correct position
        {
            addSteps( 3 );
            addSteps( 1 );
            swap( a, j, p );
            p = j;
        }
        else if ( p > i )
        {
            addSteps( 1 );
            addSteps( 3 );
            addSteps( 1 );
            swap( a, i, p );
            p = i;
        }

        // Sort recursively:
        addSteps( 1 );
        recursiveSort( a, from, p - 1 );
        addSteps( 1 );
        recursiveSort( a, p + 1, to );
    }
}
