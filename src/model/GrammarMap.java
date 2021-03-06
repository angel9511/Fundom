package model;

import java.util.HashMap;
import java.util.Map;

public abstract class GrammarMap {

	/**
	 * Create and return a dictionary of strings. This dictionary has the
	 * code to insert when the given button is pressed.
	 * @return
	 */
	public static Map<String, String> getGrammar(){
		Map<String , String> buttons = new HashMap<String, String>();
		buttons.put("insertar", "\t \t _____ : insertar \n"
				+ "\t \t \t posicion : __,__");
		buttons.put("mover", "\t \t_____ : mover \n"
				+ "\t \t \t direccion : ______ \n"
				+ "\t \t \t pasos : ______ \n"
				+ "\t \t \t tiempo : ____ segundos \n");
		buttons.put("tp", "\t \t_____ : tp \n"
				+ "\t \t \t direccion : ______ \n"
				+ "\t \t \t pasos : ______ \n");
		buttons.put("esperar", "\t \t_____ : esperar \n"
				+ "\t \t \t tiempo : ____ segundos \n");
		buttons.put("ocultar", "\t \t_____ : ocultar \n");
		buttons.put("mostrar", "\t \t_____ : mostrar \n");
		return buttons;		
	}
	
}
