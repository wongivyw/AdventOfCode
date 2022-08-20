package year2021_day04;

import java.util.ArrayList;

public class Board {
	public static int numCols = 5;
	public static int numRows = 5;
	public static int markedValue = -2;

	int[][] board;
//  int[][] arr = { { 1, 2 }, { 3, 4 } };
//	row1 col0 = x[1][0]
//	row0 col1 = x[0][1]

	public Board() {
		this.board = new int[5][5];
	}
	
	public void addRow(String line, int row) {
		String[] values = line.trim().split("\\s+");
//		System.out.print("Row " + row + ": ");
		for (int i = 0; i < values.length; i++) {
			board[row][i] = Integer.parseInt(values[i]);
//			System.out.print(values[i] + ",");
		}
//		System.out.println();		
	}
	
	public void print() {
		System.out.println("BOARD:");
		for (int i = 0; i < Board.numRows; i++) {
			for (int j = 0; j < Board.numCols; j++) {
				System.out.print(board[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	public void markBoard(int drawValue) {
		for (int i = 0; i < Board.numRows; i++) {
			for (int j = 0; j < Board.numCols; j++) {
				if (board[i][j] == drawValue) {
					board[i][j] = markedValue;
//					System.out.println("marked: " + drawValue);
				}
			}
		}
	}
	
	public boolean winner() {
//		boolean winner = false;
		int markCount = 0;
		//check rows
		for (int i = 0; i < Board.numRows; i++) {
			for (int j = 0; j < Board.numCols; j++) {
				if (board[i][j] == Board.markedValue) markCount++;;
			}
			if (markCount == Board.numCols) return true;
			markCount = 0;
		}
		//check cols
		for (int j = 0; j < Board.numCols; j++) {
			for (int i = 0; i < Board.numRows; i++) {
				if (board[i][j] == Board.markedValue) markCount++;;
			}
			if (markCount == Board.numRows) return true;
			markCount = 0;
		}
		return false;
	}
	
	public int computeScore(int drawValue) {
		int score = 0;
		for (int j = 0; j < Board.numCols; j++) {
			for (int i = 0; i < Board.numRows; i++) {
				int val = board[i][j];
				if (val != Board.markedValue) score += val;
			}
		}
		return score * drawValue;
	}
}
