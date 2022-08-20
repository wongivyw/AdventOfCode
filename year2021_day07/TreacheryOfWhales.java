package year2021_day07;

import java.util.ArrayList;

public class TreacheryOfWhales {
	ArrayList<Integer> crabs;

	public TreacheryOfWhales(ArrayList<Integer> input) {
		crabs = input;
	}

	public int bestPosition() {
		int pos = 0;
		int min = min(crabs);
		int max = max(crabs);
		int lowestFuel = fuelUsed(min);
		for (int i = min; i <= max; i++) {
			int currFuel = fuelUsed(i);
			if (currFuel < lowestFuel) {
				pos = i;
				lowestFuel = currFuel;
			}
		}
		return pos;
	}
	public int fuelUsed(int pos) {
		int fuel = 0;
		for (int x : crabs) {
//			PART 1
//			fuel += Math.abs(pos-x);
			
//			PART 2
			int dist = Math.abs(pos-x);
			for (int i = 0; i <= dist; i++) {
				fuel += i;
			}
		}
		return fuel;
	}
	
	//helper functions
	private int min (ArrayList<Integer> input) {
		int lowest = input.get(0);
		for (Integer i : input) {
			if (i < lowest) lowest = i;
		}
		return lowest;
	}
	
	private int max (ArrayList<Integer> input) {
		int highest = input.get(0);
		for (Integer i : input) {
			if (i > highest) highest = i;
		}
		return highest;
	}
}
