package day4;

import java.util.ArrayList;

public class Draw {
	ArrayList<Integer> draws;

	public Draw(ArrayList<Integer> draws) {
		this.draws = draws;
	}
	
	public int drawNumber(int round) {
		if (round > draws.size()) return -1;
		return draws.get(round);
	}
}
