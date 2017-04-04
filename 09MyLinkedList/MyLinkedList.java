public class MyLinkedList {
    private LNode start, end;
    private int size;

    public MyLinkedList() {
	start = null;
	end = null;
	size = 0;
    }

    private class LNode {
	private int currentVal;
	private LNode next;

	// note: if it's the last element then next = null
	public LNode (int value, LNode next) {
	    currentVal = value;
	    this.next = next;
	}
    }

    public int size() {
	return size;
    }

    // for now i'm adding an element to the beginning of the list
    public boolean add (int value) {
	if (size > 0) {
	    start = new LNode(value, start);
	    // System.out.println(addedVal.next.currentVal);
	}
	if (size == 0) {
	    start = new LNode(value, null);
	}
	size++;
	return true;
    }

    public void add (int index, int value) {
	// idk
    }

    public String toString() {
	String strList = "[";
	LNode current = start;
        while (current != null) {
	    strList += current.currentVal + ", ";
	    current = current.next;
	}
	strList += "]";
	return strList;
    }

    public static void main (String[] args) {
	MyLinkedList list1 = new MyLinkedList();
	list1.add(11);
       	list1.add(541);
	list1.add(-19);
	System.out.println(list1.toString());
    }
}
