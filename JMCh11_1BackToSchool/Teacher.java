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
public class Teacher extends Person
{
    // TODO instance variables
    private String mySubject;

    private double mySalary;


    // TODO constructor
    /**
     * constructor
     * @param name n
     * @param age a
     * @param gender g
     * @param subject s
     * @param salary s
     */
    public Teacher(
        String name,
        int age,
        String gender,
        String subject,
        double salary )
    {
        super( name, age, gender );
        mySubject = subject;
        mySalary = salary;
    }
    /**
     * 
     * TODO Write your method description here.
     * @return subject
     */
    public String getSubject() {
        return (mySubject);
    }
    /**
     * 
     * TODO Write your method description here.
     * @return salary
     */
    public double getSalary() {
        return (mySalary);
    }
    /**
     * 
     * TODO Write your method description here.
     * @param subject set
     */
    public void setSubject(String subject) {
        mySubject = subject;
    }
    /**
     * 
     * TODO Write your method description here.
     * @param salary set
     */
    public void setSalary(double salary) {
        mySalary = salary;
    }


    // TODO methods

    /**
     * Returns a String representation of this class.
     * 
     * @return private instance data as a String
     */
    public String toString()
    {
        return super.toString() + ", subject: " + mySubject + ", salary: "
            + mySalary;
    }
}
