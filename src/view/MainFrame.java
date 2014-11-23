package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class MainFrame extends JFrame{
	
	public MainFrame() {
		this.getContentPane().setLayout (new GridBagLayout());
		
		menuBar = initializeMenu();
		
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
		
		// TODO Area codigo personalizada, si es necesario
		codeEditor = new JTextArea("Area texto");
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
		
		// TODO Canvas personalizado
		// JPanel canvas = new JPanel();
		canvas = new JTextField("Canvas");
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
		console = new JTextField("Consola");
		console.setEditable(false);
		constraints.gridx = 0; 
		constraints.gridy = 2; 
		constraints.gridwidth = 1; 
		constraints.gridheight = 1;
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 1.0;
		constraints.weighty = 0.3;
		this.getContentPane().add(console, constraints);
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.fill = GridBagConstraints.NONE;
		
		// TODO Biblioteca (no se que tipo de elemento, para relleno ser�un panel)
		// JPanel biblioteca = new JPanel();
		mediaLibrary = new JTextField("Biblioteca?");
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

	private JMenuBar initializeMenu()
	{
		JMenuBar tempMenuBar = new JMenuBar();
		JMenu fileMenu = new JMenu( "Archivo" );
		JMenuItem fileNew = new JMenuItem( "Nueva Animacion" );
		fileNew.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{				
				//TODO: Create new document and stuff
			}
		});

		JMenuItem fileSave = new JMenuItem( "Guardar" );
		fileSave.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});

		JMenuItem fileSaveAs = new JMenuItem( "Guardar Como" );
		fileSaveAs.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
		JMenuItem fileLoad = new JMenuItem( "Cargar" );
		fileLoad.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});

		JMenuItem fileQuit = new JMenuItem( "Salir" );
		fileQuit.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
				System.exit(0);
			}
		});
		
		fileMenu.add( fileNew );
		fileMenu.add( fileLoad );
		fileMenu.addSeparator();
		fileMenu.add( fileSave );
		fileMenu.add( fileSaveAs );
		fileMenu.addSeparator();
		fileMenu.add( fileQuit );

		JMenu editMenu = new JMenu( "Editar" );
		
		JMenuItem copy = new JMenuItem( "Copiar" );
		copy.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.copy();
			}
		});
		
		JMenuItem cut = new JMenuItem( "Cortar" );
		cut.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.cut();
			}
		});
		
		JMenuItem paste = new JMenuItem( "Pegar" );
		paste.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.paste();
			}
		});
		
		editMenu.add( copy );
		editMenu.add( cut );
		editMenu.add( paste );
		
		JMenu insertMenu = new JMenu("Insertar codigo");
		JMenuItem insertImage = new JMenuItem("Insertar imagen");
		insertImage.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert("___ : insertar \n posicion : __,__", codeEditor.getCaretPosition());
			}
		});
		
		insertMenu.add(insertImage);
		
		JMenu compileMenu = new JMenu("Compilar");
		compileMenu.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
		JMenu helpMenu = new JMenu( "Ayuda" );
		helpMenu.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO
			}
		});
		
		tempMenuBar = new JMenuBar();
		tempMenuBar.add( fileMenu );
		tempMenuBar.add( editMenu );
		tempMenuBar.add( insertMenu );
		tempMenuBar.add( compileMenu );
		tempMenuBar.add( helpMenu );

		return tempMenuBar;
	}
	
	private JScrollPane scrollpanel;
	private JMenuBar menuBar;
	private JTextField mediaLibrary;
	private JTextField console;
	private JTextField canvas;
	private GridBagConstraints constraints;
	private JTextArea codeEditor;
}
