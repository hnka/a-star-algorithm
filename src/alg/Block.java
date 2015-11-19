package alg;

public class Block {
	
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

}
