public class MyLinkedList {
    LNode head, tail;
    int size;

    public MyLinkedList() {
	head = null;
	tail = null;
	size = 0;
    }

    private class LNode {
	int value;
        LNode next, prev;

	// note: if it's the last element then next = null
	public LNode (int value) {
	    this.value = value;
	}

	public String toString() {
	    return "" + value;
	}
    }

    public String toString() {
	String strList = "[";
	LNode current = head;
	while (current != null) {
	    strList += current.value + ", ";
	    current = current.next;
	}
	strList += "]";
	return strList;
    }

    public int size() {
	return size;
    }

    public boolean add (int value) {
	if (head == null) {
	    head = new LNode(value);
	}
	else {
	    LNode current = head;
	    while (current.next != null) {
		current = current.next;
	    }
	    current.next = new LNode(value);
	}
	size++;
	return true;
    }

    public void add (int index, int value) {
	// idk
    }

    public static void main (String[] args) {
        MyLinkedList list1 = new MyLinkedList();
	list1.add(11);
       	list1.add(541);
	list1.add(-19);
	System.out.println(list1.toString());
    }
}
