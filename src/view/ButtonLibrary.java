package view;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import model.GrammarMap;

import controller.MainController;

public class ButtonLibrary extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BoxLayout by = new BoxLayout(this, BoxLayout.Y_AXIS);
	
	public ButtonLibrary(Editor e) {
		setLayout(by);
		TextButton insertar = new TextButton("Insertar", GrammarMap.getGrammar().get("insertar"), e);
		TextButton mover = new TextButton("Mover", GrammarMap.getGrammar().get("mover"), e);
		TextButton tp = new TextButton("Teletransportar", GrammarMap.getGrammar().get("tp"), e);
		TextButton esperar = new TextButton("Esperar", GrammarMap.getGrammar().get("esperar"), e);
		TextButton ocultar = new TextButton("Ocultar", GrammarMap.getGrammar().get("ocultar"), e);
		TextButton mostrar = new TextButton("Mostrar", GrammarMap.getGrammar().get("mostrar"), e);
		
		add(insertar);
		add(mover);
		add(tp);
		add(esperar);
		add(ocultar);
		add(mostrar);
	}
	
}
