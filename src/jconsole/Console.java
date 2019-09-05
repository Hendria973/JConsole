package jconsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Console implements KeyListener{
	private final JFrame frame;
	private final JPanel[][] cells = new JPanel[40][80];
	private Location cursor;
	
	class Location {
		public int x;
		public int y;
		public Location(int a, int b) {
			x = a;
			y = b;
		}
	}
	
	public Console() {
		cursor = new Location(0, 0);
		frame = new JFrame("JConsole");
		frame.setLayout(new GridLayout(36, 80));
		for (int i = 0; i<36; i++) {
			for (int j = 0; j<80; j++) {
				cells[i][j] = new JPanel();
				cells[i][j].setBackground(Color.blue);
				cells[i][j].setPreferredSize(new Dimension(9, 18));
				frame.add(cells[i][j]);
			}
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void print(String str) {
		char[] chars = str.toCharArray();
		for (char c : chars) {
			if (cells[cursor.y][cursor.x].getComponentCount() == 0) {
				cells[cursor.y][cursor.x].add(new JLabel(""+c));
			}
			else {
				cells[cursor.y][cursor.x].removeAll();
				cells[cursor.y][cursor.x].revalidate();
				cells[cursor.y][cursor.x].add(new JLabel(""+c));
			}
			cursor.x++;
			if (cursor.x >=80) {
				cursor.y++;
				cursor.x=0;
			}
		}
		cursor.x=0;
		cursor.y++;
	}
	
	public void printAt(String str, int x, int y) {
		cursor.x = x;
		cursor.y = y;
		print(str);
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		
	}
	public void keyReleased(KeyEvent e) {
		
	}
}
