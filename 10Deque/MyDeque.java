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
	if (front == 0 && size == 0) {
	    front = 0;
	}
	else if (front == 0 ) {
	    front = ary.length - 1;
	}
	else {
	    front--;
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
	if (back != ary.length - 1) {
	    back++;
	    //System.out.println("HEY");
	}
	else if (back == ary.length - 1) {
	    back = 0;
	    //System.out.println("HI");
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
	if (front == ary.length - 1) {
	    front = 0;
	}
	else if (front != ary.length - 1) {
	    front++;
	}
	size--;
	return firstVal;
    }

    public String removeLast() {
	if (size == 0) {
	    throw new NoSuchElementException();
	}
	String lastVal = getLast();
        ary[back] = null;
	if (back == 0) {
	    back = ary.length - 1;
	}
	else {
	    back--;
	}
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
	int i = 0;
	for (int j = front; j < size + front; j++) {
	    // newAry[i] = ary[(front + i) % ary.length];
	    newAry[i] = ary[j % ary.length];
	    i++;
	}
        ary = newAry;
        front = 0;
	back = size - 1;
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

    /**public static void main(String[] args) {
	MyDeque one = new MyDeque();
	one.addFirst("2");
        System.out.println(one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
        one.addLast("3");
        System.out.println(one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
        one.addFirst("1");
	System.out.println(one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	one.addLast("4");
	System.out.println(one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	one.addFirst("11");
	System.out.println(one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
        one.addLast("-2");
	System.out.println(one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	one.removeFirst();
        System.out.println("Removed first val: " + one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	one.removeFirst();
        System.out.println("Removed first val: " + one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	one.removeFirst();
        System.out.println("Removed first val: " + one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	one.removeFirst();
        System.out.println("Removed first val: " + one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	one.removeFirst();
        System.out.println("Removed first val: " + one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	one.removeFirst();
        System.out.println("Removed first val: " + one);
	System.out.println("front val: " + one.front + " back val: " + one.back);
	/** one.removeFirst();
 	System.out.println(one);
	one.removeLast();
 	System.out.println(one);
	one.addFirst("kangaroo");
	System.out.println(one);
	one.addFirst("kool-ala");
	System.out.println(one);
	one.addFirst("kamel");
	System.out.println(one); **/
    
    //} 
}
