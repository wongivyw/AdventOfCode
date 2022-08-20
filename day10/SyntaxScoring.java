package day10;

import java.util.ArrayList;
import java.util.Comparator;

public class SyntaxScoring {
	// PART 1 FIELDS ---------------------------
	ArrayList<Line> input;
	ArrayList<Line> corruptedLines;
	private int syntaxError = 0;
	// END PART 1 FIELDS -----------------------
	
	
	//PART 2 FIELDS ----------------------------
	ArrayList<Line> incompleteLines;
	ArrayList<Integer> repairScores;
	int totalRepairSequencesScore;
	int medianRepairSequencesScore;
	//END PART 2 FIELDS ------------------------
	

	public SyntaxScoring(ArrayList<String> input) {
		//PART 1 INITIALIZATIONS --------------------------------------------
		this.input = new ArrayList<Line>();
		int index = 0;
		
		for (String i : input) {
			this.input.add(new Line(i,index));
			index++;
		}
		corruptedLines = findCorruptedLines();
		syntaxError = calculateSyntaxError();
		// END PART 1 INITIALIZATIONS -----------------------------------------
		
		
		// PART 2 INITIALIZATIONS ---------------------------------------------
		incompleteLines = findIncompleteLines();
		repairScores = getRepairScores();
		totalRepairSequencesScore = calculateTotalRepairScores();
		medianRepairSequencesScore = getMedianOfRepairScores();
		
		//WRONG ANSWERS: 202784119 (low)
		//				227062182 (low)
		
		//END PART 2 INITIALIZATIONS --------------------------s----------------
		
		
		
	}
	
	// PART 1 FUNCTIONS--------------------------------------------------------
	//returns arraylist of Lines that are corrupted
	private ArrayList<Line> findCorruptedLines() {
		ArrayList<Line> corruptedLines = new ArrayList<Line>();
		
		for (Line l : input) {
			if (l.isCorrupted()) {
				corruptedLines.add(l);
			}
		}
		return corruptedLines;
	}
	
	private int calculateSyntaxError() {
		int e = 0;
		for (Line cl : corruptedLines) {
			String bracket = cl.getCorruptedBracket();
			e += getSyntaxError(bracket);
		}
		return e;
	}
	
	private int getSyntaxError(String bracket) {
		if (bracket.equals(Line.ROUND_CLOSED_BRACKET)) return 3;
		else if (bracket.equals(Line.SQUARE_CLOSED_BRACKET)) return 57;
		else if (bracket.equals(Line.CURLY_CLOSED_BRACKET)) return 1197;
		else if (bracket.equals(Line.CORNER_CLOSED_BRACKET)) return 25137;
		else return 0;
	}
	// END PART 1 --------------------------------------------------------------
	
	
	// PART 2 FUNCTIONS --------------------------------------------------------
	private ArrayList<Line> findIncompleteLines() {
		ArrayList<Line> incomplete = new ArrayList<Line>();	
		for (Line l : input) {
			if (!l.isCorrupted()) {
				incomplete.add(l);
			}
		}
		return incomplete;
	}
	
	private ArrayList<Integer> getRepairScores() {
		ArrayList<Integer> rs = new ArrayList<Integer>();
		for (Line l : incompleteLines) {
			rs.add(l.getRepairScore());
		}
		return rs;
	}
	
	
	
	private int getMedianOfRepairScores() {
		for (int i = 0; i < repairScores.size(); i++) {
			int absScore = Math.abs(repairScores.get(i));
			repairScores.set(i, absScore);
		}
		repairScores.sort(Comparator.naturalOrder());
		printRepairScores();
		int size = repairScores.size();
		int med = repairScores.get(size/2);
		return med;
	}
	
	private int calculateTotalRepairScores() {
		int scores = 0;	
		for (int s : repairScores) {
			scores += s;
		}
		return scores;

	}
	
	
	// END PART 2 FUNCTONS -----------------------------------------------------
	
	
	//helper print functions===============================================================================
	public void printCorruptedLines() {
		System.out.println("Corrupted Lines:");
		for (Line cl : corruptedLines) {
			System.out.println(cl.getLine());			
		}
	}
	
	public void printCorruptedBrackets() {
		System.out.println("Corrupted Brackets:");
		for (Line cl : corruptedLines) {
			System.out.println(cl.getCorruptedBracket());
		}
	}
	
	public void printTotalSyntaxError() {
		System.out.println("Total syntax error: " + syntaxError);
	}
	
	public void printIncompleteLines() {
		System.out.println("Incomplete Lines:");
		for (Line il : incompleteLines) {
			System.out.println(il.getLine());			
		}
	}
	
	public void printTotalRepairSequencesScore() {
		System.out.println("Total Repair Sequences Score: " + totalRepairSequencesScore);
	}
	
	public void printMedianRepairSequencesScore() {
		System.out.println("Median Repair Sequences Score: " + medianRepairSequencesScore);
	}
	
	private void printRepairScores() {
		System.out.println("Repair Scores: ");
		
		for (int score : repairScores) {
			System.out.print(score + ", ");
		}
		System.out.println();
	}
	
}
