package year2021_util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import year2021_day04.Board;
import year2021_day05.KeyPair;

public class File {
	
	public static ArrayList<ArrayList<Integer>> openFileTo2DIntArrayList(String filename) throws IOException {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

	    FileReader fileReader = new FileReader(filename);
	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	      String line;
	      while((line = bufferedReader.readLine()) != null) {
	    	  ArrayList<Integer> subResult = new ArrayList<Integer>();
	    		for (int i = 0; i < line.length(); i++) {
	    			char number = line.charAt(i);
	    			subResult.add(Integer.parseInt(String.valueOf(number)));
	    		}
	    	  result.add(subResult);
	      }
	    }
	    return result;
	}
	
	public static ArrayList<ArrayList<String>> openFileToStringWithDelim(String filename) throws IOException {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    FileReader fileReader = new FileReader(filename);
	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
		    String line;
		    while((line = bufferedReader.readLine()) != null) {
		    	ArrayList<String> subResult = new ArrayList<String>();
		    	String[] numList = line.split(" ");
	    		for (int i = 0; i < numList.length; i++) {
	    			subResult.add(numList[i]);
	    		}
	    		result.add(subResult);
		    }
		}
	    
	    return result;
	}
	
	public static ArrayList<Integer> openCSVToInt(String filename) throws IOException {
		ArrayList<Integer> result = new ArrayList<Integer>();

	    FileReader fileReader = new FileReader(filename);
	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	      String line;
	      while((line = bufferedReader.readLine()) != null) {
	    	  String[] values = line.split(",");
	    	  for (int i = 0; i < values.length; i++) 
	    	  result.add(Integer.parseInt(values[i]));
	      }
	    }
	    return result;
	}
	
	public static ArrayList<Integer> openFileToInt(String filename) throws IOException {
		ArrayList<Integer> result = new ArrayList<Integer>();

	    FileReader fileReader = new FileReader(filename);
	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	      String line;
	      while((line = bufferedReader.readLine()) != null) {
	    	  result.add(Integer.parseInt(line));
	      }
	    }
	    return result;
	}
	
	public static ArrayList<String> openFileToString(String filename) throws IOException {
		ArrayList<String> result = new ArrayList<String>();

	    FileReader fileReader = new FileReader(filename);
	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	      String line;
	      while((line = bufferedReader.readLine()) != null) {
	    	  result.add(line);
	      }
	    }
	    return result;
	}
	
	
	public static ArrayList<Integer> openFileToDraws(String filename) throws IOException {
		String line = "";
		ArrayList<Integer> result = new ArrayList<Integer>();

	    FileReader fileReader = new FileReader(filename);
	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	    	line = bufferedReader.readLine();
	    }
	    
	    if (!line.equals("")) {
	    	String[] numList = line.split(",");
	    	for (int i = 0; i < numList.length; i++) {
	    		result.add(Integer.parseInt(numList[i]));
	    	}
	    }
	    return result;
	}
	
	public static ArrayList<Board> openFileToBoards(String filename) throws IOException {
		ArrayList<Board> result = new ArrayList<Board>();
		ArrayList<String> preResult = new ArrayList<String>();
		Board b = new Board();
		int row = 0;
		
	    FileReader fileReader = new FileReader(filename);
	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	      String line;
	      while((line = bufferedReader.readLine()) != null) {
	    	  preResult.add(line);
	      }
	    }
	    
	    for (int i = 0; i < preResult.size(); i++) {	
	    	String currLine = preResult.get(i);
	    	if (currLine.length() < ((Board.numCols*2) + Board.numCols) &&
	    			(currLine.length() > Board.numCols)) {
	    		// CASE 1: a line of a board
//	    		System.out.println("in board");
	    		b.addRow(currLine, row);
	    		row++;
	    	} else if (currLine.length() < Board.numCols) {
	    		// CASE 2: empty line
//	    		System.out.println();
	    		result.add(b);
	    		b = new Board();
	    		row = 0;
//	    	} else {
	    		// CASE 3: draw info
	    		//do nothing
//	    		System.out.println("draw info");

	    	}
	    }
	    return result;
	}
	
	public static ArrayList<KeyPair> openFileToPairs(String filename) throws IOException {
		ArrayList<KeyPair> result = new ArrayList<KeyPair>();
		ArrayList<String> preResult = new ArrayList<String>();
		
	    FileReader fileReader = new FileReader(filename);
	    try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
	      String line;
	      while((line = bufferedReader.readLine()) != null) {
	    	  preResult.add(line);
	      }
	    }
	    
	    for (String s : preResult) {
	    	// 0,9 -> 5,9
	    	ArrayList<Integer> values = new ArrayList<Integer>();
	    	String[] newS = s.split("->");
//	    	System.out.print("New string: ");
	    	
	    	for(int i = 0; i < newS.length; i++) {
	    		String xy = newS[i].trim(); //0,9
	    		String[] single = xy.split(",");
	    		values.add(Integer.parseInt(single[0]));
	    		values.add(Integer.parseInt(single[1]));
//	    		System.out.print(xy + "/");
	    		
	    	}
	    	result.add(new KeyPair(values.get(0), values.get(1), values.get(2), values.get(3)));
//	    	System.out.println();
	    	
	    }
	    return result;
	}
}
