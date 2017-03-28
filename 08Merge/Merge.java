public class Merge {
    // pseudocode form site! 
    /** def mergesort(int[]ary)
	if ...base case...
	--> i think base case if if ary = 1
	stop!
	else
	int[]left = copy of the left side;
	int[]right = copy of the right side;
	mergesort(left)
	mergesort(right)
	mergeTheTwoHalvesIntoTheOriginalArray **/

    public static void mergesort (int[] ary) {
	if (ary.length == 0 || ary.length == 1) {
	    return;
	}
	int[] left = new int[ary.length / 2];
	System.out.println("Left ary length: " + left.length);
	int[] right = new int[ary.length - left.length];
	for (int i = 0; i < ary.length / 2; i++) {
	    left[i] = ary[i];
	}
	System.out.println("Left array: " + printAry(left));
	for (int j = ary.length / 2; j < ary.length; j++) {
	    right[j - left.length] = ary[j];
	}
	System.out.println("Right array: " + printAry(right));
	System.out.println("Whole array: " + printAry(ary));
	mergesort(left);
        mergesort(right);
	// merge(left, right, ary);
	
    }

    /** public static void merge(int[]a,int[]b,int[]destination) {
	} **/

    public static String printAry(int[] ary) {
	String printedAry = "";
	for (int i = 0; i < ary.length - 1; i++) {
	    printedAry += ary[i] + ", ";
	}
	printedAry += ary[ary.length - 1];
	return printedAry;
    }

    public static void main (String[] args) {
	int[] test = {38, 27, 43, 3, 9, 82, 10};
	int[] test1 = {-11, -29383};
        mergesort(test);
    }
}
