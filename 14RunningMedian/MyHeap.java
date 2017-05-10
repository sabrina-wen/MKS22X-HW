public class MyHeap {
    private int[] ary;
    private int size;
    private int changer;

    public MyHeap() {
	ary = new int[1];
	size = 0;
	changer = -1;
    }

    public MyHeap(boolean isMax) {
	ary = new int[10];
	size = 0;
	if (isMax) {
	    changer = -1;
	}
	else {
	    changer = 1;
	}
    } 

    public void resize() {
        int[] newAry = new int[size * 2];
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
    public void add(int s) {
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
	    if (changer * ary[parent] > ary[pos]) {
		swap(parent, pos);
	    }
	    pos--;
	}
    }

    private void swap(int a, int b) {
	int temp = ary[a];
	ary[a] = ary[b];
	ary[b] = temp;
    }

    public int remove() { // always removes top node
	int retVal = ary[1];
	ary[1] = ary[size];
	ary[size] = 0;
	size--;
	pushDown();
	return retVal;
    }

    private void pushDown() {
	int index = 1;
	while (index <= size / 2) {
	    if (changer * ary[index] > ary[index * 2]) {
		swap(index, index * 2);
	    }
	    if (changer * ary[index] > ary[index * 2 + 1]) {
		swap(index, index * 2 + 1);
	    }
	    index++;
	}
    }

    public int peek() {
	return ary[1];
    }

    /** public static void main (String[] args) {
	MyHeap one = new MyHeap(false);
	one.add(11);
        one.add(3);
	one.add(-5);
	one.add(6);
	System.out.println(one);
	one.add(28);
	System.out.println(one);
	one.add(143);
	System.out.println(one);
	one.add(1);
	System.out.println(one);
	one.add(0);
	System.out.println(one);
	one.remove();
	System.out.println(one);
	System.out.println(one.size);
	one.peek();
	// System.out.println("b".compareTo("c"));
	// System.out.println(one.size);
	} **/
}
