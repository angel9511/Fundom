package view;

import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Console extends JTextPane {
	
	/**
	 * Defines a JTextPane where text can be displayed but not
	 *  edited, to work as a console
	 * @param name the name of the console
	 */
	public Console(String name) {
		setEditable(false);
		setBackground(Color.BLACK);
		setForeground(Color.white);
	}

}
