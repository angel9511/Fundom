package controller;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;

import view.MainFrame;

public class MainController {
	
	private String _tittle = "Fundom";
	public MainController() {
		// TODO Auto-generated constructor stub
		window = new MainFrame();
	}
	
	public void initGraphic(){
		window.setTitle(_tittle );
		window.setVisible(true);
		window.setBounds(0, 0, 800, 600);
		window.setExtendedState( Frame.MAXIMIZED_BOTH );
		window.setBackground(Color.WHITE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	
	private MainFrame window;
	private static MainController main;
}
