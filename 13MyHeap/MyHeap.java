public class MyHeap {
    private String[] ary;
    private int size;
    private int changer;

    public MyHeap() {
	ary = new String[10];
	size = 0;
	changer = -1;
    }

    public MyHeap(boolean isMax) {
	ary = new String[10];
	size = 0;
	if (isMax) {
	    changer = -1;
	}
	else {
	    changer = 1;
	}
    } 

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

    // this is for a min heap
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
	    if (changer * ary[parent].compareTo(ary[pos]) > 0) {
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

    public String remove() { // always removes top node
	String retVal = ary[1];
	ary[1] = ary[size];
	ary[size] = null;
	size--;
	pushDown();
	return retVal;
    }

    private void pushDown() {
	int index = 1;
	while (index < size && ary[index * 2] != null && ary[index * 2 + 1] != null) {
	    if (changer * ary[index].compareTo(ary[index * 2]) > 0) {
		swap(index, index * 2);
	    }
	    if (changer * ary[index].compareTo(ary[index * 2 + 1]) > 0) {
		swap(index, index * 2 + 1);
	    }
	    index++;
	}
    }

    public String peek() {
	return ary[1];
    }

    /** public static void main (String[] args) {
	System.out.println("z".compareTo("a"));
	MyHeap one = new MyHeap(false);
	one.add("e");
        one.add("a");
	one.add("g");
	one.add("z");
	one.add("cy");
	one.add("r");
	one.add("c");
	one.add("b");
	System.out.println(one);
	one.remove();
	System.out.println(one);
	one.peek();
	// System.out.println("b".compareTo("c"));
	// System.out.println(one.size);
	} **/
}
