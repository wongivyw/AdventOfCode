package util;

import java.util.ArrayList;

import day4.Board;

public class Printer {
	public static void arrayListInteger(ArrayList<Integer> list) {
		System.out.println("List items: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("    item " + i + ": " + list.get(i));
		}
	}
	
	public static void arrayListString(ArrayList<String> list) {
		System.out.println("List items: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("    item " + i + ": " + list.get(i));
		}
	}
	
	public static void arrayListBoard(ArrayList<Board> boards) {
		for (Board b : boards) {
			b.print();
			System.out.println();
		}
	}
}
