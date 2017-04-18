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
        if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	} 
	int counter = 0;
	LNode current = head;
	while (current.next != null && counter != index) {
	    // System.out.println("!");
	    current = current.next;
	    counter++;
	}
	return current.value;
    }

    public int set(int index, int value) {
        if (index < 0 || index > size()) {
	    throw new IndexOutOfBoundsException();
	 } 
	int counter = 0;
	LNode current = head;
	while (current.next != null && counter != index) {
	    // System.out.println("!");
	    current = current.next;
	    counter++;
	}
	int oldVal = current.value;
	current.value = value;
	return oldVal;
    }
	
    public int indexOf(int value) {
        int counter = 0;
	while (counter < size) {
	    if (get(counter) == value) {
		return counter;
	    }
	    counter++;
	}
	return -1;
    }

    private LNode remove (LNode current) {
	if (current.prev != null && current.next != null) {
	    current.prev.next = current.next;
	    current.next.prev = current.prev;
	}
	else if (current.prev == null && current.next == null) {
	    head = null;
	    tail = null;
	}
	else if (current.prev == null) { // if head element
	    head = current.next;
	    current.next.prev = null;
	}
	else { // assuming current.next == null
	    tail = current.prev;
	    current.prev.next = null;
	}
	size--;
	return current;
    }

    // shoulda written this originally :(
    private LNode getNthNode(int n) {
	if (n < 0 || n > size) {
	    throw new IndexOutOfBoundsException();
	}
	LNode current = head;
	int counter = 0;
	while (counter < n) {
	    current = current.next;
	    counter++;
	}
	// System.out.println(current.value);
	return current;
    }

    /** public int remove(int index) {
	LNode val = get
        
	} **/


    public void add (int index, int value) {
	// idk
    }

    public static void main (String[] args) {
        MyLinkedList list1 = new MyLinkedList();
	list1.add(11);
       	list1.add(541);
	list1.add(-19);
	System.out.println(list1);
	// System.out.println(list1.get(2));
	//System.out.println(list1.set(2, 7));
	// System.out.println("new list " + list1);
        System.out.println(list1.getNthNode(1));
	
    }
}
