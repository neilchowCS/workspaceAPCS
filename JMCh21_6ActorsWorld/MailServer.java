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
 * @author Assignment - TODO Assignment Name
 * 
 * @author Sources - TODO list collaborators
 */
public class MailServer extends LinkedList<Message>
{
    private Set<Actor> actors = new TreeSet<Actor>();


    // TODO complete class
    /**
     * 
     * TODO Write your method description here.
     * 
     * @param actor
     *            a
     */
    void signUp( Actor actor )
    {
        actors.add( actor );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param msg
     *            m
     */
    void dispatch( Message msg )
    {
        if ( msg.getRecipient() == null )
        {
            for ( Actor a : actors )
            {
                if ( a != msg.getSender() )
                {
                    a.receive( msg );
                }
            }
        }
        else
        {
            msg.getRecipient().receive( msg );
        }
    }


    // for testing purposes only
    /**
     * 
     * TODO Write your method description here.
     * 
     * @return a
     */
    protected Set<Actor> getActors()
    {
        return actors;
    }
}
