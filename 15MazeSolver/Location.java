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

    public int getDistToGoal() {
	return distToGoal;
    }

    public int getDistToStart() {
	return distToStart;
    }

    public int compareTo (Location other) {
	if (aStar) {
	    return (this.getDistToStart() + this.getDistToGoal()) - (other.getDistToStart() + other.getDistToGoal());
	}
	else {
	    return this.getDistToGoal() - other.getDistToGoal();
	}
    }
    
}
