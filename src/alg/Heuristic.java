package alg;

public class Heuristic {
	public static float getCost(int originX, int originY, int destinationX, int destinationY){
		int dx = destinationX - originX;
		int dy = destinationY - originY;
		return (float) Math.sqrt((dx*dx) + (dy*dy));
	};
}
