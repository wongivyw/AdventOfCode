package day9;

import java.util.ArrayList;

import util.Printer;

public class HeightMap {
	
	//part 1
	ArrayList<ArrayList<Integer>> input;
	ArrayList<Integer> lowPoints;
	int riskLevel = -1;
	
	//part2
	ArrayList<ArrayList<Location>> advancedHeightMap;
	ArrayList<Location> advancedLowPoints;
	ArrayList<Basin> basins;

	

	public HeightMap(ArrayList<ArrayList<Integer>> input) {
		this.input = input;
		advancedLowPoints = new ArrayList<Location>();
		advancedHeightMap = new ArrayList<ArrayList<Location>>();
		
		//part 1
//		lowPoints = findLowPoints();
//		riskLevel = calcRiskLevel(lowPoints);
////		for (Integer i : lowPoints) System.out.println(i);
		
		//part 2
		advancedHeightMap = inputToLocations();
		basins = findBasins(advancedLowPoints);
		
		
	}
	
	//Part 2--------------------------------------------------------------------
	
	private Basin largestBasin() {
		return null;
	}
	
	private ArrayList<Basin> findBasins(ArrayList<Location> lowPoints) {
		ArrayList<Basin> basins = new ArrayList<Basin>();
		//for each low point, create a new basin
		for (Location loc : lowPoints) {
			Basin b = new Basin(loc);
	
			boolean newAdjs = true;
			while (newAdjs) {
				newAdjs = basinSearch(b);
			}
		
			basins.add(b);
		}
		
		//start at the low point
			//store x and y positions
			//store adjacent numbers
		//if adjacent numbers are the same or one higher, add to basin
		//check adjacent numbers for each new number added to basin 
		//repeat until no new numbers are added to basin
		
		return basins;
		
	}
	
	private boolean basinSearch(Basin b) {
		boolean newAdjsFound = false;
		
		for (Location loc : b.getFlow() ) {
			int height = loc.getHeight();
			int up = loc.getUp();
			int down = loc.getDown();
			int left = loc.getLeft();
			int right = loc.getRight();
			
			if (up >= height) {
				newAdjsFound = true;
//				b.add(up)); //add up in the type of Location, not just the number
			}	
			
			if (down >= height) {
				newAdjsFound = true;
//				b.add(down)); //add down in the type of Location, not just the number
			}
			
			if (left >= height) {
				newAdjsFound = true;
//				b.add(left)); //add left in the type of Location, not just the number
			}
			
			if (right >= height) {
				newAdjsFound = true;
//				b.add(right)); //add down in the type of Location, not just the number
			}
			
			loc.searched();
		}
		return newAdjsFound;
	}
	
	private ArrayList<ArrayList<Location>> inputToLocations() {
		ArrayList<ArrayList<Location>> map = new ArrayList<ArrayList<Location>>();

		for (int i = 0; i < input.size(); i++) {
			//for each row
			ArrayList<Integer> currRow = input.get(i);
			ArrayList<Location> newRow = new ArrayList<Location>();
					
			for (int j = 0; j < currRow.size(); j++) {
				//for each number in a row
				
				int currNum = currRow.get(j);
				int up = -1, down = -1, left = -1, right = -1;
				
				if (i > 0) up = input.get(i-1).get(j);
				if (i < input.size()-1) down = input.get(i+1).get(j);
				if (j > 0) left = currRow.get(j-1);
				if (j < currRow.size()-1) right = currRow.get(j+1);
				
				Location currLoc = new Location(i, j, currNum, up, down, left, right);
				newRow.add(currLoc);
				
				ArrayList<Integer> adjs = new ArrayList<Integer>();
				if (up != -1) adjs.add(up);
				if (down != -1) adjs.add(down);
				if (left != -1) adjs.add(left);
				if (right != -1) adjs.add(right);
					
				if (isLowPoint(currNum, adjs)) {
					advancedLowPoints.add(currLoc);
					currLoc.setLowPoint();
				}
			}
			
			map.add(newRow);
		}
		
		return map;
	}
	
	//End of part 2--------------------------------------------------------------
	
	
	//Part 1---------------------------------------------------------------------
	
	public int getRiskLevel() {
		return riskLevel;
	}
	
	private int calcRiskLevel(ArrayList<Integer> lowPoints) {
		int sum = 0;
		for (Integer i : lowPoints) sum += i + 1;
		return sum;
	}
	
	private ArrayList<Integer> findLowPoints() {
		ArrayList<Integer> lowPoints = new ArrayList<Integer>();
		
		for (int i = 0; i < input.size(); i++) {
			//for each row
			ArrayList<Integer> currRow = input.get(i);
			
			for (int j = 0; j < currRow.size(); j++) {
				//for each number in a row
				Integer num = currRow.get(j);
				Integer up = -1, down = -1, left = -1, right = -1;
				
				if (i > 0) up = input.get(i-1).get(j);
				if (i < input.size()-1) down = input.get(i+1).get(j);
				if (j > 0) left = currRow.get(j-1);
				if (j < currRow.size()-1) right = currRow.get(j+1);
				
				ArrayList<Integer> adjs = new ArrayList<Integer>();
				if (up != -1) adjs.add(up);
				if (down != -1) adjs.add(down);
				if (left != -1) adjs.add(left);
				if (right != -1) adjs.add(right);
					
				if (isLowPoint(num, adjs)) lowPoints.add(num);
			}
		}
		
		return lowPoints;
	}
	
	private boolean isLowPoint(int current, ArrayList<Integer> adjs) {
		for (Integer adj : adjs) {
			if (current >= adj) return false;
		}
		return true;
	}
	
	//End of part 1------------------------------------------------------------
	
	//Helper functions---------------------------------------------------------
	public void printMap() {
		for (ArrayList<Integer> i : input) {
			for (Integer num : i) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}
	
	public void printAdvancedMap() {
		for (ArrayList<Location> row : advancedHeightMap) {
			for (Location loc : row) {
				loc.printIsLowPoint();
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
}
