package day8;

import java.util.ArrayList;

public class SevenSegmentSearch {
	ArrayList<ArrayList<String>> input;
	ArrayList<SevenSegmentDisplay> keys;

	public SevenSegmentSearch(ArrayList<ArrayList<String>> input) {
		this.input = input;
		keys = new ArrayList<SevenSegmentDisplay>();
		initializeKeys();
	}
	
	public int sum() {
		int count = 0;
		for (SevenSegmentDisplay ssd : keys) {
			count += ssd.getValue();
		}
		return count;
	}

//	function for PART 1
	public int uniqueSegments() {
		int count = 0;
		boolean output = false;
		for (ArrayList<String> subArr : input) { //each line
			for (String s : subArr) { //each segment
				if (s.equals("|")) output = true;
				if (output) {
					if (s.length() == 2 || s.length() == 3 || 
						s.length() == 4 || s.length() == 7) {
						count++;
					} //if
					else {						
					} //else
				} //if
			} //for			
			output = false;
		}
		return count;
	}
	
	private void initializeKeys() {
		for (ArrayList<String> subArr : input) {
			keys.add(new SevenSegmentDisplay(subArr));
		}
	}
}
