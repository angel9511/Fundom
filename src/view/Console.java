package view;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Console extends JTextPane {
	
	public Console(String name) {
		setEditable(false);
		setBackground(Color.BLACK);
		setForeground(Color.white);
	}

}
