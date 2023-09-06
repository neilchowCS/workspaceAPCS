import org.junit.*;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;


/**
 * Test for the complex number class.
 * 
 * testConstructor1Param - test the 1 parameter constructor
 * testConstructor2Param - test the 2 parameter constructor
 * testAddRealAndComplexNum - addition of a complex number with a real number
 * testAdd2ComplexNums - addition of two complex numbers
 * testMultiply2ComplexNums - multiplication of two complex numbers
 * testMultiplyRealAndComplexNum - multiplication of a complex number with a
 * real number testAbsoluteValue - absolute value of a complex number
 *
 * @author TODO Your Name
 * @version TODO Date
 * @author Period: TODO Your Period
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: TODO List collaborators
 */
public class ComplexJUTest extends junit.framework.TestCase
{
    private static final double TEST1_A = 1;

    private static final double TEST1_B = 2;

    private static final double TEST2_A = 3;

    private static final double TEST2_B = 4;

    private Complex x;

    private Complex y;


    @Test
    public void setUp()
    {
        x = new Complex( TEST1_A, TEST1_B );
        y = new Complex( TEST2_A, TEST2_B );
        // System.out.println("setUp - " + machine1);
    }


    public void testConstructor1Param()
    {
        // TODO complete test

        assertEquals( TEST1_A, x.getA() );
        assertEquals( TEST1_B, x.getB() );

    }


    @Test
    public void testConstructor2Param()
    {
        // TODO complete test
        Complex bob = new Complex(TEST1_A);
        assertEquals( TEST1_A, bob.getA() );
        assertEquals( 0.0, bob.getB() );

    }


    @Test
    public void testAddRealAndComplexNum()
    {
        // TODO complete test
        assertEquals( x.add( 1 ).toString(), "2.0 + 2.0i" );
    }


    @Test
    public void testAdd2ComplexNums()
    {
        // TODO complete test
        assertEquals( x.add( y ).toString(), "4.0 + 6.0i" );
    }


    @Test
    public void testMultiply2ComplexNums()
    {
        // TODO complete test
        assertEquals( x.multiply( y ).toString(), "-5.0 + 10.0i" );
    }


    @Test
    public void testMultiplyRealAndComplexNum()
    {
        // TODO complete test
        assertEquals( x.multiply( 10 ).toString(), "10.0 + 20.0i" );
    }


    @Test
    public void testAbsoluteValue()
    {
        // TODO complete test
        assertEquals( y.abs(), 5.0 );
    }


    public static junit.framework.Test suite()
    {
        return new JUnit4TestAdapter( ComplexJUTest.class );
    }


    public static void main( String args[] )
    {
        org.junit.runner.JUnitCore.main( "ComplexJUTest" );
    }
}
