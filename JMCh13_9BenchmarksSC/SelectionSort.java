public class SelectionSort extends StepCount
{
    // Sorts a[0], ..., a[size-1] in ascending order
    // using Selection Sort.
    public void sort( double[] a )
    {
        addSteps( 1 );
        for ( int n = a.length; n > 1; n-- )
        {
            addSteps( 7 );
            // Find the index iMax of the largest element
            // among a[0], ..., a[n-1]:
            //addSteps( 1 );
            int iMax = 0;
            //addSteps( 1 );
            for ( int i = 1; i < n; i++ )
            {
                addSteps( 3 );
                //addSteps( 1 );
                if ( a[i] > a[iMax] )
                {
                    addSteps( 1 );
                    iMax = i;
                }
            }

            // Swap a[iMax] with a[n-1]:
            //addSteps( 3 );
            swap( a, iMax, n - 1 );

            // Decrement n (accomplished by n-- in the for loop).
        }
    }
}
