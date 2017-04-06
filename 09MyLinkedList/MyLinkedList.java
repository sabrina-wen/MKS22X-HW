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

    public int get (int index) {
	/** if (index < 0 || index > size()) {
	    throw IndexNotFoundException();
	    } **/
	int counter = 0;
	LNode current = head;
	while (current.next != null && counter != index) {
	    System.out.println("!");
	    current = current.next;
	    counter++;
	}
	return current.value;
    }

    public int set(int index, int value) {
	/** if (index < 0 || index > size()) {
	    throw IndexNotFoundException();
	    } **/
	int counter = 0;
	LNode current = head;
	while (current.next != null && counter != index) {
	    System.out.println("!");
	    current = current.next;
	    counter++;
	}
	current.value = value;
	return current.value;
    }

    /** public int indexOf(int value) {
    }

    private LNode getNthNode(int in) {
    }

    private void remove(LNode target) {
    }

    public int remove(int index) {
    } **/


    public void add (int index, int value) {
	// idk
    }

    public static void main (String[] args) {
        MyLinkedList list1 = new MyLinkedList();
	list1.add(11);
       	list1.add(541);
	list1.add(-19);
	System.out.println(list1.toString());
	System.out.println(list1.get(2));
	System.out.println(list1.set(2, 7));
    }
}
