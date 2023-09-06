/**
 * Implements the minimum requirements specified by the Animal interface
 * 
 * @author George Peck
 * @version June 22, 2003
 * 
 *          Period - 1-7 Assignment - A29.1 - Old MacDonald
 * 
 *          Sources - Roger Frank
 */
class Chick implements Animal
{
    private String myType;

    private String mySound;

    private String mySound2;


    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     */
    public Chick( String type, String sound )
    {
        myType = type;
        mySound = sound;
    }


    /**
     * chick
     * 
     * @param type
     *            c
     * @param sound
     *            c
     * @param sound2
     *            c
     */
    public Chick( String type, String sound, String sound2 )
    {
        myType = type;
        mySound = sound;
        mySound2 = sound2;
    }


    /**
     * s
     * 
     * @return s, or 50% s1 50% s2
     */
    public String getSound()
    {
        int random = (int)( Math.random() * 2 );
        if ( mySound2 != null && random == 1 )
        {
            return mySound2;
        }
        return mySound;
    }


    /**
     * get
     * 
     * @return type
     */
    public String getType()
    {
        return myType;
    }
}