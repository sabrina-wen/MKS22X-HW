public class RunningMedian {
    
    public MyHeap left;
    public MyHeap right;

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

	if (left.size() - right.size() >= 2) {
	    right.add(left.remove());
	}
	if (right.size() - left.size() >= 2) {
	    left.add(right.remove());
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
	med.add(1);
	// System.out.println(med);
	med.add(2);
	// System.out.println(med);
        med.add(3);
	System.out.println(med);
        med.add(4);
        System.out.println(med);
	System.out.println(med.getMedian());
    }
}
