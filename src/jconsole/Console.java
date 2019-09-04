package jconsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Console {
	private final JFrame frame;
	private final JTextArea output;
	private final JTextField input;
	
	public Console() {
		frame = new JFrame("Console");
		output = new JTextArea("JConsole",24, 40);
		output.setEditable(false);
		output.setBorder(BorderFactory.createTitledBorder("output"));
		output.setBackground(Color.black);
		output.setForeground(Color.white);
		input = new JTextField();
		input.setBackground(Color.black);
		input.setForeground(Color.WHITE);
		input.setBorder(BorderFactory.createTitledBorder("input"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(output, BorderLayout.NORTH);
		frame.add(input, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
}
