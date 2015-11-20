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
			
			Block block = this.blocks[destinationX][destinationY];
			invalid = block.isBlocker();

		}
		
		return invalid;
		
	}
	
	public Path findAPath(Player player, int startX, int startY, int targetX, int targetY) {
		
		//implement me!
		
		Path path = new Path();
		
		return path;
		
	}

}
