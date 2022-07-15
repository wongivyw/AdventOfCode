package day2;

import java.util.ArrayList;

public class Dive {
	
	ArrayList<String> commands;
	int x = 0;
	int depth = 0;

	int x2 = 0;
	int depth2 = 0;
	int aim = 0;
	
	
	public Dive(ArrayList<String> commands) {
		this.commands = commands;
		processCommands();
		processCommandsWithAim();
	}
	
	private void processCommands() {
//		forward X increases the horizontal position by X units.
//		down X increases the depth by X units.
//		up X decreases the depth by X units.
		
		for (int i = 0; i < commands.size(); i++) {
			String[] command = commands.get(i).trim().split("\\s+");
			String direction = command[0];
			int value = Integer.parseInt(command[1]);

			switch (direction) {
			
			case "forward":
				x += value;
				break;
			
			case "down":
				depth += value;
				break;
				
			case "up":
				depth -= value;
				break;
				
			default:
				break;
			}
		}
	}
	
	private void processCommandsWithAim() {
//		down X increases your aim by X units.
//		up X decreases your aim by X units.
//		forward X does two things:
//			It increases your horizontal position by X units.
//			It increases your depth by your aim multiplied by X.
		
		for (int i = 0; i < commands.size(); i++) {
			String[] command = commands.get(i).trim().split("\\s+");
			String direction = command[0];
			int value = Integer.parseInt(command[1]);

			switch (direction) {
			
			case "forward":
				x2 += value;
				depth2 += aim*value;
				break;
			
			case "down":
				aim += value;
				break;
				
			case "up":
				aim -= value;
				break;
				
			default:
				break;
			}
		}
	}
	
	public int getX() {
		return x;
	}
	
	public int getDepth() {
		return depth;
	}
	
	public int getX2() {
		return x2;
	}
	
	public int getDepth2() {
		return depth2;
	}
	
//	public int getAim() {
//		return aim;
//	}
	
}
