package alg;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUI {
	
	private Grid map;
	private JFrame frame;
	private JButton[][] buttonGrid;
	
	public GUI(Grid map) {
		
		this.map = map;
		this.frame = new JFrame();
		this.frame.setLayout(new GridLayout(this.map.getGridWidth(), this.map.getGridHeight()));
		
		this.buttonGrid = new JButton[this.map.getGridWidth()][this.map.getGridHeight()];
		
		for(int i = 0; i<this.map.getGridWidth(); i++) {
			
			for(int j = 0; j<this.map.getGridHeight(); j++) {
				
				this.buttonGrid[i][j] = new JButton("("+i+","+j+")");
				this.buttonGrid[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						System.out.println(e.getActionCommand());
						
					}
					
				});
				this.frame.add(this.buttonGrid[i][j]);
				
			}
			
		}
		
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.pack();
		this.frame.setVisible(true);		
		
	}

}
