import java.util.Stack;

public class StackFrontier implements Frontier { 
    private Stack<Location> stackLoc;

    public StackFrontier() {
	stackLoc = new Stack<Location>();

    public void add (Location loc) {
	stackLoc.add(loc);
    }

    public Location next() {
	return stackLoc.pop();
    }

    public int size() {
	return stackLoc.size();
    }
}
