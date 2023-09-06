/**
 * Implements a sorted list of words
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - Java Methods 13.4 Lab: Keeping Things in Order
 * 
 * @author Sources - TODO list collaborators
 */
public class SortedWordList extends java.util.ArrayList<String>
{
    // TODO complete methods
    /**
     * constructor
     */
    public SortedWordList()
    {
        // nothing
        System.out.println( "hi" );
    }


    /**
     * constructor
     * 
     * @param i
     *            capacity
     */
    public SortedWordList( int i )
    {
        this.ensureCapacity( i );
    }


    /**
     * set
     * 
     * @param i
     *            index
     * @param word
     *            to add
     * @return this.get( i )
     */
    public String set( int i, String word )
    {
        if ( this.get( i ).compareToIgnoreCase( word ) > 0
            || this.get( i - 1 ).compareToIgnoreCase( word ) < 0 )
        {
            throw new IllegalArgumentException( "word =" + word + " i =" + i );
        }
        return ( this.get( i ) );
    }


    /**
     * add 1
     * 
     * @param i
     *            index
     * @param word
     *            to add
     * 
     */
    public void add( int i, String word )
    {
        this.set( i, word );
    }


    /**
     * add #2
     * 
     * @param word
     *            word to add
     * @return a bool
     */
    public boolean add( String word )
    {
        if ( this.size() == 0 )
        {
            super.add( word );
        }
        else if ( this.size() == 1 )
        {
            if ( word.compareToIgnoreCase( this.get( 0 ) ) > 0 )
            {
                super.add( word );
            }
            else
            {
                super.add( 0, word );
            }

        }
        else
        {
            for ( int i = 1; i < this.size(); i++ )
            {
                boolean correct = true;
                try
                {
                    set( i, word );
                }
                catch ( Exception IllegalArgumentException )
                {
                    if ( i == this.size() - 1 )
                    {
                        return false;
                    }
                    correct = false;
                }
                if ( correct )
                {
                    super.add( i, word );
                    return true;
                }
            }
        }

        return true;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param additionalWords
     *            add
     */
    public void merge( SortedWordList additionalWords )
    {
        System.out.println( "merge" );
    }
}
