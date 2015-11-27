package alg;

public class Block implements Comparable{
	
	private int xCoordinate;
	private int yCoordinate;
	private float wCost;
	private Block parent;
	private float heuristic;
	
	public Block(int x, int y) {
		
		this.xCoordinate = x;
		this.yCoordinate = y;
		
	}
	
	public void setParent(Block parentBlock) {
			
		this.parent = parentBlock;
	
	}
	
	public int getX() {
		
		return this.xCoordinate;
		
	}
	
	public int getY() {
		
		return this.yCoordinate;
		
	}

	//comparator method for priority queue
	public int compareTo(Object o) {

		Block otherBlock = (Block)o;
		
		float blockF = this.heuristic + this.wCost;
		float otherBlockF = otherBlock.heuristic + otherBlock.wCost;
		
		if(blockF < otherBlockF) {
			
			return -1;
		
		} else if (blockF > otherBlockF) {
			
			return 1;
		
		} else {
			
			return 0;
			
		}
		
	}
	
	public void setCost(float cost) {
		
		this.wCost = cost;
		
	}
	
	public float getCost() {
		
		return this.wCost;
		
	}
	
	public void setHeuristic(float heuristic) {
		
		this.heuristic = heuristic;
		
	}
	
	public Block getParent() {
		
		return this.parent;
		
	}

}
