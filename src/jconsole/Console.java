package jconsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Console implements ActionListener{
	private final JFrame frame;
	private final JPanel[][] cells = new JPanel[40][80];
	
	public Console() {
		frame = new JFrame("JConsole");
		frame.setLayout(new GridLayout(40, 80));
		for (int i = 0; i<40; i++) {
			for (int j = 0; j<80; j++) {
				cells[i][j] = new JPanel();
				cells[i][j].setBackground(Color.blue);
				cells[i][j].setPreferredSize(new Dimension(10, 10));
				frame.add(cells[i][j]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
