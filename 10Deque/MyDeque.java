public class MyDeque {
    private String[] ary;
    private int size, front, back;

    public MyDeque() {
	ary = new String[10];
	size = 0;
	front = 0;
	back = 0;
    }

    public void addFirst(String s) {
	if (size == ary.length) {
	    resize(ary);
	}
	
	if (front - 1 < 0) {
	    front = front - 1 + size;
	}
	else {
	    front = front - 1;
	}
	ary[front] = s;
	size++;
    }

    /**  public void addLast(String s) {
    }

    public String removeFirst() {
    }

    public String removeLast() {
    }

    public String getFirst() {
    }

    public String getLast() {
    } **/

    public String[] resize(String[] toResize) {
	String[] newAry = new String[size * 2];
	for (int i = 0;i < toResize.length;i++) {
	    newAry[i] = toResize[i];
	}
	return newAry;
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
    }
}
