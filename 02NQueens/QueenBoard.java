
public class QueenBoard {
    private int[][]board;
    private int solutionCount;
    
    public QueenBoard(int size){
	board = new int[size][size];
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public boolean solve() {
	return solveH(0);
    }

    private boolean solveH(int col){
	int i = 0;
        for (i = 0; i < board.length; i++) {
	    if (addQueen(i, col)) {
		if (col == board.length - 1) {
		    return true;
		}
	        if (solveH(col + 1)) {
		    return true;
		}
		else {
		    removeQueen(i, col);
		}
	    }
	}
	return false;
    }

    // if a cell is occupied by a queen, cell == -1
    // if cell is not occupied by a queen and can't be occupied, it will be a # > 0
    // if a cell isn't occupied but could be occupied, cell == 0
    private boolean addQueen(int row, int col) {
	if (isPlaceable(row, col)) {
	    for (int r = row; r < board.length; r++) {
		for (int c = col; c < board[0].length; c++) {
		    if (row - r == 0 ||
			col - c == 0 ||
			Math.abs(row - r) == Math.abs(col - c)) {
			    board[r][c] += 1;
		    }
		}
	    }
             board[row][col] = -1;
            return true;
	} 
        return false;
    }

    private boolean removeQueen(int row, int col) {
	if (board[row][col] == -1) {
	    for (int r = 0; r < board.length; r++) {
		for (int c = 0; c < board[0].length; c++) {
		    if (row - r == 0 ||
			col - c == 0 ||
			Math.abs(row - r) == Math.abs(col - c)) {
			    board[r][c] -= 1;
		    }
		}
	    }
	    board[row][col] = 0;
	    return true;
	}
        return false;
    }

    private boolean isPlaceable(int row, int col) {
        return (board[row][col] == 0);
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
	if (solutionCount > 0) {
	    return solutionCount;
	}
    	return -1;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
        String solution = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		solution += board[i][j] + "  ";
	    }
	    solution += "\n";
	}
	return solution;
    }

    // public void countSolutions() {
    // }

    public static void main (String[] args) {
	QueenBoard b = new QueenBoard(4);
	b.addQueen(0,0);
	b.removeQueen(0,0);
	// b.solve();
	System.out.println(b.toString());
	// b.addQueen(1,1);
	// System.out.println(b.toString());
    }
}
