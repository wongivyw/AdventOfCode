package day10;

import java.util.ArrayList;
import java.util.Stack;

public class Line {
	
	public static final String ROUND_OPEN_BRACKET = "(";
	public static final String SQUARE_OPEN_BRACKET = "[";
	public static final String CURLY_OPEN_BRACKET = "{";
	public static final String CORNER_OPEN_BRACKET = "<";

	public static final String ROUND_CLOSED_BRACKET = ")";
	public static final String SQUARE_CLOSED_BRACKET = "]";
	public static final String CURLY_CLOSED_BRACKET = "}";
	public static final String CORNER_CLOSED_BRACKET = ">";

	private boolean isIncomplete = false;
	private ArrayList<String> repairSequence;
	private boolean isCorrupted = false;
	Stack<String> stack;
	private String line = "";
	private int index;
	private String corruptedBracket;
	private int repairScore;
	
	public Line(String line, int index) {
		this.line = line;
		stack = new Stack<String>();
		corruptedBracket = "";
		repairSequence = new ArrayList<String>();
		isCorrupted = checkIfCorrupted();
		this.index = index;
		repairScore = calculateRepairScore();
	}
	
	public boolean isCorrupted() {
		return isCorrupted;
	}
	
	public String getLine() {
		return line;
	}
	
	public String getCorruptedBracket() {
		return corruptedBracket;
	}
	
	public boolean isIncomplete() {
		return isIncomplete;
	}
	
	public int getRepairScore() {
		return repairScore;
	}
	
	private boolean checkIfCorrupted() {
//		System.out.println(line);
		stack.push(Character.toString(line.charAt(0)));
		for (int i = 1; i < line.length(); i++) {
			String currBracket = Character.toString(line.charAt(i));
			
			if (isOpenBracket(currBracket)) {
				stack.push(currBracket);
//				System.out.println(i + "-- " + currBracket);
				
			} else if (isCLosedBracket(currBracket)){
				String openBracket = stack.pop();
				boolean isCorrectOpenBracket = doBracketsMatch(openBracket, currBracket);
//				System.out.println(i + "-- currBracket: " + currBracket + ", openBracket: " + openBracket);
//				System.out.println(i + "-- isCorrectOpenBracket: " + isCorrectOpenBracket);

				
				if (!isCorrectOpenBracket) {
					corruptedBracket = currBracket;
//					System.out.println();
					return true;
				}
			}
		}
		
		//PART 2
//		System.out.println("Line " + line + " is incomplete");
//		System.out.println("Number of remaining open brackets: " + stack.size() + "\n");
		while (!stack.isEmpty()) {
			isIncomplete = true;
			String openBracket = stack.pop();
			String repairBracket = findClosingBracket(openBracket);
//			System.out.println("closing repair bracket: " + repairBracket);
			repairSequence.add(repairBracket);

		}
		
//		System.out.println();
		return false;
	}
	
	private int calculateRepairScore() {
		int total = 0;
		for (String s : repairSequence) {
			int bracketScore = getRepairBracketScore(s);
			total *= 5;
			total += bracketScore;
		}
		return total;
	}
	
	private int getRepairBracketScore(String bracket) {
		if (bracket.equals(Line.ROUND_CLOSED_BRACKET)) return 1;
		if (bracket.equals(Line.SQUARE_CLOSED_BRACKET)) return 2;
		if (bracket.equals(Line.CURLY_CLOSED_BRACKET)) return 3;
		if (bracket.equals(Line.CORNER_CLOSED_BRACKET)) return 4;
		else return 0;
	}
	
	private boolean doBracketsMatch(String openBracket, String closedBracket) {
		if ((openBracket.equals(ROUND_OPEN_BRACKET) && closedBracket.equals(ROUND_CLOSED_BRACKET)) ||
			(openBracket.equals(SQUARE_OPEN_BRACKET) && closedBracket.equals(SQUARE_CLOSED_BRACKET)) ||
			(openBracket.equals(CURLY_OPEN_BRACKET) && closedBracket.equals(CURLY_CLOSED_BRACKET)) ||
			(openBracket.equals(CORNER_OPEN_BRACKET) && closedBracket.equals(CORNER_CLOSED_BRACKET))) {
			return true;
		}
		return false;
	}

	private boolean isOpenBracket(String currChar) {
		if (currChar.equals(ROUND_OPEN_BRACKET) || currChar.equals(SQUARE_OPEN_BRACKET) || 
				currChar.equals(CURLY_OPEN_BRACKET) || currChar.equals(CORNER_OPEN_BRACKET)) {
			return true;
		}
		return false;
	}
	
	private boolean isCLosedBracket(String currChar) {
		if (currChar.equals(ROUND_CLOSED_BRACKET) || currChar.equals(SQUARE_CLOSED_BRACKET) || 
				currChar.equals(CURLY_CLOSED_BRACKET) || currChar.equals(CORNER_CLOSED_BRACKET)) {
			return true;
		}
		return false;
	}
	
	private String findClosingBracket(String openBracket) {
		if (openBracket.equals(ROUND_OPEN_BRACKET)) return ROUND_CLOSED_BRACKET;
		else if (openBracket.equals(SQUARE_OPEN_BRACKET)) return SQUARE_CLOSED_BRACKET;
		else if (openBracket.equals(CURLY_OPEN_BRACKET)) return CURLY_CLOSED_BRACKET;
		else if (openBracket.equals(CORNER_OPEN_BRACKET)) return CORNER_CLOSED_BRACKET;
		else return "x";
	}
	

	
	
	
}
