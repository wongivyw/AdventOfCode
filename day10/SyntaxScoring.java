package day10;

import java.util.ArrayList;

public class SyntaxScoring {
	ArrayList<Line> input;
	ArrayList<Line> corruptedLines;

	public SyntaxScoring(ArrayList<String> input) {
		this.input = new ArrayList<Line>();
		int index = 0;
		
		for (String i : input) {
			this.input.add(new Line(i,index));
			index++;
		}
		
		corruptedLines = findCorruptedLines();
		
	}
	
	//returns arraylist of Lines that are corrupted
	public ArrayList<Line> findCorruptedLines() {
		ArrayList<Line> corruptedLines = new ArrayList<Line>();
		
		for (Line l : input) {
			if (l.isCorrupted()) {
				corruptedLines.add(l);
			}
		}
		return corruptedLines;
	}
	
	//helper print functions
	public void printCorruptedLines() {
		System.out.println("Corrupted Lines:");
		for (Line cl : corruptedLines) {
			System.out.println(cl.getLine());
		}
	}
	
}
