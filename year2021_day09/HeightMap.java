package year2021_day09;

import java.util.ArrayList;

import year2021_util.Printer;

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
		
		//part 2 incorrect answers: 490176
			//to low: 471653
			//to high: 1390620
	}
	
	//Part 2--------------------------------------------------------------------
	
	public int multiplyLargestBasins(int num) {
		int total = 1;
		ArrayList<Basin> copyOfBasins = basins;
		
		for (int i = 0; i < num; i++) {
			int index = findLargestBasin(copyOfBasins);
			total *= copyOfBasins.get(index).getSize();
//			System.out.println("size of basin at index " + index + " :" + copyOfBasins.get(index).getSize());
			copyOfBasins.remove(index);
		}
		
		return total;
	}
	
	private int findLargestBasin(ArrayList<Basin> basins) {
		int indexOfLargest = 0;
		for (int i = 0; i < basins.size(); i++) {
			if (basins.get(i).getSize() > basins.get(indexOfLargest).getSize()) {
				indexOfLargest = i;
			}
		}
		return indexOfLargest;
	}
	
	private ArrayList<Basin> findBasins(ArrayList<Location> lowPoints) {
		ArrayList<Basin> basins = new ArrayList<Basin>();
		//for each low point, create a new basin
		for (Location loc : lowPoints) {
			Basin b = new Basin();
			b.add(loc);
//			resetSearchedOnHeightMap();
			b = adjacentCheck(loc, b);
			
			basins.add(b);
		}
		return basins;
		
	}
	
	
	private Basin adjacentCheck(Location loc, Basin b) {
		
		if (loc.isSearched()) {
			return b;
		}
		//check up
		if ((loc.getUp() != 9) && (loc.getUp() == loc.getHeight()+1))
			adjacentCheck(advancedHeightMap.get(loc.getXPos()-1).get(loc.getYPos()),b);
		
		//check down
		if ((loc.getDown() != 9) && (loc.getDown() == loc.getHeight()+1))
			adjacentCheck(advancedHeightMap.get(loc.getXPos()+1).get(loc.getYPos()),b);
		
		//check left
		if ((loc.getLeft() != 9) && (loc.getLeft() == loc.getHeight()+1))
			adjacentCheck(advancedHeightMap.get(loc.getXPos()).get(loc.getYPos()-1),b);
		
		//check right
		if ((loc.getRight() != 9) && (loc.getRight() == loc.getHeight()+1)) {
			adjacentCheck(advancedHeightMap.get(loc.getXPos()).get(loc.getYPos()+1),b);
		}
		
		loc.searched();
		b.add(loc);
		return b;
	}
	
	private void resetSearchedOnHeightMap() {
		for (ArrayList<Location> ahm : advancedHeightMap) {
			for (Location loc : ahm) {
				loc.resetSearched();
			}
		}
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
	
	public void printBasinSizes() {
		for (int i = 0 ; i < basins.size(); i++) {
			System.out.println("Basin " + (i+1) + " size: " + basins.get(i).getSize());
		}
		
	}
	
}
