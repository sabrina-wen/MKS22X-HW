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
	if (size == ary.length) {
	    resize();
	    // System.out.println("lol");
	}
	/** if (size == 1) {
	    back = front;
	    } **/
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
	 System.out.println("front: " + front + " back: " + back + ", size: " + size + " length of array: " + ary.length);
    }

    public void addLast(String s) {
	if (size == ary.length) {
	    resize();
	}
	if (size != 0) {
	    back %=  ary.length;
	}
        ary[back] = s;
	size++;
	System.out.println("front: " + front + " back: " + back + ", size: " + size + " length of array: " + ary.length);
    }

    /** public String removeFirst() {
    }

    public String removeLast() {
    }

    public String getFirst() {
    }

    public String getLast() {
    } **/

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
	return retVal;
    }

    public static void main(String[] args) {
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
    }
}
