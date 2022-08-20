package year2021_day09;

public class Location {
	private int xPos, yPos, height;
	private int up, down, left, right;
	private boolean isLowPoint = false;
	
	private boolean isSearched = false;

	public Location(int xPos, int yPos, int height, int up, int down, int left, int right) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.height = height;
		
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	
	public int getHeight() {return height;}
	
	public int getXPos() {return xPos;}
	public int getYPos() {return yPos;}
	
	public int getUp() {return up;}
	public int getDown() {return down;}
	public int getLeft() {return left;}
	public int getRight() {return right;}
	
	public void setLowPoint() {isLowPoint = true;}
	public boolean isLowPoint() {return isLowPoint;}
	
	public void searched() {isSearched = true;}
	public boolean isSearched() {return isSearched;}
	public void resetSearched() {isSearched = false;}
	
	
	//printer functions
	public void printHeight() {System.out.print(height);}
	public void printXPos() {System.out.print(xPos);}
	public void printYPos() {System.out.print(yPos);}
	public void printUp() {System.out.print(up);}
	public void printDown() {System.out.print(down);}
	public void printLeft() {System.out.print(left);}
	public void printRight() {System.out.print(right);}
	public void printIsLowPoint() {System.out.print(isLowPoint);}
}
