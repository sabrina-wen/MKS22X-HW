
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
	    board[row][col] = -1;
 	    // adding 1 to all other cells in rows
 	    for (int i = col + 1; i < board[0].length; i++) {
 		board[row][i] += 1;
 	    }
	    // checking cells above
 	    for (int j = row - 1; j >= 0; j--) {
 		board[j][col] += 1;	   
  	    }
	    // checking cells diagonal above right
	    for (int k = col + 1; k < board[0].length; k++) {
	        for (int l = row - 1; l >= 0; l--) {
		    board[k][l] += 1;
		}
	    }

	    // checking cells diagonal bottom right
	    for (int k = col + 1; k < board[0].length; k++) {
	        for (int l = row + 1; l < board.length; l++) {
		    board[k][l] += 1;
		}
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
	// adding 1 to all other cells in rows
	for (int i = col + 1; i < board[0].length; i++) {
	    board[row][i] -= 1;
	}
	// checking cells above
	for (int j = row - 1; j >= 0; j--) {
	    board[j][col] -= 1;	   
	}
	// checking cells diagonal above right
	for (int k = col + 1; k < board[0].length; k++) {
	    for (int l = row - 1; l >= 0; l--) {
		board[k][l] -= 1;
	    }
	}

	// checking cells diagonal bottom right
	for (int k = col + 1; k < board[0].length; k++) {
	    for (int l = row + 1; l < board.length; l++) {
		board[k][l] -= 1;
	    }
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
	// b.addQueen(0,0);
	// b.removeQueen(0,0);
	 b.solve();
	System.out.println(b.toString());
	// b.addQueen(1,1);
	// System.out.println(b.toString());
    }
}
