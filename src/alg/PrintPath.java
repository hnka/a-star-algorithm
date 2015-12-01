package alg;

import java.util.ArrayList;

public class PrintPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//grid weight 0: uniform cost search
		//grid weight 1: A*
		//grid weight 2: greedy best search

		System.out.println("I: posição inicial\n"
				+ "F: posição final\n"
				+ "X: obstáculo\n"
				+ "V: visitado\n"
				+ "-: caminho");
		
		Grid map = new Grid(10,10,1);
		AStar a = new AStar(map);

		map.fillBlockers(0,3);	
		map.fillBlockers(6,6);
		map.fillBlockers(2,4);
		map.fillBlockers(3,5);
		map.fillBlockers(5,4);
		map.fillBlockers(1,3);
		map.fillBlockers(2,3);
		map.fillBlockers(3,9);
		map.fillBlockers(8,8);
		
		int originX = 0;
		int originY = 1;
		int targetX = 9;
		int targetY = 9;

		Player one = new Player("Ceci");

		Path path = a.findAPath(one, originX, originY, targetX, targetY);

		if(path == null) {

			System.out.println("Path null");

		}

		ArrayList<Step> steps = path.getSteps();

		String[][] gridRep = new String[map.getGridWidth()][map.getGridHeight()];
		System.out.println();

		for(int j = 0; j<map.getGridWidth(); j++) {	
			for(int k = 0; k<map.getGridHeight(); k++) {
				if(map.isVisited(j, k)){
					gridRep[j][k] = "v";
				} else if(map.blocked(j, k)){
					gridRep[j][k] = "X";
				} else {
					gridRep[j][k] = "0";
				}
			}

		}
		
		for(int i=0; i<steps.size(); i++) {
			Step s = steps.get(i);
			//System.out.println("Step "+i+": x = "+s.getXCoordinate());
			//System.out.println("Step "+i+": y = "+s.getYCoordinate());
			//System.out.println();
			gridRep[s.getXCoordinate()][s.getYCoordinate()] = "-";

		}
		
		gridRep[originX][originY] = "I";
		gridRep[targetX][targetY] = "F";
		
		for(int j =0; j<map.getGridWidth(); j++) {	
			for(int k =0; k<map.getGridHeight(); k++) {
				System.out.print(gridRep[j][k] + " ");
			}
			System.out.println("");

		}

		System.out.println();
	}
}