package alg;

import java.util.ArrayList;
import java.util.Collections;

public class FrontierQueue {
	
	private ArrayList<Block> frontier;
	
	public FrontierQueue() {
		
		this.frontier = new ArrayList<Block>();
		
	}
	
	public Block first() {
		
		return this.frontier.get(0);
		
	}
	
	public void clear() {
		
		this.frontier.clear();
		
	}
	
	public void add(Block block) {
		
		this.frontier.add(block);
		Collections.sort(this.frontier);
		
	}
	
	public void remove(Block block) {
		
		this.frontier.remove(block);
		
	}
	
	public int size() {
		
		return this.frontier.size();
		
	}
	
	public boolean contains(Block block) {
		
		return this.frontier.contains(block);
		
	}

}
