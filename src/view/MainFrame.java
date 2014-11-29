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
		constraints = new GridBagConstraints();
		
		// Ubicacion Menu
		menuBar = new Menu();
		constraints.gridx = 0; 
		constraints.gridy = 0; 
		constraints.gridwidth = 3; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.0;
		constraints.weighty = 0.05;
		this.getContentPane().add (menuBar, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
				
		// Ubicacion EditordeTexto
		codeEditor = new Editor();
		codeEditor.setWrapStyleWord(true);
		codeEditor.setTabSize(4);
		codeEditor.setColumns(15);
		codeEditor.setRows(15);
		codeEditor.setLineWrap(true);
		menuBar.setCodeEditor(codeEditor);
		scrollpanel = new JScrollPane(codeEditor);
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
		mediaLibrary.revalidate();
		
	}
	
	public String getText()
	{
		return codeEditor.getText();
	}
	

	public void setText(String text) {
		codeEditor.setText(text);
	}
	
	public void moveImage(String name, int dx, int dy) {
		canvas.moveImage(name, dx, dy);
	}

	public void forceRepaint() {
		repaint();
		canvas.repaint();
	}

	public void setItemVisible(String name, boolean b) {
		// TODO Auto-generated method stub
		canvas.setItemVisible(name, b);
	}

	public void setConsoleMsm(String error) {
		// TODO Auto-generated method stub
		console.setText(error);
		console.repaint();
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
