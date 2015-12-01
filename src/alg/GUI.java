package alg;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {
	
	private Grid map;
	private JFrame frame;
	private JButton[][] buttonGrid;
	
	private boolean selected;
	
	private int initialX;
	private int initialY;
	
	private int targetX;
	private int targetY;
	
	private Color basic;
	
	ArrayList<Step> steps;
	
	public GUI(Grid map) {
		
		this.map = map;
		this.frame = new JFrame();
		
		this.initialX = 0;
		this.initialY = 0;
		
		this.targetX = 0;
		this.targetY = 0;
		
		this.steps = new ArrayList<Step>();
		
		JButton buttonBasic = new JButton();
		this.basic = buttonBasic.getBackground();
		
		this.selected = false;
		this.frame.setLayout(new GridLayout(this.map.getGridWidth(), this.map.getGridHeight()));
		
		this.buttonGrid = new JButton[this.map.getGridWidth()][this.map.getGridHeight()];
		
		for(int i = 0; i<this.map.getGridWidth(); i++) {
			
			for(int j = 0; j<this.map.getGridHeight(); j++) {
				
				this.buttonGrid[i][j] = new JButton(i+","+j);
				this.buttonGrid[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						buttonClicked(e);
						
					}
					
				});
				
				this.frame.add(this.buttonGrid[i][j]);
				
				if(this.map.blocked(i, j)) {
					
					this.buttonGrid[i][j].setBackground(Color.red);
					this.buttonGrid[i][j].setEnabled(false);
					
				}
				
			}
			
		}
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		this.frame.setVisible(true);		
		
	}
	
	public void buttonClicked(ActionEvent e) {
		
		if(selected == false) {
			
			this.buttonGrid[this.initialX][this.initialY].setBackground(this.basic);
			this.buttonGrid[this.targetX][this.targetY].setBackground(this.basic);
			
			for(int i=0; i<this.steps.size(); i++) {
				
				Step s = this.steps.get(i);
				this.buttonGrid[s.getXCoordinate()][s.getYCoordinate()].setBackground(this.basic);
				
			}
			
			String value = e.getActionCommand();
			String valueX = value.substring(0,1);
			String valueY = value.substring(2,3);
			
			this.initialX = Integer.parseInt(valueX);
			this.initialY = Integer.parseInt(valueY);
			
			this.buttonGrid[initialX][initialY].setBackground(Color.blue);
			
			this.selected = true;
			
		} else {
			
			String value = e.getActionCommand();
			String valueX = value.substring(0,1);
			String valueY = value.substring(2,3);
			
			this.targetX = Integer.parseInt(valueX);
			this.targetY = Integer.parseInt(valueY);
			
			this.buttonGrid[targetX][targetY].setBackground(Color.green);
			
			this.findPath();
			
			this.selected = false;
			
		}
		
		
	}
	
	public void findPath() {
		
		AStar a = new AStar(this.map);
		Player one = new Player("Ceci");
		
		Path path = a.findAPath(one, this.initialX, this.initialY, this.targetX, this.targetY);
		
		if(path == null) {
			
			System.out.println("Path null");
			
		}
		
		this.steps = path.getSteps();
		
		for(int i=0; i<this.steps.size(); i++) {
			
			Step s = this.steps.get(i);
			this.buttonGrid[s.getXCoordinate()][s.getYCoordinate()].setBackground(Color.black);
			
		}
		
	}

}
