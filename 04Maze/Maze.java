import java.util.*;
import java.io.*;

public class Maze{

    private char[][]maze;
    private boolean animate;
    private String data;
    private int xcor, ycor;

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)
      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.
    */

    public Maze (String filename) {
	try {
	    File text = new File(filename);
	    Scanner sc = new Scanner(text);
	    int numS = 0;
	    int numE = 0;
	    int rowCount = 0;
	    int colCount = 0;
	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
		// System.out.println(line);
		rowCount++;
		colCount = line.length();
		for (int i = 0; i < line.length(); i++) {
		    if (line.charAt(i) == 'S') {
			numS++;
		    }
		    if (line.charAt(i) == 'E') {
			numE++;
		    }
		}
	    }
	    if (numS != 1 || numE != 1) {
		System.out.println("File does not contain an S and/or an E OR has too many S/E characters.");
		// System.out.println("S chars: " + numS + " E chars: " + numE);
		System.exit(1);
	    }
	    maze = new char[rowCount][colCount];
	    sc = new Scanner(text);
	    int row = 0;
	    while (sc.hasNextLine()) {
		String data = sc.nextLine();
		// System.out.println(data);
		char[] dataChar = new char[data.length()];
		for (int i = 0; i < data.length(); i++) {
		    if (data.charAt(i) == 'S') {
			xcor = row;
			ycor = i;
		    }
		    dataChar[i] = data.charAt(i);
		    
		}
		maze[row] = dataChar;
	        row++;
	    } 
	    // System.out.println(maze);
	}
	    
	catch (FileNotFoundException e) {
	    System.out.println("File can't be found, check for typos!");
	    System.exit(1);
	}
	animate = false;
    }

    private void wait(int millis){ 
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
     }

    public void setAnimate(boolean b){
        animate = b;
    }

    public void clearTerminal(){
        //erase terminal, go to top left of screen.
        System.out.println("\033[2J\033[1;1H");
    }

    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
	int startr = xcor, startc = ycor;
	// Initialize starting row and startint col with the location of the S. 
	maze[startr][startc] = ' '; //erase the S, and start solving!
	return true;
	// return solve(startr, startc);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.

      Postcondition:
        The S is replaced with '@' but the 'E' is not.
        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);
            wait(20);
        }

        //COMPLETE SOLVE
        return false; //so it compiles
    }

     public String toString() {
	String finished = "";
	for (int r = 0; r < maze.length; r++) {
	    for (int c = 0; c < maze[0].length; c++) {
		finished += maze[r][c];
	    }
	    finished += "\n";
	}
	return finished;
	} 

}
