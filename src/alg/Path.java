package alg;

import java.util.ArrayList;

public class Path {
	
	private ArrayList<Step> steps;
	
	public Path() {
		
		this.steps = new ArrayList<Step>();
		
	}
	
	public int getLenght() {
		
		return this.steps.size();	
		
	}
	
	public Step getStepFromPath(int index) {
		
		Step step = this.steps.get(index);
		return step;
		
	}
	
	public void appendStepToPath(Step step) {
		
		this.steps.add(step);
	
	}
	
	public boolean pathContainsStep(Step step) {
		
		return this.steps.contains(step);
		
	}

}
