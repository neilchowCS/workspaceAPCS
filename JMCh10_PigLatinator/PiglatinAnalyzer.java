import java.util.Scanner;


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
public class PiglatinAnalyzer
{
    private String text;


    // Constructor: saves the text string
    public PiglatinAnalyzer( String text )
    {
        // TODO add constructor code
        this.text = text;
    }


    /**
     * Converts a string to it piglatin form according to the following rules:
     * a. If there are no vowels in englishWord, then pigLatinWord is just
     * englishWord + "ay". (There are ten vowels: 'a', 'e', 'i', 'o', and 'u',
     * and their uppercase counterparts.) b. Else, if englishWord begins with a
     * vowel, then pigLatinWord is just englishWord + "yay". c. Otherwise (if
     * englishWord has a vowel in it and yet doesn't start with a vowel), then
     * pigLatinWord is end + start + "ay", where end and start are defined as
     * follows: 1. Let start be all of englishWord up to (but not including) its
     * first vowel. 2. Let end be all of englishWord from its first vowel on. 3.
     * But, if englishWord is capitalized, then capitalize end and
     * "uncapitalize" start.
     *
     * @return piglatin version of text as a String
     */

    public String phraseToPigLatin()
    {
        String phraseToTranslate = text;
        System.out.println( phraseToTranslate );
        String translation = "";
        // TODO add your code
        String word = "";
        for ( int i = 0; i < phraseToTranslate.length(); i++ )
        {
            if ( !Character.isLetter( phraseToTranslate.charAt( i ) ) )
            {
                if ( word != "" )
                {
                    translation += wordToPigLatin( word );
                }

                word = "";
                translation += phraseToTranslate.charAt( i );
            }
            else
            {
                word += phraseToTranslate.charAt( i );
                if (i == phraseToTranslate.length()-1) {
                    translation += wordToPigLatin( word );
                }
            }
        }

        return translation;
    }


    /**
     * Converts an "english" word to its piglatin form
     *
     * @param englishWord
     *            a string representing an english word
     * @return piglatin form of the english word
     */
    public String wordToPigLatin( String englishWord )
    {
        boolean capital = Character.isUpperCase( englishWord.charAt( 0 ) );
        int type = 0;
        int split = 0;
        englishWord = englishWord.toLowerCase();
        String pigLatinWord = "";
        // TODO add your code
        for ( int i = 0; i < englishWord.length(); i++ )
        {
            if ( englishWord.charAt( i ) == 'a'
                || englishWord.charAt( i ) == 'e'
                || englishWord.charAt( i ) == 'i'
                || englishWord.charAt( i ) == 'o'
                || englishWord.charAt( i ) == 'u' )
            {
                if ( i == 0 )
                {
                    type = 1;
                    break;
                }
                else
                {
                    type = 2;
                    split = i;
                    break;
                }
            }
        }

        switch ( type )
        {
            case 0:
                pigLatinWord = englishWord + "ay";
                if ( capital )
                {
                    pigLatinWord = pigLatinWord.substring( 0, 1 ).toUpperCase()
                        + pigLatinWord.substring( 1 );
                }
                break;
            case 1:
                pigLatinWord = englishWord + "yay";
                if ( capital )
                {
                    pigLatinWord = pigLatinWord.substring( 0, 1 ).toUpperCase()
                        + pigLatinWord.substring( 1 );
                }
                break;
            case 2:
                // pigLatinWord = end + start + ay;
                pigLatinWord = englishWord.substring( split )
                    + englishWord.substring( 0, split ) + "ay";
                if ( capital )
                {
                    pigLatinWord = pigLatinWord.substring( 0, 1 ).toUpperCase()
                        + pigLatinWord.substring( 1 );
                }
                break;
        }
        // System.out.println( pigLatinWord );
        return pigLatinWord;
    }

    // TODO add additional helper methods

}
