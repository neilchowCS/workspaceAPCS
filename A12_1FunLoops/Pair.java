
/**
 * A class to solve various loop problems
 * 
 * @author TODO Your Name
 * @version TODO Date
 * 
 *          Period - TODO Your Period Assignment - A12.1 - FunLoops
 * 
 *          Sources - TODO list collaborators
 */
public class Pair{
    
    private double first, second;
    
    public Pair(double a, double b) {
        first = a;
        second = b;
        
    }
    public void swap() {
        double temp = first;first = second; second = temp;
    }
    
    public Pair swap1() {
        return new Pair(second, first);
    }
    
}

