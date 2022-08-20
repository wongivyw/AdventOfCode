package year2021_day11;

import java.util.ArrayList;

public class DumboOctopus {
	
	// PART 1 FIELDS -------------------------------------------
	ArrayList<ArrayList<Integer>> input;
	ArrayList<ArrayList<Integer>> newInput;
	int totalSteps;
	int totalFlashes;
	
	// END PART 1 FIELDS ---------------------------------------

	public DumboOctopus(ArrayList<ArrayList<Integer>> input) {
		
		// PART 1 INITIALIZATIONS ------------------------------
		this.input = input;
		totalFlashes = 0;
		totalSteps = 100;
		newInput = simulateSteps(totalSteps);
		
		// END PART 1 INITIALIZATIONS --------------------------

	}
	
	// PART 1 FUNCTIONS ----------------------------------------
	public int getTotalFlashes() {
		return totalFlashes;
	}
	
	private ArrayList<ArrayList<Integer>> simulateSteps(int totalSteps) {
		ArrayList<ArrayList<Integer>> newInput = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < totalSteps; i++) {
			newInput = simulateOneStep();
		}
		return newInput;
	}
	
	private ArrayList<ArrayList<Integer>> simulateOneStep() {
		ArrayList<ArrayList<Integer>> newStep = new ArrayList<ArrayList<Integer>>();
		
		//simulate one step:
		// increase every octopus by 1
		// check for 9+ energy levels in entire board
		// for every 9+ octopus on the board, 
			// increase adjs by 1
			// for each adj, check for 9+ energy
		return newStep;
	}

	// END PART 1 FUNCTIONS ------------------------------------

	
	
	
	//helper print functions
	public void printInput() {
		for (ArrayList<Integer> arr : input) {
			for (int i : arr) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
