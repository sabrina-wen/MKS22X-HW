import java.util.Scanner;
import java.io.*;

public class USACO{
    // makelake variables
    private int width, length, elevation, lakeDepth;
    private int[][] lake;
    private int[][] stomps;
    // ctravel variables
    private int ctravelRows, ctravelCols, time, startX, startY, endX, endY;
    private int[][] ctravel, ctravelFinal;

    public USACO() {
    }

    public int silver (String filename) {
	try {
	    Scanner scan = new Scanner(new File(filename));
	    ctravelRows = Integer.parseInt(scan.next());
	    ctravelCols = Integer.parseInt(scan.next());
	    time = Integer.parseInt(scan.next());
	    ctravel = new int[ctravelRows][ctravelCols];
	    ctravelFinal = new int[ctravelRows][ctravelCols];

            scan.nextLine();
		
	    for (int r = 0; r < ctravelRows; r++) {
		String line = scan.nextLine();
		for (int i = 0; i < ctravelCols; i++) {
		    if (line.charAt(i) == '*') {
			// System.out.println("lol");
			ctravel[r][i] = -1;
			ctravelFinal[r][i] = -1;
		    }
		    if (line.charAt(i) == '.') {
			ctravel[r][i] = 0;
			ctravelFinal[r][i] = 0;
		    }
		}
	    }

	    startX = Integer.parseInt(scan.next()) - 1;
	    startY = Integer.parseInt(scan.next()) - 1;
	    endX = Integer.parseInt(scan.next()) - 1;
	    endY = Integer.parseInt(scan.next()) - 1;

	    // System.out.println(startX + "\n" + startY + "\n" + endX + "\n" + endY); 
	}
	catch(FileNotFoundException f){
	    System.out.println("Invalid filename");
	    System.exit(1);
	}
	ctravel[startX][startY] = 1;
	// move();
	// System.out.println(neighborSum(startX + 1, startY, ctravel));
	for (int i = 0; i < time; i++) {
	    move();
	}
	return ctravelFinal[endX][endY];	       			
    }

    private int neighborSum(int r, int c) {
	int endVal = 0;
	int[] xDirections = {-1, 0, 1, 0};
	int[] yDirections = {0, 1, 0, -1};
	for (int x = 0, y = 0; r < xDirections.length && c < yDirections.length; r++, c++) {
	    int rowOffset = r + xDirections[x];
	    int colOffset = c + yDirections[y];
	    if (rowOffset >= 0 && rowOffset < ctravel.length
		&& colOffset >= 0 && colOffset < ctravel[0].length
		&& ctravel[rowOffset][colOffset] != -1) {
		endVal += ctravel[rowOffset][colOffset];
	    }
	}
	return endVal;
    }

    private void move() {
	for (int r = 0; r < ctravel.length; r++) {
	    for (int c = 0; c < ctravel[0].length; c++) {
		if (ctravel[r][c] == 0) {
		    ctravel[r][c] = neighborSum(r,c);
		}
		 System.out.println("" + ctravel[r][c]);
	    }
	    System.out.println();
	}
    }

    public String printctravel() {
	String travel = "";
	for(int r = 0; r < ctravelFinal.length; r++){
	    for(int c = 0; c < ctravelFinal[0].length; c++){
		travel += ctravelFinal[r][c] + " ";
	    }
	    travel += "\n";
	}
	return travel;
    }
    
    public int bronze (String file){
	try{
	    Scanner scan = new Scanner(new File(file));
	    length = Integer.parseInt(scan.next());
	    width = Integer.parseInt(scan.next());
	    elevation = Integer.parseInt(scan.next());
	    stomps = new int[Integer.parseInt(scan.next())][3];
	    lake = new int[length][width];

	    for(int r = 0; r < length; r++){
		for(int c = 0; c < width; c++){
		    lake[r][c] = Integer.parseInt(scan.next());
		}
	    }

	    for(int r = 0; r < stomps.length; r++){
		for(int c = 0; c < 3; c++){
		    stomps[r][c] = Integer.parseInt(scan.next());
		}
	    }
	}
	catch(FileNotFoundException f){
	    System.out.println("Invalid filename");
	    System.exit(1);
	}
	solve();
	calculate();
	return lakeDepth;
    }
	
    public void printLake(){
	for(int r = 0; r < length; r++){
	    for(int c = 0; c < width; c++){
		System.out.print(lake[r][c] + " ");
	    }
	    System.out.println();
	}
    }

    public void printStomps(){
	for(int r = 0; r < stomps.length; r++){
	    for(int c = 0; c < 3; c++){
		System.out.print(stomps[r][c] + " ");
	    }
	    System.out.println();
	}
    }

    private void solve() {
	for (int i = 0; i < stomps.length; i++) {
	    stomp(stomps[i][0] - 1, stomps[i][1] - 1, stomps[i][2]);
	}
    }

    private void stomp(int row, int col, int stomps){
	int max = 0;
	for(int r = 0; r < 3; r++){
	    for(int c = 0; c < 3; c++){
		if(lake[row+r][col+c] > max){
		    max = lake[row+r][col+c];
		}
	    }
	}
	int limit = max - stomps;
	for(int r = 0; r < 3; r++){
	    for(int c = 0; c < 3; c++){
	        if(lake[row+r][col+c] > limit){
		    lake[row+r][col+c] = limit;
		}
	    }
	}
    }

    private void calculate() {
	int sum = 0;
	for (int r = 0; r < length; r++) {
	    for (int c = 0; c < width; c++) {
		if (lake[r][c] < elevation) {
		    sum += (elevation - lake[r][c]);
		}
	    }
	}
	lakeDepth = sum * 72 * 72;
    }
}
