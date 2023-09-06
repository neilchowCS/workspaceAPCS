import java.util.*;


/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - JM24.6 - Search Engine
 * 
 * @author Sources - TODO list collaborators
 */
public class SearchEngine
{
    // Instance variable(s)
    private String myURL; // holds the name for the "url" (file name)

    private Map<String, List<String>> myIndex; // holds the word index


    // Constructor(s)
    /**
     * construct
     * 
     * @param s
     *            s
     */
    public SearchEngine( String s )
    {
        myURL = s;
        myIndex = new HashMap( 20000 );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return url
     */
    public String getURL()
    {
        return ( myURL );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param s
     *            s
     * @return s
     */
    public List<String> getHits( String s )
    {
        return myIndex.get( s );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param s
     *            s
     * @return s
     */
    private Set<String> parseWords( String s )
    {
        String[] temp = s.split( "\\W+" );
        TreeSet<String> tree = new TreeSet<String>();

        for ( String string : temp )
        {

            string = string.toLowerCase();
            tree.add( string );

        }
        return tree;
    }

    /**
     * 
     * TODO Write your method description here.
     * @param s s
     */
    public void add( String s )
    {
        Set<String> set = parseWords( s );

        for ( String string : set )
        {
            LinkedList<String> list = new LinkedList<String>();

            if ( !myIndex.containsKey( string ) )
            {
                myIndex.put( string, list );
            }

            myIndex.get( string ).add( s );
        }
    }

    // Methods


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * 
     * TODO Write your method description here.
     * @return r
     */
    public Map<String, List<String>> getIndex()
    {
        return myIndex;
    }
}
