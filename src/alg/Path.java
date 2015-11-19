package alg;

import java.util.ArrayList;

public class Path {
	
	//for now there is no need for a specific class 
	//for the steps on path
	
	private ArrayList<Block> blocks;
	
	public Path() {
		
		this.blocks = new ArrayList<Block>();
		
	}
	
	public int getLenght() {
		
		return this.blocks.size();	
		
	}
	
	public Block getBlockFromPath(int index) {
		
		Block block = this.blocks.get(index);
		return block;
		
	}
	
	public void appendBlockToPath(Block block) {
		
		this.blocks.add(block);
	
	}
	
	public boolean pathContainsBlock(Block block) {
		
		return this.blocks.contains(block);
		
	}

}
