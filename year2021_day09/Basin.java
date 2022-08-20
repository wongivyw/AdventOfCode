package year2021_day09;

import java.util.ArrayList;

public class Basin {
	ArrayList<Location> flow;

	public Basin() {
		flow = new ArrayList<Location>();
//		flow.add(l);
	}
	
	public void add(Location l) {
		flow.add(l);
	}
	
	public Location get(int index) {
		if ((index >= 0) && (index < flow.size())) return flow.get(index);
		return null;
	}
	
	public int getSize() {
		return flow.size();
	}
	
	public ArrayList<Location> getFlow() {
		return flow;
	}
}
