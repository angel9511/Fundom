package view;

import java.awt.Color;

import javax.swing.JTextField;

public class Console extends JTextField {
	
	public Console(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		setEditable(false);
		setBackground(Color.GRAY);
	}

}
