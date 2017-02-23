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

    // public void solve() {
        
    // }

    // private boolean solveH (int row, int col, int level) {
    // }

    public static void main (String[] args) {
	KnightBoard b = new KnightBoard(4, 4);
	// b.solve();
	System.out.println(b.toString());
    }
}
