import java.util.ArrayList;

import day1.SonarSweep;
import day2.Dive;
import day3.BinaryDiagnostic;
import day4.Board;
import day4.GiantSquid;
import day5.HydrothermalVenture;
import day5.KeyPair;
import day6.Lanternfish;
import day7.TreacheryOfWhales;
import day8.SevenSegmentSearch;
import day9.HeightMap;
import util.File;
import util.Printer;

public class AdventOfCodeMain {
	public static void day1() throws Exception{
    	//-----Day 1--------------------------------------------
    	ArrayList<Integer> input = File.openFileToInt("day1/day1_input.txt");
    	SonarSweep ss = new SonarSweep(input);
 
    	System.out.println("*** Day 1 ***");
    	System.out.println("Number of depth measurement increases: " + ss.getResult());
    	System.out.println("Number of three-sum depth measurement increases: " + ss.getThreeSumResult());
    	System.out.println();
	}
	public static void day2() throws Exception{
    	//-----Day 2--------------------------------------------
    	ArrayList<String> input2 = File.openFileToString("day2/input.txt");
    	Dive d = new Dive(input2);

    	System.out.println("*** Day 2 ***");
    	System.out.println("Total depth x total horizontal position: " + d.getX()*d.getDepth());
    	System.out.println("Total second depth x total second horizontal position: " + d.getX2()*d.getDepth2());
    	System.out.println();
	}
	public static void day3() throws Exception{
    	//-----Day 3--------------------------------------------
    	ArrayList<String> input3 = File.openFileToString("day3/input.txt");
    	BinaryDiagnostic bd = new BinaryDiagnostic(input3);
    	
    	System.out.println("*** Day 3 ***");
    	System.out.println("Power consumption: " + bd.getPowerConsumption());
    	System.out.println("Life Suppport Rating: " + bd.getLifeSupportRating());
    	System.out.println();
	}
	public static void day4() throws Exception{
    	//-----Day 4--------------------------------------------
    	ArrayList<Integer> input4Int = File.openFileToDraws("day4/input.txt");
    	ArrayList<Board> boards = File.openFileToBoards("day4/input.txt");
    	GiantSquid squid = new GiantSquid(input4Int, boards);
   
    	System.out.println("*** Day 4 ***");
    	System.out.println("Final Score: " + squid.finalScore());
    	System.out.println("Loser's final Score: " + squid.loserScore());
    	System.out.println();
	}
	public static void day5() throws Exception{
    	//-----Day 5--------------------------------------------
    	ArrayList<KeyPair> input5Int = File.openFileToPairs("day5/input.txt");
    	HydrothermalVenture hv = new HydrothermalVenture(input5Int, 1000, 1000);
    	System.out.println("*** Day 5 ***");
    	System.out.println("Danger zones: " + hv.dangerZones());
    	System.out.println();
	}
	public static void day6() throws Exception{
    	ArrayList<Integer> input6 = File.openCSVToInt("day6/input.txt");
    	Lanternfish lf = new Lanternfish(input6);
    	int days = 256;
    	System.out.println("*** Day 6 ***");
    	long infiniteGrowthPop = lf.getUnlimitedGrowthPopulation(300, 7, 256);
    	System.out.println("Population size after " + days + " days: " + infiniteGrowthPop + " lanternfishes");
	}
	public static void day7() throws Exception{
    	ArrayList<Integer> input7 = File.openCSVToInt("day7/input.txt");
    	TreacheryOfWhales w = new TreacheryOfWhales(input7);
    	System.out.println("*** Day 7 ***");
    	int pos = w.bestPosition();
    	System.out.println("Best position is " + pos + ", using " + w.fuelUsed(pos) + " fuel");
	}
	public static void day8() throws Exception{
		ArrayList<ArrayList<String>> input8 = File.openFileToStringWithDelim("day8/input_test.txt");
    	SevenSegmentSearch sss = new SevenSegmentSearch(input8);
    	System.out.println("*** Day 8 ***");
//    	System.out.println("Digits 1, 4, 7, or 8 appears " + sss.uniqueSegments() + " times");
    	System.out.println("Sum of output values: " + sss.sum());
	}

	public static void day9() throws Exception{
		ArrayList<ArrayList<Integer>> input9 = File.openFileTo2DIntArrayList("day9/input_test.txt");
    	HeightMap hm = new HeightMap(input9);
    	System.out.println("*** Day 9 ***");
//    	System.out.println("Risk Level: " + hm.getRiskLevel()); //part 1
    	hm.printAdvancedMap();
	}
	
    public static void main(String[] args) throws Exception {
//    	day1();
//    	day2();
//    	day3();
//    	day4();
//    	day5();  
//    	day6(); //part 2 incomplete
//    	day7();
//    	day8(); //part 2 incomplete
    	day9();
    }
}
