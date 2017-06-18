import java.util.*;

public class MazeSolver {
    private Maze board;
    private boolean animate;
    private boolean aStar;

    public MazeSolver(String filename) {
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate) {
	this.animate = animate;
	board = new Maze(filename);
    }

    public String toString() {
        if (animate) {
	    return board.toString(2);
	}
	else {
	    return board.toString();
	}
    }

    public void solve() {
	solve(1);
    }

    public void solve(int style) {
	Frontier front = null;
	if (style == 0) { // DFS
	    front = new StackFrontier();
	    // System.out.println("0");
	}
	else if (style == 1) { //  BFS
	    front = new QueueFrontier();
	}
	else if (style == 2 || style == 3) { // BestFirst
	    front = new FrontierPriorityQueue();
	}
	else if (style == 3) { // A*
	    aStar = true;
	    front = new FrontierPriorityQueue();
	}
	// throw exception if style >= 4??
	front.add(board.getStart());
	Location current = null;
	while (front.size() > 0) {
	    // System.out.println("hi");
	    current = front.next();
	    // System.out.println("xcor: " + current.getRow() + " ycor: " + current.getCol());
	    // System.out.println(front.toString());
	
	    // if you are at end location you're done


	    if (distToGoal(current.getRow(), current.getCol()) == 0) {
		board.set(current.getRow(), current.getCol(), 'E');
		current = current.previous;
		// go backwards to trace path
		while (current.previous != null) {
		    board.set(current.getRow(), current.getCol(), '@');
		    current = current.previous;
		}
		// if no prev = @ start pos
		if (distToStart(current.getRow(), current.getCol()) == 0) {
		    board.set(current.getRow(), current.getCol(), 'S');
		}
		break; // exit bc done
	    }
	    // if not done, set the spots u searched to a .
	    board.set(current.getRow(), current.getCol(), '.');
	    // adding frontiers
		for (Location neighbor:getValidNeighbors(current, style == 3)) {
		    front.add(neighbor);
		    //System.out.println("front added");
		    board.set(neighbor.getRow(), neighbor.getCol(), '?'); // ? = frontier
		}

		//System.out.println("xcor: " + current.getRow() + " ycor: " + current.getCol());
		//System.out.println(front.toString());
	}
    }

    private int distToStart(int r, int c) {
	Location start = board.getStart();
	return Math.abs(start.getRow() - r) + Math.abs(start.getCol() - c);
    }

    private int distToGoal(int r, int c) {
	Location end = board.getEnd();
	return Math.abs(end.getRow() - r) + Math.abs(end.getCol() - c);
    }
    
    private ArrayList<Location> getValidNeighbors(Location l, boolean aStar) {
	ArrayList<Location> neighbors = new ArrayList<Location>();
	if (board.get(l.getRow() + 1, l.getCol()) == ' ') {
	    neighbors.add(new Location(l.getRow() + 1, l.getCol(), l, distToStart(l.getRow() + 1, l.getCol()), distToGoal(l.getRow() + 1, l.getCol()), aStar));
	}
	if (board.get(l.getRow(), l.getCol() + 1) == ' ') {
	    neighbors.add(new Location(l.getRow(), l.getCol() + 1, l, distToStart(l.getRow(), l.getCol() + 1), distToGoal(l.getRow(), l.getCol() + 1), aStar));
	}
	if (board.get(l.getRow() - 1, l.getCol()) == ' ') {
	    neighbors.add(new Location(l.getRow() - 1, l.getCol(), l, distToStart(l.getRow() - 1, l.getCol()), distToGoal(l.getRow() - 1, l.getCol()), aStar));
	}
	if (board.get(l.getRow(), l.getCol() - 1) == ' ') {
	    neighbors.add(new Location(l.getRow(), l.getCol() - 1, l, distToStart(l.getRow(), l.getCol() - 1), distToGoal(l.getRow(), l.getCol() - 1), aStar));
	}
	return neighbors;
    }

    /** public static void main (String[] args) {
	MazeSolver m = new MazeSolver(args[0]);
        m.solve(Integer.parseInt(args[1]));
	// System.out.println(board.getStart().compareTo(board.getEnd()));
	System.out.println(m);
	} **/
}
