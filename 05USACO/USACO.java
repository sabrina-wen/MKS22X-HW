import java.util.Scanner;
import java.io.*;

public class USACO{
    private int width, length, elevation, lakeDepth;
    private int[][] lake;
    private int[][] stomps;
    
    private int bronze (String file){
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
	
    public static void main(String[]args){
        USACO a = new USACO();
	// System.out.println(a.width + " " + a.length);
	// a.stomp(0,3,4);
	// scan("text1.txt");
	// solve();
	// a.printLake();
	// System.out.println();
	System.out.println(a.bronze("test1.txt"));;
	// a.stomp(0,0,10);
	// a.printLake();
    }
}
