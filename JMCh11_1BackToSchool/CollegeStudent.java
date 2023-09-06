// TODO add comments
/**
 * 
 *  TODO Write a one-sentence summary of your class here.
 *  TODO Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author  neilchow
 *  @version Oct 21, 2019
 *  @author  Period: TODO
 *  @author  Assignment: JMCh11_1BackToSchool
 *
 *  @author  Sources: TODO
 */
public class CollegeStudent extends Student
{
    // TODO instance variables
    private String myMajor;

    private int myYear;


    // TODO constructor
    /**
     * constructor
     * @param name n 
     * @param age a
     * @param gender g
     * @param idNum id
     * @param gpa g
     * @param year y
     * @param major m
     */
    public CollegeStudent(
        String name,
        int age,
        String gender,
        String idNum,
        double gpa,
        int year,
        String major )
    {
        // use the super class' constructor
        super( name, age, gender, idNum, gpa );

        // initialize what's new to Student
        myMajor = major;
        myYear = year;
    }


    /**
     * 
     * TODO Write your method description here.
     * @return major
     */
    public String getMajor()
    {
        return ( myMajor );
    }

/**
 * 
 * TODO Write your method description here.
 * @return year
 */
    public int getYear()
    {
        return ( myYear );
    }

/**
 * 
 * TODO Write your method description here.
 * @param major set
 */
    public void setMajor( String major )
    {
        myMajor = major;
    }

/**
 * 
 * TODO Write your method description here.
 * @param year set
 */
    public void setYear( int year )
    {
        myYear = year;
    }


    // TODO methods

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", year: " + myYear + ", major: " + myMajor;
    }
}
