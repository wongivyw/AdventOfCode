package day6;

import java.util.ArrayList;

public class Lanternfish {
	ArrayList<Integer> lanternfishes;

	public Lanternfish(ArrayList<Integer> input) {
		lanternfishes = input;
 	}
	
/*	PART 2
 * 	- RECURSION?
 * 	unsuccessful tries:
 * 	36984457839
 * 	235218915941
 *  2147483647
 * 	9223372036854775807
 * 	ANSWER: 1639643057051 *
 * 	SOLUTION: 
 * 		1. X[n] stores how many spawns there are on nth day
 * 		2. Sum up the X[n] values.
 */
	
	public long getUnlimitedGrowthPopulation(int initialPop, int rate, int days) {
		return (long)(300*(java.lang.Math.exp(rate*days)));
	}
	
	public int getPopulation(int days) {
//		printInitialValues();		
		for (int i = 0; i < days; i++) {
//			System.out.print("After " + (i+1) + " days: ");			
			lanternfishes = simulateOneDay(lanternfishes);
//			printTimers(lanternfishes);
			if (i < days-1)	lanternfishes = spawn(lanternfishes);
		}
		return lanternfishes.size();
	}
	
	private void printTimers(ArrayList<Integer> fishes) {
		for (int j = 0; j < fishes.size(); j++) {
			int fish = fishes.get(j);
			System.out.print(" " + fish);
		}
		System.out.println();
	}
	
	private ArrayList<Integer> simulateOneDay(ArrayList<Integer> fishes) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int j = 0; j < fishes.size(); j++) {
			int fish = fishes.get(j);
			if (fish <= 0) result.add(6);
			else result.add(fish-1);
		}
		return result;
	}
	
	private void printInitialValues() {
		//initial state print statement
		System.out.print("Initial state: " + lanternfishes.get(0));
		for (int i = 1; i < lanternfishes.size(); i++) {
			System.out.print("," + lanternfishes.get(i));
		}
		System.out.println();
	}
	
	private ArrayList<Integer> spawn(ArrayList<Integer> currFishes) {
		//check for new spawns
		int spawncount = 0;
		for (int lf : currFishes) {
			if (lf <= 0) spawncount++;
		}
		for (int k = 0; k < spawncount; k++) {
			currFishes.add(9);
		}
		return currFishes;
	}
	
}
