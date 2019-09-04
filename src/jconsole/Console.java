package jconsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Console implements ActionListener{
	private final JFrame frame;
	private final JTextArea output;
	private final JTextField input;
	
	public Console() {
		frame = new JFrame("Console");
		output = new JTextArea(30, 50);
		output.setEditable(false);
		output.setBorder(BorderFactory.createTitledBorder("output"));
		output.setBackground(Color.black);
		output.setForeground(Color.white);
		input = new JTextField();
		input.setBackground(Color.black);
		input.setForeground(Color.WHITE);
		input.setBorder(BorderFactory.createTitledBorder("input"));
		input.addActionListener(this);
		input.setEditable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(output, BorderLayout.NORTH);
		frame.add(input, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
	public void print(String str) {
		output.append(str+'\n');
	}
	
	public String input() {
		String inp;
		input.setEditable(true);
		input.setBackground(Color.gray);
		do {
			input.setBackground(Color.GRAY);
		} while(input.isEditable());
		input.setBackground(Color.black);
		inp = input.getText();
		input.setText("");
		output.append(inp+'\n');
		return inp;
	}
	
	public String input(String str) {
		output.append(str);
		return input();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (input.isEditable()) {
			input.setEditable(false);
		}
	}
}
