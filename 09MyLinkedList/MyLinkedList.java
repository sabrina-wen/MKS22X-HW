public class MylinkedList {
    private LNode start, end;
    private int size;

    private class LNode {
	int currentVal;
	LNode next;

	public LNode(int value) {
	    this.value = value;
	    next = null;
	}

	public LNode (int value, LNode next) {
	    this.value = value;
	    this.next = next;
	}
    }

    public int size() {
	return size;
    }

    public boolean add (int value) {
        LNode start = new LNode(value);
	size++;
    }

    public String toString() {
	String strList = "[";
	for (int i = 0; i < size(); i++) {
	    strList += 
	}
    }

    
}
