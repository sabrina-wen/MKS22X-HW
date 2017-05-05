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
        ary[size + 1] = s;
	size++;
    }

    public void pushUp() {
    }

    public void pushDown() {
    }

    public int setPos(String s) {
	int pos = -1;
	int compVal;
	for (String str:ary) {
	    int val = s.compareTo(ary[i]);
	    if (val < compVal)
    }

    public static void main (String[] args) {
	MyHeap one = new MyHeap();
	one.add("a");
	one.add("b");
	one.add("d");
	System.out.println(one);
	// System.out.println(one.size);
    }
}
