/**
 * This is a class that tests the Book class.
 *
 * @author TODO your name
 * @version TODO date
 * @author Period: TODO your period
 * @author Assignment: JMCh03Ex11_Book
 *
 * @author Sources: TODO list collaborators
 */

public class BookTest
{
    /**
     * The main method in this class checks the Book operations for consistency.
     * 
     * @param args
     *            is not used.
     */
    public static void main( String[] args )
    {
        /* TODO *** TO BE IMPLEMENTED *** */
        int i = 0;
        Book book = new Book( 3 );
        System.out.println( book.getNumPages() );
        System.out.println( book.getCurrentPage() );
        while ( i < 3 )
        {
            book.nextPage();
            System.out.println( book.getCurrentPage() );
            i++;
        }
    }
}
