import java.util.*;

public class FrontierPriorityQueue implements Frontier{
    private MyHeap heapp;

    public FrontierPriorityQueue() {
	heapp = new MyHeap();
    }

    public void add (Location l) {
	heapp.add(l);
    }

    public Location next() {
	return heapp.remove();
    }

    public int size() {
	return heapp.size();
    }

    public String toString() {
	return heapp.toString();
    }
    
}
