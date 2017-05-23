import java.util.Queue;

public class StackFrontier implements Frontier {
    private Queue<Location> q;
    private int size;

    public StackFrontier() {
	q = new Queue<Location>;
    }

    public void add(Location loc) {
	q.add(loc);
	size++;
    }

    public Location next() {
	size--;
	return q.poll();
    }

    public int size() {
	return size;
    }
}
