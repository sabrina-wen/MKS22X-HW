public class Recursion {
    
    public static String name() {
	return "Wen,Sabrina";
    }

    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}
	return helper();
    }
    
    public static double helper(double number, double guess) {
	// base case
	
    }

    public static void main (String[] args) {
	System.out.println(sqrt(25));f
    }
}
