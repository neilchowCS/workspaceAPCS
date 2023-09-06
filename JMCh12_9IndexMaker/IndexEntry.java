import java.util.ArrayList;

/**
 * 
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  neilchow
 *  @version Nov 8, 2019
 *  @author  Period: TODO
 *  @author  Assignment: JMCh12_9IndexMaker
 *
 *  @author  Sources: TODO
 */
public class IndexEntry
{
    // TODO instance fields
    private String word;

    private ArrayList<Integer> numsList;


    // Constructs an IndexEntry for a given word
    // (converted to upper case); sets numsList
    // to an empty ArrayList.
    /**
     * constuct
     * 
     * @param word
     *            w
     */
    public IndexEntry( String word )
    {
        // TODO complete constructor
        this.word = word.toUpperCase();
        numsList = new ArrayList<Integer>();
    }


    // Returns the word of this IndexEntry object.
    /**
     * 
     * TODO Write your method description here.
     * 
     * @return w
     */
    public String getWord()
    {
        // TODO complete method
        return word; // Fix this!!
    }


    // If num is not already in the list, adds num
    // at the end of this IndexEntry's list
    // of numbers.
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param num
     *            n
     */
    public void add( int num )
    {
        // TODO complete method
        if ( !numsList.contains( num ) )
        {
            numsList.add( num );
        }
    }


    // Converts this IndexEntry into a string in the
    // following format: the word followed by a space, followed by
    // numbers separated by a comma and a space.
    /**
     * to string
     * @return string
     */
    public String toString()
    {
        // TODO complete method
        String output = "";
        output += word + " ";
        for ( int i = 0; i < numsList.size(); i++ )
        {

            if ( i == numsList.size() - 1 )
            {
                output += numsList.get( i );
            }
            else
            {
                output += numsList.get( i ) + ", ";
            }
        }

        return output; // TODO Fix this!!
    }
}
