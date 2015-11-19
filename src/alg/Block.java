package alg;

public class Block implements Comparable{
	
	private int xCoordinate;
	private int yCoordinate;
	private int wCost;
	private Block parent;
	private float heuristic;
	private int depth;
	
	public Block(int x, int y) {
		
		this.xCoordinate = x;
		this.yCoordinate = y;
		
	}
	
	public void setParent(Block parentBlock) {
		
		this.parent = parentBlock;
		this.setDepth(parentBlock);
		
	}
	
	private void setDepth(Block parentBlock) {
		
		//depth is set using the parent
		this.depth = parentBlock.depth + 1;
		
	}
	
	public int getDepth() {
		
		return this.depth;
		
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

}
