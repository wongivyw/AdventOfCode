package day5;

import java.util.ArrayList;

public class KeyPair {
	int x1, y1, x2, y2;
	Coordinate start, end;
	ArrayList<Coordinate> line = new ArrayList<Coordinate>();
	
	public KeyPair(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		start = new Coordinate(x1, y1);
		end = new Coordinate(x2, y2);
		line = computeLine();
	}
	private ArrayList<Coordinate> computeLine() {
//		if (x1 == x2 || y1 == y2) {
			return computePerp();
//		}
//		return computeDiagonal();
	}
	
	private ArrayList<Coordinate> computePerp() {
		ArrayList<Coordinate> line = new ArrayList<Coordinate>();
//		if (x1 != x2 && y1 != y2) {
//			return line;
//		}
		line.add(new Coordinate(x1, y1));
		if (x1 == x2 && y1 == y2) {
			return line;
		}
		line.add(new Coordinate(x2, y2));
		//add inbetween coordinates
		if (x1 == x2) {
			// add line of y
			int highNum = Math.max(y1, y2);
			int lowNum = Math.min(y1, y2);
			for (int i = lowNum + 1; i < highNum; i++) {
				line.add(new Coordinate(x1, i));
			}
			
		} else if (y1 == y2) {
			//add line of x
			int highNum = Math.max(x1,x2);
			int lowNum = Math.min(x1, x2);
			for (int i = lowNum + 1; i < highNum; i++) {
				line.add(new Coordinate(i, y1));
			}
		}
		
		//part 2 only
		else {
			int numCoords = Math.abs(x1-x2);
			int x = 0, y = 0;
			for (int i = 1; i < numCoords; i++) {
				if (x1 > x2) { // x decreases
					x = x1 - i;
				} else {
					 x = x1 + i;
				}
				if (y1 > y2 ) {
					y = y1 - i;
				} else {
					y = y1 + i;
				}
				line.add(new Coordinate(x, y));
			}
		}
		// --end of part 2 only
				
		//print line for testing
//		System.out.println("LINE: ");
//		for (Coordinate c : line) {
//			System.out.println("(" + c.getX() + "," + c.getY() + ")");
//		}
//		System.out.println();
		return line;
			
	}
	
//	private ArrayList<Coordinate> computeDiagonal() {
//		ArrayList<Coordinate> lineDiag = new ArrayList<Coordinate>();
//
//		lineDiag.add(new Coordinate(x1, y1));
//		if (x1 == x2 && y1 == y2) {
//		return lineDiag;
//	}
//		lineDiag.add(new Coordinate(x2, y2));
//		
//		lineDiag.add(new Coordinate(0, 0));
//		line.add(new Coordinate(0, 0));
//		
//		
//		int highY = Math.max(y1, y2);
//		int highX = Math.max(x1, x2);
//		int lowY = Math.min(y1, y2);
//		int lowX = Math.min(x1, x2);
//		for (int i = lowNum + 1; i < highNum; i++) {
//			lineDiag.add(new Coordinate(x1, i));
//		}
//
//		return lineDiag;
//	}
	
	public int getX1() {
		return x1;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getY1() {
		return y1;
	}
	
	public int getY2() {
		return y2;
	}
	
	public ArrayList<Coordinate> getLine() {
		return line;
	}
	
}
