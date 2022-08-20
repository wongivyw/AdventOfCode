package year2021_day05;

import java.util.ArrayList;

public class HydrothermalVenture {
	ArrayList<KeyPair> values;
	int mapRows;
	int mapCols;
	int[][] map;

	public HydrothermalVenture(ArrayList<KeyPair> values, int numRows, int numCols) {
		this.values = values;
		mapRows = numRows;
		mapCols = numCols;
		map = new int[mapRows][mapCols];
		map();
	}
	
	public void printKeyPairs() {
		for (KeyPair kp : values) {
			System.out.println("Coordinates: (" + kp.getX1() + ", " + kp.getY1() + ") (" +
					kp.getX2() + ", " + kp.getY2() + ")");
		}
	}
	
	private void initializeMap() {
		for (int i = 0; i < mapRows; i++) {
			for (int j = 0; j < mapCols; j++) {
				map[i][j] = 0;
			}
		}
	}
	
	private void map() {
		initializeMap();
		for (KeyPair kp : values) {
			ArrayList<Coordinate> cds = kp.getLine();
			
			for (Coordinate c : cds) {
				int x = c.getX();
				int y = c.getY();
				
				map[y][x]++;
			}
		}
		
		//print map for testing
//		for (int i = 0; i < mapRows; i++) {
//			for (int j = 0; j < mapCols; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
	}
	
	public int dangerZones() {
		int count = 0;
		for (int i = 0; i < mapRows; i++) {
			for (int j = 0; j < mapCols; j++) {
				if (map[i][j] > 1) {
					count++;
				}
			}
		}
		return count;
	}
}
