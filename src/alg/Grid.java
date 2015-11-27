package alg;

public class Grid {
	
	private int width;
	private int height;
	
	private int weight;
	
	private boolean[][] blockers;
	private boolean[][] visited;

	public Grid(int width, int height, int weight) {
		
		this.width = width;
		this.height = height;
		
		this.weight = weight;
		
		this.blockers = new boolean[width][height];
		this.visited = new boolean[width][height];
		
	}
	
	public int getWeight() {
		
		return this.weight;
		
	}
	
	public void fillBlockers(int x, int y) {
		
		this.blockers[x][y] = true;
		
	}
	
	public void clearVisited() {
		
		for(int x=0; x<this.getGridWidth(); x++) {
			
			for(int y=0; y<this.getGridHeight(); y++){
				
				this.visited[x][y] = false;
				
			}
			
		}

	}
	
	public int getGridWidth() {
		
		return this.width;
		
	}
	
	public int getGridHeight() {
		
		return this.height;
		
	}
	
	public float getCost(int originX, int originY, int destinationX, int destinationY) {
		float cost = 0;
		if((originX == destinationX) || (originY == destinationY)){
			cost = 1;
		} else {
			cost = (float) 1.4;
		}
		return cost;
		
	}
	
	public boolean blocked(int x, int y) {
		
		if(this.blockers[x][y] == true) {
			
			return true;
			
		} else {
			
			return false;
			
		}
		
	}
	
	public void wereVisited(int x, int y) {
		
		this.visited[x][y] = true;
		
	}
	
}
