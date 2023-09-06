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
class NamedCow extends Cow
{
    private String myName;


    /**
     * Initializes a newly created Cow object so that it represents an Animal of
     * the specified type that makes the specified sound.
     * 
     * @param type
     *            the type of Cow
     * @param sound
     *            the sound the Cow makes
     * @param name
     *            name
     */
    public NamedCow( String type, String name, String sound )
    {

        super( type, sound );
        myName = name;

    }


    /**
     * c2
     * 
     * @param name
     *            n
     * @param sound
     *            s
     */
    public NamedCow( String name, String sound )
    {

        super( "cow", sound );
        myName = name;

    }


    /**
     * get
     * 
     * @return s
     */
    public String getName()
    {
        return myName;
    }
}