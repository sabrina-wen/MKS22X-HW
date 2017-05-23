import java.util.Stack;

public class StackFrontier implements Frontier { 
    private Stack<Location> stackLoc;
    private int size;

    public StackFrontier() {
	stackLoc = new Stack<Location>();
    }

    public void add (Location loc) {
	stackLoc.push(loc);
	size++;
    }

    public Location next() {
	size--;
	return stackLoc.pop();
    }

    public int size() {
	return stackLoc.size();
    }

    /** public static void main (String[] args) {
	StackFrontier s = new StackFrontier();
	s.add(new Location(2, 3, null, 0, 0, false));
	s.next();
	} **/

}
