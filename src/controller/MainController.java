package controller;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;

import view.MainFrame;

public class MainController {
	
	private String _tittle = "Fundom";
	public MainController() {
		// TODO Auto-generated constructor stub
		ventana = new MainFrame();
	}
	
	public void initGraphic(){
		ventana.setTitle(_tittle );
		ventana.setVisible(true);
		ventana.setBounds(0, 0, 800, 600);
		ventana.setExtendedState( Frame.MAXIMIZED_BOTH );
		ventana.setBackground(Color.WHITE);
		//ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static MainController getInstance() {
		
		if ( main == null ) {
			main = new MainController();
		}
		return main;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainController main = getInstance();
		main.initGraphic();

	}
	
	private MainFrame ventana;
	private static MainController main;

}
