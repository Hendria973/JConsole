package jconsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Console implements KeyListener{
	private final JFrame frame;
	private final JPanel[][] cells = new JPanel[40][80];
	private Location cursor;
	private ArrayList<keyEvents> listeners = new ArrayList<keyEvents>();
	private boolean inEnabled = false;
	private boolean bufferAvailable = false;
	private CharBuffer inputBuffer = new CharBuffer();
	
	
	class CharBuffer {
		private char[] buffer;
		
		public CharBuffer() {
			buffer = new char[0];
		}
		
		public CharBuffer(char[] c) {
			buffer = c;
		}
		
		public int length() {
			return buffer.length;
		}
		
		public boolean isEmpty() {
			if (buffer.length == 0) {
				return true;
			}
			else
				return false;
		}
		
		public void add(char c) {
			char[] buff = new char[buffer.length+1];
			for (int i = 0; i<buffer.length; i++) {
				buff[i] = buffer[i];
			}
			buff[buff.length-1] = c;
			buffer = buff;
		}
		
		public void remove(int index) {
			CharBuffer buff = new CharBuffer();
			for (int i = 0; i<buffer.length;i++) {
				if (i == index) {
					continue;
				}
				else
					buff.add(buffer[i]);
			}
		}
		
		public char getChar(int index) {
			return buffer[index];
		}
		
		public String getString() {
			String str = "";
			for (char c : buffer) {
				str = str+c;
			}
			return str;
		}
	}
	
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
		frame.addKeyListener(this);
		for (int i = 0; i<36; i++) {
			for (int j = 0; j<80; j++) {
				cells[i][j] = new JPanel();
				cells[i][j].setBackground(Color.blue);
				cells[i][j].setPreferredSize(new Dimension(12, 22));
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
				cells[cursor.y][cursor.x].repaint();
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
	
	public void addListener(keyEvents o) {
		listeners.add(o);
	}
	
	public String input() {
		inEnabled = true;
		while (inEnabled) {
			System.out.println(inputBuffer.getString());
		}
		System.out.println("Done with string: " + inputBuffer.getString());
		return inputBuffer.getString();
	}
	
	private void notifyListeners(KeyEvent e, int type) {
		for (keyEvents listener : listeners) {
			if (type == 0) {
				listener.keyTyped(e);
			}
			else if (type == 1) {
				listener.keyPressed(e);
			}
			else if (type == 2) {
				listener.keyReleased(e);
			}
		}
	}
	
	public void keyTyped(KeyEvent e) {
		if (inEnabled) {
			if (bufferAvailable) {
				inputBuffer.add(e.getKeyChar());
				bufferAvailable = false;
			}
		}
		else 
			notifyListeners(e, 0);
	}
	public void keyPressed(KeyEvent e) {
		if (inEnabled) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				inEnabled = false;
			}
			else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
				inputBuffer.remove(inputBuffer.length()-1);
			}
			else
				bufferAvailable = true;
		}
		else
			notifyListeners(e, 1);
	}
	public void keyReleased(KeyEvent e) {
		notifyListeners(e, 2);
	}
}

interface keyEvents {
	public void keyTyped(KeyEvent e);
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
}
