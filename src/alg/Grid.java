package alg;

public class Grid {
	
	public int width;
	public int height;

	public Grid(int width, int height) {
		
		this.width = width;
		this.height = height;
		
	}
	
	public int getGridWidth() {
		
		return this.width;
		
	}
	
	public int getGridHeight() {
		
		return this.height;
		
	}
	
	public void visitedBlock(int x, int y) {
		
		//implement
		
	}
	
	public boolean wayBlocked(Player player, int x, int y) {
		
		//implement
		
		return false;
		
	}
	
	public float getCost(Player player, int originX, int originY, int destinationX, int destinationY) {
		float cost = 0;
		if((originX == destinationX) || (originY == destinationY)){
			cost = 1;
		} else {
			cost = (float) 1.4;
		}
		return cost;
		
	}
	
}
