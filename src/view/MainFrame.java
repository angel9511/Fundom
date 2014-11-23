package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		this.getContentPane().setLayout (new GridBagLayout());
		// TODO Menu...igual se puede parametrizar acá
		JMenu menu = new JMenu("Menu");
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0; 
		constraints.gridy = 0; 
		constraints.gridwidth = 3; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 2.0;
		this.getContentPane().add (menu, constraints);
		constraints.weightx = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// TODO Area codigo personalizada, si es necesario
		JTextArea areaCodigo = new JTextArea("Area texto");
		constraints.gridx = 0; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.getContentPane().add (areaCodigo, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// TODO Canvas personalizado
		// JPanel canvas = new JPanel();
		JTextField canvas = new JTextField("Canvas");
		constraints.gridx = 1; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.getContentPane().add(canvas, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// TODO Consola ( no hay necesidad de personalizarla, se puede instanciar aqui)
		JTextField consola = new JTextField("Consola");
		consola.setEditable(false);
		constraints.gridx = 0; 
		constraints.gridy = 2; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 0.3;
		this.getContentPane().add(consola, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// TODO Biblioteca (no se que tipo de elemento, para relleno será un panel)
		// JPanel biblioteca = new JPanel();
		JTextField biblioteca = new JTextField("Biblioteca?");
		constraints.gridx = 2; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.getContentPane().add(biblioteca, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
	}

}
