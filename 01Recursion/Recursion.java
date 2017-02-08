public class Recursion {
    public static double better_guess;
    
    public static String name() {
	return "Wen,Sabrina";
    }

    public static double sqrt(double n) {
	if (n < 0) {
	    throw new IllegalArgumentException();
	}

	return helper(n, 1.0);
    }
    
    public static double helper(double number, double guess) {
	/// base case since n >= 0.0
	if (number == 0.0) {
	    return 0;
	}

	// formula for better guess, return the sqrt
	better_guess = (number / guess + guess) / 2.0;

	//checking to see if better_guess and guess are close enough
	if ((Math.abs(number - better_guess * better_guess)) < 0.0000001) {
	    return better_guess;
	}

	// recursive part of the fn
	return helper(number, better_guess);
    }

    public static void main (String[] args) {
	System.out.println(sqrt(36.0));
       	System.out.println(sqrt(11.0));
   	System.out.println(sqrt(9.0));
    }
}
