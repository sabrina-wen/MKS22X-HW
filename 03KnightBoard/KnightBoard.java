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
		    solution += " " + board[r][c];
		}
		else {
		    solution += board[r][c];
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
	// System.out.println("\033c");
	// System.out.println(this);
	// board[row][col] = level;
	if (level > board.length * board[0].length) {
	    return true;
	}
	if (board[row][col] == 0) {
	    board[row][col] = level;
	    int[] colOptions = {-1, 1, 2, 2, 1, -1, -2, -2};
	    int[] rowOptions = {-2, -2, -1, 1, 2, 2, 1, -1};
	    for (int i = 0, j = 0; i < rowOptions.length && j < colOptions.length; i++, j++) {
		int rowOffset = rowOptions[i];
		int colOffset = colOptions[j];
		if ((row + rowOffset < board.length && row + rowOffset >= 0 )
		    && (col + colOffset < board[0].length && col + colOffset >= 0)) {
		    if (solveH(row + rowOffset, col + colOffset, level + 1)) {
			return true;
		    }
		}
		    
	    }
	    board[row][col] = 0;
	}
	return false;	
    }

	public static void main (String[] args) {
	    // works for the following:
	    // 6x7, 7x8, 6x8, 6x6, 5x5, 4x7, 6x7
	    KnightBoard b = new KnightBoard(7,6);
	    b.solve();
	    // System.out.println(b.toString());
	}
    }
