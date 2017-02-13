
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
        
	return false;
    }

    private int addQueen(int row, int col) {
	if (isPlaceable) {
	    for (int r = 0; r < board.length; r++) {
		checkIfQueenIsAlreadyInRow - compare xs;
	    }
	    return true;
	}
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
		solution += board[i][j] + "_";
	    }
	    solution += "_";
	}
	return solution;
    }

    // public void countSolutions() {
    // }

    public static void main (String[] args) {
	QueenBoard b = new QueenBoard(2);
	System.out.println(b.toString());
    }
}
