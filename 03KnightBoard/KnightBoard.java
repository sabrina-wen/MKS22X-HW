public class KnightBoard {
    private int[][] board;
    
    public KnightBoard (int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
    }

    public String toString() {
	String solution = "";
	for (int r = 0; r < board.length; r++) {
	    for (int c = 0; c < board[0].length; c++) {
		if (board[r][c] < 10) {
		    solution += "_" + board[r][c];
		}
		solution += " ";
	    }
	    solution += "\n";
	}
	return solution;
    }

    public void solve() {
        solveH(0,0,1);
    }

    /**  set knight down
	 try all possible solutions by looping thru arrays
	 set a knight down for each possible move and check to see if another move is possible by calling fn now
	 
	 if not then backtrack by subtract 1 from level, set current cell = to 0, and then try next solution in the array
	 if all solutions from the arrays have been exhausted, then you're done and board can't be solved
     **/

    private boolean solveH (int row, int col, int level) {
	board[row][col] = level;
	if (board.length * board[0].length == level - 1) {
	    return true;
	}
	else {
	    int[] colOptions = {-1, 1, 2, 2, 1, -1, -2, -2};
	    int[] rowOptions = {-2, -2, -1, 1, 2, 2, 1, -1};
	    // board[row][col] = level;
	    for (int i = 0; i < rowOptions.length; i++) {
		for (int j = 0; j < colOptions.length; j++) {
		    int rowOffset = rowOptions[i];
		    int colOffset = colOptions[j];
		    if ((row + rowOffset < board.length && row + rowOffset > -1 )
			&& (col + colOffset < board[0].length && row + colOffset > -1)
			&& (board[row + rowOffset][col + colOffset] == 0)) {
			row += rowOffset;
			col += colOffset;
			level++;
			board[row][col] = level;
			solveH(row, col, level + 1);
		    }
		}
	    }
	    
	}
	return false;
    }

    public static void main (String[] args) {
	KnightBoard b = new KnightBoard(7, 7);
	b.solve();
	System.out.println(b.toString());
    }
}
