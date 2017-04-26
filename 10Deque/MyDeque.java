import java.util.*;

public class MyDeque {
    private String[] ary;
    private int size, front, back;

    public MyDeque() {
	ary = new String[2];
	size = 0;
	front = 0;
	back = 0;
    }

    public void addFirst(String s) {
	if (s == null) {
	    throw new NullPointerException();
	}
	if (size == ary.length) {
	    resize();
	    // System.out.println("lol");
	}
	if (size != 0) {
	    if (front == 0) {
		// ary[ary.length - 1] = s;
		front = ary.length - 1;
	    }
	    else {
		// ary[front - 1] = s;
		front = front - 1;
	    }
	}
	ary[front] = s;
	size++;
	// System.out.println("front: " + front + " back: " + back + ", size: " + size + " length of array: " + ary.length);
    }

    public void addLast(String s) {
	if (s == null) {
	    throw new NullPointerException();
	}
	if (size == ary.length) {
	    resize();
	}
	if (size != 0) {
	    back %=  ary.length;
	}
        ary[back] = s;
	size++;
	// System.out.println("front: " + front + " back: " + back + ", size: " + size + " length of array: " + ary.length);
    }

    public String removeFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	String firstVal = getFirst();
	ary[front] = null;
	front = (front + 1) % ary.length;
	size--;
	return firstVal;
    }

    public String removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	String lastVal = getLast();
	ary[back] = null;
	back = (back - 1) % ary.length;
	size--;
	return lastVal;
    }

    public String getFirst() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
        return "" + ary[front];
    }    

    public String getLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
        return "" + ary[back];
    } 

    public void resize() {
	String[] newAry = new String[ary.length * 2];
	for (int i = 0; i < size; i++) {
	    newAry[i] = ary[(front + i) % ary.length];
	}
        ary = newAry;
        front = 0;
	back = size;
    }
    
    public String toString() {
	String retVal = "";
	for (int i = 0; i < ary.length - 1; i++) {
	    retVal += ary[i] + ", ";
	}
	retVal += ary[ary.length - 1];
	// System.out.println("front: " + front + " back: " + back + ", size: " + size + " length of array: " + ary.length);
	return retVal;
    }

    /** public static void main(String[] args) {
	MyDeque one = new MyDeque();
	one.addFirst("hi");
	System.out.println(one);
	one.addFirst("hElLo");
	System.out.println(one);
	one.addFirst("HEY");
	System.out.println(one);
	one.addLast("last!");
	System.out.println(one);
	one.addLast(":(");
	System.out.println(one);
	one.removeFirst();
	System.out.println(one);
	one.removeFirst();
 	System.out.println(one);
	one.removeLast();
 	System.out.println(one);
	one.addFirst("kangaroo");
	System.out.println(one);
	one.addFirst("kool-ala");
	System.out.println(one);
	one.addFirst("kamel");
	System.out.println(one);
    
	} **/
}
