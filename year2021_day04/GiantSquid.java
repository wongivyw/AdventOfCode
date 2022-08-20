package year2021_day04;

import java.util.ArrayList;

import year2021_util.Printer;

public class GiantSquid {
	ArrayList<Integer> draws;
	ArrayList<Board> boards;
	int round = 0;
	int player = 0;
	int drawValue = 0;
	
	public GiantSquid(ArrayList<Integer> draws, ArrayList<Board> boards) {
		this.draws = draws;
		this.boards = boards;
	}
	
	public void printBoards() {
		Printer.arrayListBoard(boards);
	}
	
	public void printDraws() {
		Printer.arrayListInteger(draws);
	}
	
	public int finalScore() {
		Board winner = playGame(boards);
		if (winner != null) {
			return winner.computeScore(drawValue);
		}
		return -1;
	}

	private Board playGame(ArrayList<Board> boards) {
		for (Integer draw : draws) {
			for (Board b : boards) {
				b.markBoard(draw);
				if (b.winner()) {
					drawValue = draw;
					return b;
				}
			}
		}
		return null;
	}
	
	public int loserScore() {
		Board loser = loseGame();
//		System.out.println();
//		loser.print();
//		System.out.println();
		if (loser != null) {
			return loser.computeScore(drawValue);
		}
		return -1;
	}
	
	private Board loseGame() {
		ArrayList<Board> newBoards = boards;
		while (newBoards.size() > 1) {
			Board b = playGame(newBoards);
			newBoards.remove(b);
//			System.out.println("Number of boards left: " + newBoards.size());
		}
		if (newBoards.isEmpty()) return null;
		Board b = playGame(newBoards);
		return b;
//		return newBoards.get(0);
	}
}
