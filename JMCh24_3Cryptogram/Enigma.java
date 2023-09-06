// import java.util.Arrays;

/**
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 * @author Period - TODO Your Period
 * @author Assignment - JM 24.3 Lab: Cryptogram Solver
 * 
 * @author Sources - TODO list collaborators
 */
public class Enigma
{
    private char[] lookupTable;


    /**
     * construct
     * 
     * @param numLetters
     *            n
     */
    public Enigma( int numLetters )
    {
        // TODO complete constructor
        lookupTable = new char[numLetters];
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param index
     *            i
     * @param ch
     *            c
     */
    public void setSubstitution( int index, char ch )
    {
        // TODO complete method
        lookupTable[index] = ch;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param text
     *            t
     * @return r
     */
    public String decode( String text )
    {
        StringBuffer buffer = new StringBuffer( text.length() );

        // TODO
        for ( int i = 0; i < text.length(); i++ )
        {
            char character = text.charAt( i );
            boolean upper = Character.isUpperCase( character );
            boolean lower = Character.isLowerCase( character );

            int number = Character
                .getNumericValue( Character.toLowerCase( character ) )
                - Character.getNumericValue( 'a' );

            if ( upper )
            {
                buffer.append( ( "" + lookupTable[number] ).toUpperCase() );
            }
            else if ( lower )
            {
                buffer.append( ( "" + lookupTable[number] ).toLowerCase() );
            }
            else
            {
                buffer.append( character );
            }

        }
        return buffer.toString();

    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param text
     *            t
     * @param lettersByFrequency
     *            l
     * @return r
     */
    public String getHints( String text, String lettersByFrequency )
    {
        String hints = "";

        int[] counts = countLetters( text );

        for ( int i = 0; i < counts.length; i++ )
        {
            int k = 0;

            for ( int j = 0; j < counts.length; j++ )
            {
                if ( counts[i] < counts[j] ||  counts[i] < counts[j] && i < j )
                {
                    k++;
                }
            }
            hints += lettersByFrequency.charAt( k );
        }

        return ( hints );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param text
     *            t
     * @return r
     */
    private int[] countLetters( String text )
    {
        int[] counts = new int[lookupTable.length];
        /*
         * for ( int i = 0; i < text.length(); i++ ) {
         * counts[Character.toLowerCase( text.charAt( i ) ) - 'a']++; }
         */
        for ( int i = 0; i < text.length(); i++ )
        {
            if ( text.charAt( i ) >= 'A' && text.charAt( i ) <= 'Z' )
            {
                counts[text.charAt( i ) - 'A']++;

            }
            else if ( text.charAt( i ) >= 'a' && text.charAt( i ) <= 'z' )
            {
                counts[text.charAt( i ) - 'a']++;
            }
        }

        return counts;
    }


    // *************************************************************
    // For test purposes only
    // not to be used in solution implementation
    /**
     * 
     * TODO Write your method description here.
     * 
     * @return r
     */
    public char[] getLookupTable()
    {
        return lookupTable;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param text
     *            t
     * @return r
     */
    public int[] getCountLetters( String text )
    {
        return countLetters( text );
    }

}