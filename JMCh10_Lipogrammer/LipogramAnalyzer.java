/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - JMCh10 Lipogrammer
 * 
 * @author Sources - TODO list collaborators
 */
public class LipogramAnalyzer
{
    private String text;


    /**
     * Constructor: Saves the text string
     * 
     * @param text
     *            String to analyze
     */
    public LipogramAnalyzer( String text )
    {
        // TODO your constructor code here
        this.text = text.trim();

    }


    /**
     * Returns the text string with all characters equal to letter replaced with
     * '#'.
     * 
     * @param letter
     *            character to replace
     * @return text string with all characters equal to letter replaced with '#'
     */
    public String mark( char letter )
    {
        String output = text;
        while ( output.indexOf( letter ) != -1 )
        {
            output = output.substring( 0, output.indexOf( letter ) ) + "#"
                + output.substring( output.indexOf( letter ) + 1 );

        }
        return output; // !!!Fix this
    }


    /**
     * Returns a String that concatenates all "offending" words from text that
     * contain letter; the words are separated by '\n' characters; the returned
     * string does not contain duplicate words: each word occurs only once;
     * there are no punctuation or whitespace characters in the returned string.
     * 
     * @param letter
     *            character to find in text
     * @return String containing all words with letter
     */
    public String allWordsWith( char letter )
    {
        String result = "";
        // TODO your code here
        int start = 0;

        String word = "";
        while ( text.indexOf( " ", start ) != -1 )
        {
            if ( text.indexOf( " ", start ) < text.indexOf( ",", start )
                || text.indexOf( ",", start ) == -1 )
            {
                word = text.substring( start, text.indexOf( " ", start ) + 1 )
                    .trim();
                // System.out.println( word );
                for ( int i = 0; i < word.length(); i++ )
                {
                    if ( !Character.isLetter( word.charAt( i ) ) )
                    {
                        word = word.substring( 0, i )
                            + word.substring( i + 1 );
                        // System.out.println(word.substring( 0, i ));
                        i--;
                    }
                }
                start = text.indexOf( " ", start ) + 1;
                if ( word.length() == 1
                    && ( letter + "" ).equals( word.trim() )
                    && result.indexOf( "\n" + word.trim() ) == -1 )
                {
                    // System.out.println( word );
                    result += word.trim() + "\n";
                }
                if ( result.indexOf( word ) == -1
                    && word.indexOf( letter ) != -1 )
                {
                    // System.out.println( word );
                    result += word.trim() + "\n";
                }
            }
            else if ( text.indexOf( ",", start ) != -1 )
            {
                word = text.substring( start, text.indexOf( ",", start ) + 1 )
                    .trim();
                // System.out.println( word );
                for ( int i = 0; i < word.length(); i++ )
                {
                    if ( !Character.isLetter( word.charAt( i ) ) )
                    {
                        word = word.substring( 0, i )
                            + word.substring( i + 1 );
                        // System.out.println(word.substring( 0, i ));
                        i--;
                    }
                }
                start = text.indexOf( ",", start ) + 1;

                if ( result.indexOf( word ) == -1
                    && word.indexOf( letter ) != -1 )
                {
                    // System.out.println( word );
                    result += word.trim() + "\n";
                }
            }
        }
        word = text.substring( start ).trim();
        // System.out.println( word );
        if ( word.length() == 1 && ( letter + "" ).equals( word.trim() )
            && result.indexOf( "\n" + word.trim() ) == -1 )
        {
            // System.out.println( word );
            result += word.trim() + "\n";
        }
        for ( int i = 0; i < word.length(); i++ )
        {
            if ( !Character.isLetter( word.charAt( i ) ) )
            {
                word = word.substring( 0, i ) + word.substring( i + 1 );
                System.out.println( word );
                i--;
            }
        }

        if ( result.indexOf( word ) == -1 && word.indexOf( letter ) != -1 )
        {
            result += word.trim() + "\n";
        }
        return result;
    }


    // made public for test purposes
    /**
     * Returns the word that contains character at pos excluding any punctuation
     * or whitespace.
     * 
     * @param pos
     *            location of character
     * 
     * @return word that contains character at pos
     */
    public String extractWord( int pos )
    {
        // TODO your code here
        int i = pos;
        int j = pos;

        while ( Character.isLetter( text.charAt( i ) )
            && i < text.length() - 1 )
        {
            i++;
            // System.out.println(i);
        }

        while ( Character.isLetter( text.charAt( j ) ) && j > 0 )
        {
            j--;
            // System.out.println(j);
        }
        return text.substring( j, i ).trim(); // !!!Fix this
    }
}
