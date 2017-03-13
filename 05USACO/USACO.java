import java.util.Scanner;
import java.io.*;

public class USACO{
    // makelake variables
    private int width, length, elevation, lakeDepth;
    private int[][] lake;
    private int[][] stomps;
    // ctravel variables
    private int ctravelRows, ctravelCols, time, startX, startY, endX, endY;
    private int[][] ctravel;

    public USACO() {
    }

    public int silver (String filename) {
	try {
	    Scanner scan = new Scanner(new File(filename));
	    ctravelRows = Integer.parseInt(scan.next());
	    ctravelCols = Integer.parseInt(scan.next());
	    time = Integer.parseInt(scan.next());
	    ctravel = new int[ctravelRows][ctravelCols];

            scan.nextLine();
	    int[] numsInLine = new int[ctravelCols];
		
	    for (int r = 0; r < ctravelRows; r++) {
		String line = scan.nextLine();
		for (int i = 0; i < ctravelCols; i++) {
		    if (line.charAt(i) == '*') {
			// System.out.println("lol");
			ctravel[r][i] = -1;
		    }
		    if (line.charAt(i) == '.') {
			ctravel[r][i] = 0;
		    }
		}
	    }

	    startX = Integer.parseInt(scan.next());
	    startY = Integer.parseInt(scan.next());
	    endX = Integer.parseInt(scan.next());
	    endY = Integer.parseInt(scan.next());

	    // System.out.println(startX + "\n" + startY + "\n" + endX + "\n" + endY); 
	}
	catch(FileNotFoundException f){
	    System.out.println("Invalid filename");
	    System.exit(1);
	}
	return 1;
    }

    public String printctravel() {
	String travel = "";
	for(int r = 0; r < ctravelRows; r++){
	    for(int c = 0; c < ctravelCols; c++){
		travel += ctravel[r][c] + " ";
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
