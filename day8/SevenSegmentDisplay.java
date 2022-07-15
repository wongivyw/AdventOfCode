package day8;

import java.util.ArrayList;
import java.util.Arrays;

public class SevenSegmentDisplay {
	ArrayList<String> keys, outputs;
	ArrayList<Key> decodedKeys;	
	String outputValue = "";
	
	public SevenSegmentDisplay(ArrayList<String> input) {
		keys = getKeys(input);
		outputs = getOutputs(input);
		decodedKeys = new ArrayList<Key>();
		decode();
	}

	public void print() {
//		String val = "";
//		System.out.println("KEYS:");
//		for (String ks : keys) {
//			System.out.print(" - " + ks + ": ");
//			for (Key dk : decodedKeys) {
//				if (dk.getKey().equals(ks))
//					System.out.print(dk.getVal());
//			}
//			System.out.println();
//		}
//		System.out.println();
//		System.out.println("OUTPUTS:");
		for (String os : outputs) {
			System.out.print(" " + os);
//			System.out.print(" - " + os + ": ");
			for (Key dk2 : decodedKeys) {
				if (compare(dk2.getKey(), os)) {
//					System.out.print(dk2.getVal());
					outputValue = outputValue.concat(Integer.toString(dk2.getVal()));
				}
			}
//			System.out.println();
		}
		System.out.println(" : " + outputValue);
//		System.out.println();
	}

//	function uses segments from key and turns them on/off depending on the output values
	public int getValue() {
		print();
		return Integer.parseInt(outputValue);
	}
	
	private void decode() {	
		//6 and 9, 2 and 5 are messed up *******************8
		char twoA = '.';
		char twoB = '.';
		char threeA = '.';
		char threeB = '.';
		char threeC = '.';
		for (String key : keys) {
			if (key.length() == 2) {
				decodedKeys.add(new Key(key, 1));
				twoA = key.charAt(0);
				twoB = key.charAt(1);
			}
			else if (key.length() == 3) decodedKeys.add(new Key(key, 7));
			else if (key.length() == 7) decodedKeys.add(new Key(key, 8));
			else if (key.length() == 4) decodedKeys.add(new Key(key, 4));
		}
		
		for (String key : keys) {
			if (key.length() == 5) {
				if ((key.indexOf(twoA) != -1) && (key.indexOf(twoB) != -1)) {
					decodedKeys.add(new Key(key, 3));
					threeA = key.charAt(0);
					threeB = key.charAt(1);
					threeC = key.charAt(2);
				}
				else if ((key.indexOf(twoA) != -1) && (key.indexOf(twoB) == -1))
					decodedKeys.add(new Key(key, 2));
				else if ((key.indexOf(twoA) == -1) && (key.indexOf(twoB) != -1))
					decodedKeys.add(new Key(key, 5));
			}
		}
		
		for (String key : keys) {
			if (key.length() == 6) {
				if ((key.indexOf(twoA) == -1) && (key.indexOf(twoB) != -1))
					decodedKeys.add(new Key(key, 6));
				else if ((key.indexOf(threeA) != -1) && (key.indexOf(threeB) != -1) && (key.indexOf(threeC) != -1))
					decodedKeys.add(new Key(key, 9));
				else {
					decodedKeys.add(new Key(key, 0));					
				}
			}
		}
		
//		decodedKeys.add(new Key("acedgfb", 8));
//		decodedKeys.add(new Key("cdfbe", 5)); //b and not a = 5
//		decodedKeys.add(new Key("gcdfa", 2)); //a and not b = 2
//		decodedKeys.add(new Key("fbcad", 3)); //ab = 3
//		decodedKeys.add(new Key("dab", 7));
//		decodedKeys.add(new Key("cefabd", 9)); //all of 3 = 9
//		decodedKeys.add(new Key("cdfgeb", 6)); //not a and b = 6
//		decodedKeys.add(new Key("eafb", 4));
//		decodedKeys.add(new Key("cagedb", 0));
//		decodedKeys.add(new Key("ab", 1));
	}
	
	private boolean compare(String s1, String s2) {
        char tempArray1[] = s1.toCharArray();
        Arrays.sort(tempArray1);
        String s1New = new String(tempArray1);
        
        char tempArray2[] = s2.toCharArray();
        Arrays.sort(tempArray2);
        String s2New = new String(tempArray2);
		
        if (s1.length() == s2.length() && s1New.equals(s2New)) {
			return true;
		}
		return false;
	}
	
	private ArrayList<String> getKeys(ArrayList<String> arr) {
		ArrayList<String> res = new ArrayList<String>();
		for (String s : arr) {
			if (s.equals("|")) break;
			else res.add(s);
		}
//		System.out.println("KEYS");
//		System.out.println(res);
		return res;
	}

	private ArrayList<String> getOutputs(ArrayList<String> arr) {
		ArrayList<String> res = new ArrayList<String>();
		boolean isOutputValue = false;
		for (String s : arr) {
			if (isOutputValue) res.add(s);
			if (s.equals("|")) isOutputValue = true;
		}
//		System.out.println("OUTPUTS");
//		System.out.println(res);
		return res;
	}
}
