/**
 * 
 * TODO Write a one-sentence summary of your class here. TODO Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 *
 * @author neilchow
 * @version Jan 24, 2020
 * @author Period: TODO
 * @author Assignment: JMCh21_6ActorsWorld
 *
 * @author Sources: TODO
 */
public class Message
{
    private Actor sender;

    private Actor recipient;

    private String text;


    /**
     * sad
     * 
     * @param a1
     *            a
     * @param a2
     *            a
     * @param str
     *            s
     */
    public Message( Actor a1, Actor a2, String str )
    {
        sender = a1;
        recipient = a2;
        text = str;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return g
     */
    public Actor getSender()
    {
        return sender;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return g
     */
    public Actor getRecipient()
    {
        return recipient;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return t
     */
    public String getText()
    {
        return text;
    }


    /**
     * a
     */
    public String toString()
    {
        String toName;

        if ( recipient != null )
            toName = recipient.getName();
        else
            toName = "all";

        return "From: " + sender.getName() + "\n" + "To: " + toName + "\n"
            + text + "\n";
    }
}
