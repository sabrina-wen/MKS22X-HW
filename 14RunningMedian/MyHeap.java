public class MyHeap {
    private Integer[] ary;
    private int size;
    private int changer;

    public MyHeap() {
	ary = new Integer[1];
	size = 0;
	changer = -1;
    }

    public MyHeap(boolean isMax) {
	ary = new Integer[10];
	size = 0;
	if (isMax) {
	    changer = -1;
	}
	else {
	    changer = 1;
	}
    } 

    public void resize() {
        Integer[] newAry = new Integer[size * 2];
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
	    if (changer * ary[parent].compareTo(ary[pos]) > 0) {
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
	swap(ary[1], ary[size]);
	ary[size] = null;
	size--;
	pushDown();
	// System.out.println("removed: " + retVal);
	return retVal;
    }

    private void pushDown() {
	int index = 1;
	while (index * 2 + 1 < size) {
	    if (changer * (Integer)ary[index].compareTo((Integer)ary[index * 2]) < 0) {
		swap(index, index * 2);
	    }
	    if (changer * (Integer)ary[index].compareTo((Integer)ary[index * 2 + 1]) < 0) {
		swap(index, index * 2 + 1);
	    }
	    index++;
	}
    }

    public int peek() {
	return ary[1];
    }

    public int size() {
	return size;
    }

     public static void main (String[] args) {
	MyHeap one = new MyHeap(false);
	// System.out.println(((Integer)2).compareTo((Integer)3));
	/** one.add(11);
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
	one.peek(); **/
        for (int i = 1; i <= 4; i++) {
	    one.add(i);
	}
	one.remove();
	System.out.println(one);
	// System.out.println("b".compareTo("c"));
	// System.out.println(one.size);
	}  
}
