
public class RunningMedian {
    
    public MyHeap left; // #s <= median, max
    public MyHeap right; // #s >= median, min heap

    public RunningMedian() {
	left = new MyHeap(true);
	right = new MyHeap(false);
    }

    public void add (int num) {
	if (left.size() == 0 && right.size() == 0) {
	    left.add(num);
	}
	else if ((double)num < getMedian()) {
	    left.add(num);
	}
	else {
	    right.add(num);
	}

	if (left.size() > right.size() + 1) {
	    right.add(left.remove());
	}
        if (right.size() > left.size() + 1) {
	    left.add(right.remove());
	    // System.out.println("Removed val: " + right.remove());
	    // left.add(right.pe);
	    // right.remove();
	    // System.out.println("HEY");
	} 
    }

    public double getMedian() {
	if (left.size() == right.size()) {
	    return (left.peek() + right.peek()) / 2.0;
	}
	else if (left.size() > right.size()) {
	    return left.peek();
	}
	else {
	    return right.peek();
	}
    }

    public String toString() {
	return "Left heap: " + left + "\n Right heap: " + right;
    }

    public static void main (String[] args) {
	RunningMedian med = new RunningMedian();
	RunningMedian angery = new RunningMedian();
	for (int i = 0; i < 5; i++) {
	    angery.add(i);
	}
	med.add(1);
	System.out.println(med);
	med.add(2);
	System.out.println(med);
        med.add(3);
	System.out.println(med);
        med.add(4);
	med.add(5);
	med.add(6);
	med.add(7);
	System.out.println(med);
	med.add(8);
        //System.out.println(med);
	System.out.println(med.getMedian());
    }
}
