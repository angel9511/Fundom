package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class MainFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MainFrame() {
		this.getContentPane().setLayout (new GridBagLayout());
		// Ubicacion Menu
		menuBar = new Menu();
		constraints = new GridBagConstraints();
		constraints.gridx = 0; 
		constraints.gridy = 0; 
		constraints.gridwidth = 3; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.weightx = 2.0;
		this.getContentPane().add (menuBar, constraints);
		constraints.weightx = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// Ubicacion EditordeTexto
		codeEditor = new Editor();
		menuBar.setCodeEditor(codeEditor);
		scrollpanel = new JScrollPane(codeEditor);
		codeEditor.setWrapStyleWord(true);
		constraints.gridx = 0; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.getContentPane().add (scrollpanel, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// Ubicacion Canvas
		canvas = new Canvas();
		constraints.gridx = 1; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 2.2;
		constraints.weighty = 1.0;
		this.getContentPane().add(canvas, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// Ubicacion consola
		console = new Console("Consola");
		scrollconsole = new JScrollPane(console);
		constraints.gridx = 0; 
		constraints.gridy = 2; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 0.3;
		this.getContentPane().add(scrollconsole, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// Ubicacion Library
		mediaLibrary = new Library(codeEditor);
		constraints.gridx = 2; 
		constraints.gridy = 1; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 2;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 1.0;
		this.getContentPane().add(mediaLibrary, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
	}
	
	private JScrollPane scrollpanel;
	private JScrollPane scrollconsole;
	private Menu menuBar;
	private Library mediaLibrary;
	private Console console;
	private Canvas canvas;
	private GridBagConstraints constraints;
	private Editor codeEditor;
}
