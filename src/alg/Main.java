package alg;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//grid weight 0: uniform cost search
		//grid weight 1: A*
		//grid weight 2: greedy best search
		
		Grid map = new Grid(10,10,1);
		AStar a = new AStar(map);
		
		map.fillBlockers(4,4);	
		map.fillBlockers(6,6);
		
		Player one = new Player("Ceci");
		
		Path path = a.findAPath(one, 2, 2, 8, 8);
		
		if(path == null) {
			
			System.out.println("Path null");
			
		}
		
		ArrayList<Step> steps = path.getSteps();
		
		for(int i=0; i<steps.size(); i++) {
			
			Step s = steps.get(i);
			System.out.println("Step "+i+": x = "+s.getXCoordinate());
			System.out.println("Step "+i+": y = "+s.getYCoordinate());
			System.out.println();
			
		}

	}

}
