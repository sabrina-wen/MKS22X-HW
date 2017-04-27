import java.util.*;

public class StackCalc {
    
    public static boolean isOp(String s) {
	return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static double doubleApply(String op, double a, double b) {
	if (op.equals("+")) {
	    return a + b;
	}
	else if (op.equals("-")) {
	    return b - a;
	}
	else if (op.equals("/")) {
	    return b / a;
	}
	else {
	    return a * b;
	}
    }

    public static double eval (String s) {
	String[] tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>();
	for (int i = 0; i < tokens.length; i++) {
	    if (isOp(tokens[i])) {
		values.push(doubleApply(tokens[i], values.pop(), values.pop()));
	    }
	    else {
		values.push(Double.parseDouble(tokens[i]));
	    }
	}
	return values.pop();
    }
}
