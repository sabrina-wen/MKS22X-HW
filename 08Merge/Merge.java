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
	int[] left = new int[ary.length / 2];
	int[] right = new int[ary.length - left.length];
	if (ary.length == 0 || ary.length == 1) {
	    // System.out.println(printAry(ary));
	    return;
	}
	// int[] left = new int[ary.length / 2];
	// System.out.println("Left ary length: " + left.length);
	// int[] right = new int[ary.length - left.length];
	for (int i = 0; i < ary.length / 2; i++) {
	    left[i] = ary[i];
	}
	// System.out.println("Left array: " + printAry(left));
	for (int j = ary.length / 2; j < ary.length; j++) {
	    right[j - left.length] = ary[j];
	}
	// System.out.println("Right array: " + printAry(right));
	// System.out.println("Whole array: " + printAry(ary));
	mergesort(left);
        mergesort(right);
	merge(left, right, ary);
	// System.out.println(printAry(ary));
    }

    public static void merge(int[]a,int[]b,int[]destination) {
	int aCount = 0; // pos in left ary (a)
	int bCount = 0; // pos in right ary (b)
	int count = 0; // count = pos in ary

	// ordering elements in a pair
	while (aCount < a.length && bCount < b.length) {
	    if (a[aCount] < b[bCount]) {
		destination[count] = a[aCount];
		aCount++;
		count++;
		// System.out.println("Count val: " + count);
	    }
	    else {
		destination[count] = b[bCount];
		bCount++;
		count++;
	        // System.out.println("Count val: " + count);
	    }
	}

	// so as you go from a pair to a trio or more,
	// u basically incrememt to copy the remaining elements
	for (int i = aCount; i < a.length; i++) {
	    destination[count] = a[i];
	    count++;
	    //  System.out.println("Count val: " + count);
	}

	for (int i = bCount; i < b.length; i++) {
	    destination[count] = b[i];
	    count++;
	    //  System.out.println("Count val: " + count);
	}
    }
	   

    public static String printAry(int[] ary) {
	String printedAry = "";
	for (int i = 0; i < ary.length - 1; i++) {
	    printedAry += ary[i] + ", ";
	}
	printedAry += ary[ary.length - 1];
	return printedAry;
    }

    /** public static void main (String[] args) {
	int[] test = {38, 27, 43, 3, 9, 82, 10};
	int[] test1 = {-11, -29383};
        mergesort(test);
	System.out.println(printAry(test));
	} **/
}
