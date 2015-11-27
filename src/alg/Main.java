package alg;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//grid weight 0: uniform cost search
		//grid weight 1: A*
		//grid weight 2: greedy best search
		
		Grid map = new Grid(10,10,2);
		AStar a = new AStar(map);
		
		map.fillBlockers(4,4);	
		map.fillBlockers(6,6);
		
		Player one = new Player("Ceci");
		
		Path path = a.findAPath(one, 2, 2, 8, 8);
		
		if(path == null) {
			
			System.out.println("Path null");
			
		}
		
		ArrayList<Step> steps = path.getSteps();
		
		int[][] gridRep = new int[map.getGridWidth()][map.getGridHeight()];
		
		for(int j =0; j<map.getGridWidth(); j++) {
			
			for(int k =0; k<map.getGridHeight(); k++) {
				
				gridRep[j][k] = 0;
				
			}
			
		}
		
		for(int i=0; i<steps.size(); i++) {
			
			Step s = steps.get(i);
			System.out.println("Step "+i+": x = "+s.getXCoordinate());
			System.out.println("Step "+i+": y = "+s.getYCoordinate());
			System.out.println();
			
			gridRep[s.getXCoordinate()][s.getYCoordinate()] = 1;
			
		}
		
		for(int j =0; j<map.getGridWidth(); j++) {
			
			for(int k =0; k<map.getGridHeight(); k++) {
				
				System.out.print(gridRep[j][k] + " ");
				
			}
			
			System.out.println("");
			
		}
		

	}

}
