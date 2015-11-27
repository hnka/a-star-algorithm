package alg;

import java.util.ArrayList;
import java.util.Collections;

public class AStar {
	
	private Grid grid;
	private Block[][] blocks;
	private Heuristic heuristic;
	
	private ArrayList searched;
	private FrontierQueue frontier;
	
	public AStar(Grid grid) {
		
		this.grid = grid;
		this.heuristic = new Heuristic();
		
		this.searched = new ArrayList();
		this.frontier = new FrontierQueue();
		
		//init blocks
		this.blocks = new Block[grid.getGridWidth()][grid.getGridHeight()];
		for (int i=0; i<grid.getGridWidth(); i++) {
			
			for (int j=0; j<grid.getGridHeight(); j++) {
				
				this.blocks[i][j] = new Block(i,j); 
				
			}
			
		}
		
	}
	
	private boolean isLocationValid(int originX, int originY, int destinationX, int destinationY) {
		
		boolean invalid = (destinationX < 0) || (destinationY < 0) || (destinationX >= this.grid.getGridWidth()) || (destinationY >= this.grid.getGridHeight());
		
		if((!invalid) && ((originX != destinationX) || (originY != destinationY))) {
			
			invalid = this.grid.blocked(destinationX, destinationY);
			
		}
		
		return !invalid;
		
	}
	
	public Path findAPath(Player player, int startX, int startY, int targetX, int targetY) {
		
		//see if the destination is not blocked
		if(this.grid.blocked(targetX, targetY)) {
			
			return null;
			
		}
		
		//cleaning variables
		this.blocks[startX][startY].setCost(0);
		this.frontier.clear();
		this.searched.clear();
		
		this.frontier.add(this.blocks[startX][startY]);
		
		this.blocks[startX][startY].setParent(null);
		
		//garantee that the frontier have at least one node
		while(this.frontier.size() != 0) {
			
			
			Block current = this.frontier.first();
			if(current == this.blocks[targetX][targetY]) {
				
				break;
			}
			
			this.frontier.remove(current);
			this.searched.add(current);
			
			for (int x=-1; x<2; x++) {
				
				for(int y=-1; y<2; y++) {
					
					if((x==0) && (y==0)) {
						
						continue;
						
					}
					
					int xPath = x+current.getX();
					int yPath = y+current.getY();
					
					if(this.isLocationValid(startX, startY, xPath, yPath)) {
						
						float nextStepCost = current.getCost() + this.grid.getCost(current.getX(), current.getY(), xPath, yPath);
						Block neighbour = this.blocks[xPath][yPath];
						this.grid.wereVisited(xPath, yPath);
						
						if(nextStepCost < neighbour.getCost()) {
							
							if(this.frontier.contains(neighbour)) {
								
								this.frontier.remove(neighbour);
								
							}
							
							if(this.searched.contains(neighbour)) {
								
								this.searched.remove(neighbour);
								
							}
							
						}
						
						if(!this.frontier.contains(neighbour) && !this.searched.contains(neighbour)) {
							
							neighbour.setCost(nextStepCost);
							neighbour.setHeuristic(this.heuristic.getCost(startX, startY, targetX, targetY));
							neighbour.setParent(current);
							this.frontier.add(neighbour);
							
						}
						
					}
					
				}
				
			}
			
		}
		
		if(this.blocks[targetX][targetY].getParent() == null) {
			
			return null;
			
		}
		
		Path path = new Path();
		Block target = this.blocks[targetX][targetY];
		
		while(target != this.blocks[startX][startY]) {
			
			path.prependStepToPath(new Step(target.getX(),target.getY()));
			target = target.getParent();
			
		}
		
		path.prependStepToPath(new Step(startX, startY));
		
		return path;
		
	}

}