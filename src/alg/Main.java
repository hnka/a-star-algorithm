package alg;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//grid weight 0: uniform cost search
		//grid weight 1: A*
		//grid weight 2: greedy best search
		
		Grid map = new Grid(10,10,1);
		
		map.fillBlockers(4,4);	
		map.fillBlockers(6,6);
		new GUI(map);

	}

}
