package day1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * 
 * By Ivy Wong, solution to Advent of Code - Day 1
 * */


public class SonarSweep {
	ArrayList<Integer> depths;
	int countIncrease = 0;
	
	public SonarSweep(ArrayList<Integer> input) {
		this.depths = input;
	}

	public int getResult() {
		countIncrease = 0;
		
		for (int i = 0; i < depths.size(); i++) {
			if (i>0) {
				if (depths.get(i) > depths.get(i-1)) {
					countIncrease++;
				}
			}
		}
		return countIncrease;
	}
	
	public int getThreeSumResult() {
		countIncrease = 0;
		
		for (int i = 0; i < depths.size() - 3; i++) {
//			   A
//				A	B	== size - 3
//				 A	 B 	== size - 2
//				 	  B == size - 1
			
			int sumA = depths.get(i) + depths.get(i+1) + depths.get(i+2);
			int sumB = depths.get(i+1) + depths.get(i+2) + depths.get(i+3);
			if (sumA < sumB) {
				countIncrease++;
			}
		}
		return countIncrease;
	}
}
// =======================================================//