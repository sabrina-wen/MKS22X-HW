public class MyHeap {
    private String[] ary;
    private int size;

    public myHeap() {
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
	for (int i = 0; i < size; i++) {
	    ret += ary[i] + ", ";
	}
    }

}
