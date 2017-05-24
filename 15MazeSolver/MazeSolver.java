public class MazeSolver {
    private Maze board;
    private boolean animate;

    public MazeSolver(String filename) {
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate) {
	this.animate = animate;
	board = new Maze(filename);
    }

    public String toString() {
	// etc
    }
	

    public void solve(int style) {
	if (style == 0) { // DFS
	    Frontier front = new FrontierStack();
	}
	else if (style == 1) { //  BFS
	    Fronter front = new FrontierQueue();
	}
	else if (style == 2 || style == ) { // BestFirst or A*
	    Frontier front = new FrontierPriorityQueue();
	}
	// throw exception if style >= 4??
	front.add(maze.getStart());
    }
}
