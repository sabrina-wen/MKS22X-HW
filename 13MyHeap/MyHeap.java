public class MyHeap {
    private String[] ary;
    private int size;

    public MyHeap() {
	ary = new String[10];
	size = 0;
    }

    /** public myHeap(boolean isMax) {
	} **/

    public void resize() {
        String[] newAry = new String[size * 2];
	for (int i = 0; i < ary.length; i++) {
	    newAry[i] = ary[i];
	}
	ary = newAry;
    }

    public String toString() {
	String ret = "[";
	for (int i = 0; i < ary.length; i++) {
	    ret += ary[i] + ", ";
	}
	ret += "]";
	return ret;
    }

    public void add(String s) {
        if (size == ary.length - 1) {
	    resize();
	}
	int index = size + 1;
        ary[index] = s;
	pushUp(index);
	size++;
    }

    private void pushUp(int pos) {
	while (pos >= 2) {
	    int parent = pos / 2;
	    if (ary[parent].compareTo(ary[pos]) > 0) {
		swap(parent, pos);
	    }
	    pos--;
	}
    }

    private void swap(int a, int b) {
	String temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }

    /** public String remove(String s) {
    }

    private void pushDown() {
    } **/

    public static void main (String[] args) {
	MyHeap one = new MyHeap();
	one.add("e");
        one.add("b");
	one.add("d");
	one.add("a");
	System.out.println(one);
	// System.out.println("b".compareTo("c"));
	// System.out.println(one.size);
    }
}
