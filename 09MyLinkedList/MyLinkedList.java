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

    public void add (int index, int value) {
	// idk
    }

    private void addAfter(LNode location, LNode toBeAdded) {
	if (size == 0) {
	    head = toBeAdded;
	    tail = toBeAdded;
	}
	else if (location.next == null) { // if location = tail
	    location.next = toBeAdded;
	    toBeAdded.prev = location;
	    tail = location.next;
	}
	else { // if location is anywhere in the list besides the tail
	    toBeAdded.prev = location;
	    toBeAdded.next = location.next;
	    location.next.prev = toBeAdded;
	    location.next = toBeAdded;
	}
	size++;
    }

    public boolean add (int value) {
	addAfter(tail, new LNode(value));
	/** else {
	    LNode current = head;
	    while (current.next != null) {
		current = current.next;
	    }
	    current.next = new LNode(value);
	    } **/
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
	    // System.out.println("trololol");
	    current.prev.next = current.next;
	    current.next.prev = current.prev;
	}
	else if (current.prev == null && current.next == null) {
	    System.out.println("trololol");
	    head = null;
	    tail = null;
	}
	else if (current.prev == null) { // if head element
	    head = current.next;
	    current.next.prev = null;
	}
	else { // assuming current.next == null
	    // System.out.println("trololol");
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
	return current;
    }

     public int remove(int index) {
	 LNode nodeToRemove = getNthNode(index);
	 int removedVal = get(index);
	 remove(nodeToRemove);
	 return removedVal;
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
	// System.out.println(list1.getNthNode(1));
        System.out.println(list1.remove(2));
	System.out.println(list1);
	
    }
}
