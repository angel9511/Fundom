package view;

import javax.swing.JTextArea;

public class Editor extends JTextArea {
	
	public Editor() {
		// TODO Auto-generated constructor stub
		super(schema);
	}
	
	static String schema = "inicio : \n"
			+ "\t elementos \n"
			+ "\n"
			+ "\t animacion \n"
			+ "\n"
			+ "FUN";

}
