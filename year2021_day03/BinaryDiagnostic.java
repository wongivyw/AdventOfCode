package year2021_day03;

import java.util.ArrayList;

public class BinaryDiagnostic {
	//gamma rate = most common bit in the corresponding position
	//epsilon rate = least common bit in the corresponding position
	//power consumption = gamma rate x epsilon rate (in integers)
	
	//PART 1 FIELDS
	String gamma = "";
	String epsilon = "";
	int powerConsumption = 0;
	ArrayList<String> binaries;
	
	//PART 2 FIELDS
	ArrayList<String> masterValues, oxygenValues, co2Values;
	
	
	public BinaryDiagnostic(ArrayList<String> input) {
		binaries = input;
		computeInputs();
		
		masterValues = input;
		oxygenValues = input;
		co2Values = input;

	}
	
	private void computeInputs() {
		for (int index = 0; index < binaries.get(0).length(); index++) {
			int zeroCount = 0;
			int oneCount = 0;
			for (int i = 0; i < binaries.size(); i++) {
				char first = binaries.get(i).charAt(index);
				if (first == '0') zeroCount++;
				else {
					oneCount++;
				}
			} //inner for

			if (oneCount > zeroCount) {
				gamma += "1"; //max
				epsilon += "0"; //min
			}
			else {
				gamma += "0"; //max
				epsilon += "1"; //min

			}
		} //outer for
//		System.out.println("Gamma in binary: " + gamma);
//		System.out.println("Epsilon in binary: " + epsilon);
	}
	
	private int getDecimal(String binary){  		
	    int decimal = 0; 
	    int bitLength = binary.length();
	    
	    for (int i = 0; i < bitLength; i++) {
	    	char val = binary.charAt(i);
	    	
	    	int integerVal = Character.getNumericValue(val);
	    	decimal += integerVal * Math.pow(2, bitLength - i - 1);
	    }
	    return decimal;  
	} 
	
	
	public int getPowerConsumption() {
		int g = getDecimal(gamma);
		int e = getDecimal(epsilon);
//	    System.out.println("gamma in decimal: " + g);
//	    System.out.println("epsilon in decimal: " + e);
		powerConsumption = g*e;
		return powerConsumption;
	}
	
	//PART 2--------------------------------------------------------------

	/*
	 * repeat until one number is left:
	 * 
	 * bit criteria (first bit)
	 * 	o2:
	 * 		find most common value of first bit
	 * 		keep 1 if equally common
	 * 	co2:
	 * 		find least common value of first bit
	 * 		keep 0 if equally common
	 */
	
	public int getLifeSupportRating() {
		String o2 = getOxygenGeneratorRating();
		String co2 = getCo2ScrubberRating();
		return getDecimal(o2) * getDecimal(co2);
	}	
	
	private String getOxygenGeneratorRating() {
		int position = 0;
		int defaultValue = 1;
		ArrayList<String> subString = oxygenValues;
		
		while ((subString.size() != 1) && 
				(position < masterValues.get(0).length()) &&
				(position > -1)) {
			subString = filterForO2(subString, position, defaultValue);
//			print(subString);
			position++;

		}
		return subString.get(0);
	}
	
	private ArrayList<String> filterForO2(ArrayList<String> list, int bitPos, int keepValue) {
		ArrayList<String> res = new ArrayList<String>();
		assert(bitPos < list.get(0).length());
		assert(bitPos > 0);
		char mostCommon = findMostCommon(list, bitPos);
		
		for (int i = 0; i < list.size(); i++) {
			String curr = list.get(i);
			if (curr.charAt(bitPos) == mostCommon) {
				res.add(curr);
			}
		}
		return res;
	}
	
	private char findMostCommon(ArrayList<String> list, int pos) {
		//o2
		int zeroCount = 0;
		int oneCount = 0;
		for (int i = 0; i < list.size(); i++) {
			String num = list.get(i);
			if (num.charAt(pos) == '0') {
				zeroCount++;
			} else if (num.charAt(pos) == '1') {
				oneCount++;
			}
		} 
		if (oneCount == zeroCount) return '1';
		else if (oneCount > zeroCount) return '1';
		else { 
			return '0';
		}
	}
	
	
	
	
	//CO2 RATING METHODS
	private String getCo2ScrubberRating() {
		int position = 0;
		int defaultValue = 0;
		ArrayList<String> subString = co2Values;
		
		while ((subString.size() != 1) && 
				(position < masterValues.get(0).length()) &&
				(position > -1)) {
			subString = filterForCo2(subString, position, defaultValue);
//			print(subString);
			position++;

		}
		return subString.get(0);
	}

	private ArrayList<String> filterForCo2(ArrayList<String> list, int bitPos, int keepValue) {
		ArrayList<String> res = new ArrayList<String>();
		assert(bitPos < list.get(0).length());
		assert(bitPos > 0);
		char leastCommon = findLeastCommon(list, bitPos);
		
		for (int i = 0; i < list.size(); i++) {
			String curr = list.get(i);
			if (curr.charAt(bitPos) == leastCommon) {
				res.add(curr);
			}
		}
		return res;
	}
	
	private char findLeastCommon(ArrayList<String> list, int pos) {
		//o2
		int zeroCount = 0;
		int oneCount = 0;
		for (int i = 0; i < list.size(); i++) {
			String num = list.get(i);
			if (num.charAt(pos) == '0') {
				zeroCount++;
			} else if (num.charAt(pos) == '1') {
				oneCount++;
			}
		} 
		if (oneCount == zeroCount) return '0';
		else if (oneCount > zeroCount) return '0';
		else { 
			return '1';
		}
	}

	//HELPER FUNCTIONS
	public void print(ArrayList<String> list) {
		System.out.println("List items: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("    item " + i + ": " + list.get(i));
		}
	}
		
}
