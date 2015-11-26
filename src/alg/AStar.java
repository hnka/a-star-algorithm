package alg;

import java.util.ArrayList;

public class AStar {
	
	private Grid grid;
	private Block[][] blocks;
	private Heuristic heuristic;
	
	private ArrayList searched;
	private FrontierQueue frontier;
	
	public AStar(Grid grid) {
		
		this.grid = grid;
		this.heuristic = new Heuristic();
		
		//init blocks
		this.blocks = new Block[grid.getGridWidth()][grid.getGridHeight()];
		for (int i=0; i<grid.getGridWidth(); i++) {
			
			for (int j=0; j<grid.getGridHeight(); j++) {
				
				this.blocks[i][j] = new Block(i,j); 
				
			}
			
		}
		
	}
	
	private boolean isLocationValid(int originX, int originY, int destinationX, int destinationY) {
		
		boolean invalid = false;
		
		if((destinationX < 0) || (destinationY<0) || (destinationX >= this.grid.getGridWidth()) || (destinationY >= this.grid.getGridHeight())) {
			
			invalid = true;
			
		}
		
		if((invalid == false) && ((originX != destinationX) || (originY != destinationY))) {
			
			invalid = this.grid.blocked(destinationX, destinationY);

		}
		
		return invalid;
		
	}
	
	public Path findAPath(Player player, int startX, int startY, int targetX, int targetY) {
		
		if(this.grid.blocked(targetX, targetY)) {
			
			return null;
			
		}
		
		this.blocks[startX][startY].setCost(0);
		this.frontier.clear();
		this.searched.clear();
		
		this.frontier.add(this.blocks[startX][startY]);
		this.blocks[startX][startY].setParent(null);
		
		while(this.frontier.size() != 0) {
			
			Block current = this.frontier.first();
			if(current == this.blocks[startX][startY]) {
				
				break;
			}
			
			this.frontier.remove(current);
			this.searched.add(current);
			
		}
		
		Path path = new Path();
		
		return path;
		
	}

}
