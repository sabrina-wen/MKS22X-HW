import java.util.*;

public class Quick {
	
    public static int partition(int[] data, int start, int end) {
	/** some pseudocode: 
	    choose a random element
	    switch random element with element at end, so that we don't move the random element accidentally
	    now we start a loop
	    have one indice check beginning element and another indice checking element that will iterate through the entire array (or part of it)
	    if first element val  < end value, switch the first element val and the bobbing vall.
	    - also move end indice 1 down 
	    else do nothing, move bobbing indice 1 up (but don't do anything to end indce)
	    if beginning indice (not its val) > end indce, you are done.
	    swap the end val that's been pushed back and the pivot val, which is now the bobbing val
	    returns index of final pos of pivot element **/
	
	Random randgen = new Random();
	int pivotIndex = start + randgen.nextInt(end - start + 1);
	int pivotVal = data[pivotIndex];
	int lastNumHolder = data[end];
	data[end] = pivotVal;
	data[pivotIndex] = lastNumHolder;
	int startIndex = start;
	
	for (int i = start; i < end; i++) {
	    if (data[start] < data[end]) {
		int holder = data[start];
		data[start] = data[startIndex];
		data[startIndex] = holder;
		startIndex++;
	    }
	    start++;
	}
	int newEndHolder = data[end];
	    data[end] = data[startIndex];
	    data[startIndex] = newEndHolder;
	
	    // System.out.println("Value: " + data[startIndex]);
	return startIndex;
    }

    public static String printArray(int[] numList) {
	String ary = "";
	for (int i = 0; i < numList.length - 1; i++) {
	    if (i < numList.length - 2) {
		ary += numList[i] + ", ";
	    }
	    else {
		ary += numList[i];
	    }
	}
	return ary;
    }

    /** public static void testPartition() {
	Random randAryElements = new Random();
	int[] randomAry = new int[-1000 + randAryElements.nextInt(end - start + 1);
	} **/

    // selecting kth element method, not working will return to this later
    public static int quickSelect(int[] data, int k) {
	/**  psuedocode idea:
	     run thru partition once so that u have one val in the right place
	     if k == index that's returned ur good
	     if k > index, partition all of index (not including index) to end (the bigger side)
	     if k < index, partition all of beginning of ary to index (not including index) (smaller side)
	     i think this would be a loop and the first if statement would be your base case...
	     returns val of kth smallest element **/
	return quickSelectH(data, 0, data.length - 1, k);
    }

    // selecting kth element helper method
    public static int quickSelectH(int[] data, int start, int end, int k) {
	int index = partition(data, start, end);
	System.out.println(printArray(data));
	System.out.println("index val: " + index);
        if (k == index) {
	    System.out.println(printArray(data));
	    return data[index - 1];
	}
	else if (index < k) {
	    System.out.println(printArray(data));
	    System.out.println("index val: " + index);
	    return quickSelectH(data, index + 1, end - 1, k);
	}
	System.out.println(printArray(data));
	System.out.println("index val: " + index);
	return quickSelectH(data, start, index - 1, k);
	// partition(data, index + 1, data.length - 1);
	
    }

    public static void swap(int[] ary, int numOne, int numTwo) {
	int holder = ary[numOne];
	data[numOne] = data[numTwo];
	data[numTwo] = holder;
    }
    
    public static void quickSort(int[] a) {
	return quickSortH(a, k);
    }

    public static int quickSelect(int[] data, int k) {
	int pivot = partition(data, 0, data.length - 1);
	int q1 = pivot - 1;
	int q3 = pivot + 1;
	while (pivot <= q3) {
	    if (data[pivot] == data[k]) {
		pivot++;
	    }
	    else if (data[pivot] > data[k]) {
		swap(a, pivot, q1);
	    }
	}
    }
		
	
    public static void main (String[] args) {
	int[] test = {999,999,999,4,1,0,3,2,999,999,999};
	int[] test1 = {8, 90, 45, -18, -3, 11, 3, 8};
	int[] test2 = {1, 12, 5, 26, 7, 14, 3, 7, 2};
	// System.out.println(partition(test1, 0, test1.length - 1));
	System.out.println(quickSelect(test1, 3));
    }
}
