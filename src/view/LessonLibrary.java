package view;

import javax.swing.JTextArea;

public class LessonLibrary extends JTextArea {
	
	public LessonLibrary() {
		super("Bienvenido a Fundom: \n "
				+ "El codigo tendra la estructura \n"
				+ "inicio \n "
				+ "\t elementos \n "
				+ "\t \t nombreimagen : insertar \n "
				+ "\t \t \t posicion : _ , _ \n"
				+ "\t \t ... \n"
				+ "\t animacion \n"
				+ "\t \t nombreimagen : accion \n"
				+ "\t \t ... \n"
				+ "FUN");
		setEditable(false);
		setTabSize(4);
	}

}
