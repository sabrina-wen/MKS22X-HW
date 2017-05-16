public class Location implements Comparable<Location> {
    private int row, col;
    private int distToGoal, distToStart;
    private Location previous; // used to trace solution
    private boolean aStar; // if true, compareTo uses previousDistance + distanceToGoal, if false, compareTo uses distanceToGoal ONLY

    public Location (int r, int c, Location previous, int distToStart, int distToGoal, boolean aStar) {
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
	this.aStar = aStar;
    }

    // if not using astar: 
    public Location (int r, int c, Location previous, int distToStart, int distToGoal) {
	row = r;
	col = c;
	this.previous = previous;
	this.distToStart = distToStart;
	this.distToGoal = distToGoal;
    }

    public int getDistToGoal() {
	return distToGoal;
    }

    public int getDistToStart() {
	return distToStart;
    }

    public int compareTo (Location other) {
	if (aStar) {
	    return (this.previous.getDistToGoal() + this.getDistToGoal()) - (other.previous.getDistToGoal() + other.getDistToGoal());
	}
	else {
	    return this.getDistToGoal() - other.getDistToGoal();
	}
    }
    
}
