package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * The Window, contains the subpanels Library, Menu, Console and Editor
	 */
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
	
	/**
	 * Returns the document that is edited by the user in the 
	 *  code editor
	 * @return the string
	 */
	public String getText()
	{
		return codeEditor.getText();
	}
	
	/**
	 * Makes the text in the codeEditor become a given text 
	 * @param text The text the text in the code editor will become
	 */
	public void setText(String text) {
		codeEditor.setText(text);
	}
	
	/**
	 * Moves a given image a given distance(Instantly) in the canvas
	 * @param name the name of the image that will be moved
	 * @param dx   the distance in x the image will be moved, can be negative
	 * @param dy   the distance in y the image will be moved, can be negative
	 */
	public void moveImage(String name, int dx, int dy) {
		canvas.moveImage(name, dx, dy);
	}

	/**
	 * Revalidates itself and repaints itself and the canvas
	 */
	public void forceRepaint() {
		revalidate();
		repaint();
		canvas.repaint();
	}

	/**
	 * A given image will become either visible or invisible
	 *  in the canvas
	 * @param name The name of the given image
	 * @param b    True if the image will become visible, false otherwise
	 */
	public void setItemVisible(String name, boolean b) {
		canvas.setItemVisible(name, b);
	}

	//TODO
	public void setConsoleMsm(String error) {
		try {
		      Document doc = console.getDocument();
		      doc.insertString(doc.getLength(), error, null);
		   } catch(BadLocationException exc) {
		      exc.printStackTrace();
		   }
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
