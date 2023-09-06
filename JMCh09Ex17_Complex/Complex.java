/**
 * Represents a complex number of the form a + bi. Provides methods for adding,
 * multiplying and calculating the absolute value.
 *
 * @author TODO Your Name
 * @version TODO Date
 * @author Period: TODO Your Period
 * @author Assignment: JMCh09Ex17_Complex
 *
 * @author Sources: TODO List collaborators
 */
public class Complex
{
    // TODO instance variables
    private double a;

    private double b;


    // TODO Constructors
    /**
     * 
     * @param x
     *            real
     * @param y
     *            imaginary
     */
    public Complex( double x, double y )
    {
        a = x;
        b = y;
    }


    /**
     * 
     * @param x
     *            real
     */
    public Complex( double x )
    {
        a = x;
        b = 0;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return a a
     */
    public double getA()
    {
        return a;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return b b
     */
    public double getB()
    {
        return b;
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param x
     *            double to multiply by
     * @return result
     */
    public Complex add( double x )
    {
        return ( new Complex( a + x, b ) );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param x
     *            complex to multiply by
     * @return result
     */
    public Complex add( Complex x )
    {
        return ( new Complex( a + x.getA(), b + x.getB() ) );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param x
     *            complex to multiply by
     * @return result
     */
    public Complex multiply( Complex x )
    {
        double squared = a * x.getA();
        double mid = a * x.getB() + x.getA() * b;
        double squared2 = b * x.getB();
        double output = squared - squared2;
        return ( new Complex( output, mid ) );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @param x
     *            double to multiply by
     * @return result
     */
    public Complex multiply( double x )
    {
        return ( new Complex( a * x, b * x ) );
    }


    /**
     * 
     * TODO Write your method description here.
     * 
     * @return abs
     */
    public double abs()
    {
        return ( Math.sqrt( a * a + b * b ) );
    }


    // TODO Methods

    /**
     * to string
     * @return string
     */
    public String toString()
    {
        return a + " + " + b + "i";
    }
}
