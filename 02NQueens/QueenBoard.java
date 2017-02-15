
public class QueenBoard {
    private int[][]board;
    public static int solutionCount;
    
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
    
    // check to make sure not past column
    private boolean solveH(int col){
	// System.out.println(this);
	int i = 0;
	int count = 0;
        for (i = 0; i < board.length; i++) {
	    if (addQueen(i, col)) {
	        if (col > board[0].length - 2 || solveH(col + 1)) {
		    // remove return for countsolutions
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
	    board[row][col] = -1;
	    int offset = 1;
	    while (col + offset < board[0].length) {
		board[row][col + offset] += 1;
		if (row + offset < board.length) {
		    board[row + offset][col + offset] += 1;
		}
		if ( row - offset >= 0) {
		    board[row - offset][col + offset] += 1;
		}
		offset++;
	    }
	    return true;
	}	    		  	  	 
	return false;
    }
    

    private boolean removeQueen(int row, int col) {
	if (board[row][col] != -1) {
	    return false;
	}
	board[row][col] = 0;
	int offset = 1;
	while (col + offset < board[0].length) {
	    board[row][col + offset] -= 1;
	    if (row + offset < board.length) {
		board[row + offset][col + offset] -= 1;
	    }
	    if (row - offset >= 0) {
		board[row - offset][col + offset] -= 1;
	    }
	    offset++;
	}
	return true;
    }

    private boolean isPlaceable(int row, int col) {
        return (board[row][col] == 0);
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
	if (solutionCount == 0) {
	    if (board.length == 2 || board.length == 3) {
		return 0;
	    }
	    else {
		return -1;
	    }
	}
	else {
	    return solutionCount;
	}
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
        String solution = "";
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		if (board[i][j] == -1) {
		    solution += "Q ";
		}
		else {
		    solution += "_ ";
		}
	    }
	    solution += "\n";
	}
	return solution;
    }

     private void countSolutionsH(int col) {
	int i = 0;
        for (i = 0; i < board.length; i++) {
	    if (addQueen(i, col)) {
	        if (col > board[0].length - 2 || solveH(col + 1)) {
		    solutionCount += 1;;
		}
		else {
		    removeQueen(i, col);
		}
	    }
	}
     }

    private void countSolutions() {
	countSolutionsH(0);
    }

    

    public static void main (String[] args) {
	QueenBoard b = new QueenBoard(4);
	// b.addQueen(0,0);
	// b.addQueen(2,3);
	// b.removeQueen(0,0);
	b.solve();
      	// b.addQueen(1,1);
	System.out.println(b.toString());
	System.out.println(solutionCount);
	// System.out.println(b.toString());
    }
}
