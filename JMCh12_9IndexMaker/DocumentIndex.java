import java.util.ArrayList;


/**
 * 
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author neilchow
 * @version Nov 8, 2019
 * @author Period: TODO
 * @author Assignment: JMCh12_9IndexMaker
 *
 * @author Sources: TODO
 */
public class DocumentIndex extends ArrayList<IndexEntry>
{
    // private ArrayList<IndexEntry> this;

    // Creates an empty DocumentIndex with the default
    // initial capacity.
    /**
     * construct
     */
    public DocumentIndex()
    {
        // TODO complete constructor
        // this = new ArrayList<IndexEntry>();
    }


    // Creates an empty DocumentIndex with a given
    // initial capacity.
    /**
     * construct
     * 
     * @param initialCapacity
     *            init capacity
     */
    public DocumentIndex( int initialCapacity )
    {
        // TODO complete constructor
        this.ensureCapacity( initialCapacity );
    }


    // If word is not yet in this DocumentIndex,
    // creates a new IndexEntry for word, and inserts
    // it into this list in alphabetical order;
    // adds num to this word's IndexEntry by calling
    // its add(num) method.
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param word
     *            word
     * @param num
     *            index
     */
    public void addWord( String word, int num )
    {
        // TODO complete method
        boolean exist = false;
        for ( int i = 0; i < this.size(); i++ )
        {
            if ( this.get( i ).getWord().equals( word ) )
            {
                System.out.println( word );
                exist = true;
                this.get( i ).add( num );
            }
        }
        if ( !exist )
        {
            IndexEntry temp = new IndexEntry( word );
            temp.add( num );
            // System.out.println(temp);
            if ( this.size() == 0 )
            {
                this.add( temp );
            }
            else
            {
                int size = this.size();
                for ( int j = 0; j < size; j++ )
                {
                    if ( temp.getWord()
                        .compareTo( this.get( j ).getWord() ) < 0 )
                    {
                        this.add( j, temp );
                        System.out.println( 1 );
                        break;
                    }
                    if ( j == this.size() - 1 )
                    {
                        this.add( j, temp );
                        // System.out.println(j < this.size());
                    }
                }
            }

            // System.out.println(this.size());
        }
    }


    // For each word in str, calls addWord(word, num).
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param str
     *            str
     * @param num
     *            line num
     */
    public void addAllWords( String str, int num )
    {
        // TODO complete method
        String word = "";
        for ( int i = 0; i < str.length(); i++ )
        {
            if ( !Character.isLetter( str.charAt( i ) ) )
            {
                if ( !word.contentEquals( "" ) )
                {
                    // System.out.println( word );
                    addWord( word.toUpperCase(), num );
                }

                word = "";
                // translation += phraseToTranslate.charAt( i );
            }
            else
            {
                word += str.charAt( i );
                if ( i == str.length() - 1 )
                {
                    // System.out.println( word );
                    addWord( word.toUpperCase(), num );
                }
            }
        }
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return ilist
     */
    public ArrayList<IndexEntry> getIndexList()
    {
        foundOrInserted( null );
        return this;
    }


    // Tries to find an EndexEntry with a given word in this
    // DocumentIndex. If not found, inserts a new EndexEntry for
    // word at the appropriate place (in lexicographical order).
    // Returns the index of the found or inserted IndexEntry
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param word
     * @return a
     */
    private int foundOrInserted( String word )
    { // TODO complete method
        return 0; // TODO Fix this!!
    }

}
