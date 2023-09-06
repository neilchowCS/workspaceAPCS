// Implements a board for the Chomp program


public class test
{
    public static void main( String[] args )
    {
        CharMatrix x = new CharMatrix(10, 10);
        x.fillRect( 0, 0, 5, 5, '*' );
        System.out.println(x.countInRow( 0 ));
        System.out.println(x.charAt( 5, 5 ));
    }
}