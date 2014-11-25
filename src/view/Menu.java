package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Menu extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu() {
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
		
		add( fileMenu );
		add( editMenu );
		add( insertMenu );
		add( compileMenu );
		add( helpMenu );
		
	}
	
	public void setCodeEditor(JTextArea codeEditor) {
		this.codeEditor = codeEditor;
	}

	public JTextArea codeEditor;
	
}
