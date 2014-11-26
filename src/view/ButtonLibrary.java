package view;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ButtonLibrary extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String , String> buttons = new HashMap<String, String>();
	BoxLayout by = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	public ButtonLibrary(Editor e) {
		setLayout(by);
		initMap();
		TextButton mover = new TextButton("Mover", buttons.get("mover"), e);
		TextButton tp = new TextButton("Teletransportar", buttons.get("tp"), e);
		TextButton esperar = new TextButton("Esperar", buttons.get("esperar"), e);
		TextButton ocultar = new TextButton("Ocultar", buttons.get("ocultar"), e);
		TextButton mostrar = new TextButton("Mostrar", buttons.get("mostrar"), e);
		
		add(mover);
		add(tp);
		add(esperar);
		add(ocultar);
		add(mostrar);
	}
	
	public void initMap(){
		buttons.put("mover", "\t \t_____ : mover \n"
				+ "\t \t \t direccion : ______ \n"
				+ "\t \t \t pasos : ______ \n"
				+ "\t \t \t tiempo : ____ segundos");
		buttons.put("tp", "\t \t_____ : tp \n"
				+ "\t \t \t direccion : ______ \n"
				+ "\t \t \t pasos : ______ \n");
		buttons.put("esperar", "\t \t_____ : esperar \n"
				+ "\t \t \t tiempo : ____ segundos \n");
		buttons.put("ocultar", "\t \t_____ : ocultar \n");
		buttons.put("mostrar", "\t \t_____ : mostrar \n");		
	}

}
