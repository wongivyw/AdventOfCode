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
	private boolean isCorrupted = false;
	Stack<String> stack;
	private String line = "";
	private int index;
	
	public Line(String line, int index) {
		this.line = line;
		stack = new Stack<String>();
		isCorrupted = checkIfCorrupted();
		this.index = index;
	}
	
	public boolean isCorrupted() {
		return isCorrupted;
	}
	
	public String getLine() {
		return line;
	}
	
	private boolean checkIfCorrupted() {
		stack.push(Character.toString(line.charAt(0)));
		for (int i = 1; i < line.length(); i++) {
			String currBracket = Character.toString(line.charAt(i));
			if (isOpenBracket(currBracket)) {
				stack.push(currBracket);
				System.out.println(index + ":" + currBracket);
			} else if (isCLosedBracket(currBracket)){
				String openBracket = stack.pop();
				boolean isCorrectOpenBracket = doBracketsMatch(openBracket, currBracket);
				if (!isCorrectOpenBracket) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean doBracketsMatch(String openBracket, String closedBracket) {
		if ((openBracket.equals(ROUND_OPEN_BRACKET) && closedBracket.equals(ROUND_CLOSED_BRACKET)) ||
			(openBracket.equals(ROUND_OPEN_BRACKET) && closedBracket.equals(ROUND_CLOSED_BRACKET)) ||
			(openBracket.equals(ROUND_OPEN_BRACKET) && closedBracket.equals(ROUND_CLOSED_BRACKET)) ||
			(openBracket.equals(ROUND_OPEN_BRACKET) && closedBracket.equals(ROUND_CLOSED_BRACKET))) {
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
	
	
	

	
	
	
}
