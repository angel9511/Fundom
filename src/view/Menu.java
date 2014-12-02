package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import model.GrammarMap;
import model.MenuBugFix;

import controller.MainController;

public class Menu extends JMenuBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu() {
		JMenu fileMenu = new JMenu( "Archivo" );
		JMenuItem fileNew = new JMenuItem( "Nueva Animacion" );
		fileNew.addActionListener( new ActionListener() {
			/**
			 * When clicked, this button creates a new document
			 */
			@Override
			public void actionPerformed(ActionEvent e) 
			{				
				MainController.getInstance().newDocument();
			}
		});
		
		/**
		 * When clicked, this button saves the current document,
		 *  if the document is already saved, it saves it in the 
		 *  same file, otherwise it prompts the user for a path
		 *  to save it into
		 */
		JMenuItem fileSave = new JMenuItem( "Guardar" );
		fileSave.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().saveDocument();	
			}
		});
		
		/**
		 * When clicked, this button saves the current document, always
		 *  prompts user for a path to save the document into
		 */
		JMenuItem fileSaveAs = new JMenuItem( "Guardar Como" );
		fileSaveAs.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().saveDocument();//TODO 
			}
		});
		
		/**
		 * When clicked, this button loads a document from disk
		 */
		JMenuItem fileLoad = new JMenuItem( "Cargar" );
		fileLoad.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().loadDocument();
			}
		});
		
		/**
		 * When clicked, this button exits Fundom
		 */
		JMenuItem fileQuit = new JMenuItem( "Salir" );
		fileQuit.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().quit();
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
		/**
		 * When clicked, this button copies the highlighted 
		 *  text into clipboard
		 */
		JMenuItem copy = new JMenuItem( "Copiar" );
		copy.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.copy();
			}
		});
		
		/**
		 * When clicked, this button cuts the highlighted
		 *  text into clipboard
		 */
		JMenuItem cut = new JMenuItem( "Cortar" );
		cut.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.cut();
			}
		});
		
		/**
		 * When clicked, this button pastes text from the 
		 *  clipboard into the document 
		 */
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
		
		/**
		 * When clicked, this button inserts the code necessary
		 *  to slide a image into the document
		 */
		JMenuItem mover = new JMenuItem("Mover imagen");
		mover.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("mover"), codeEditor.getCaretPosition());
			}
		});
		
		/**
		 * When clicked, this button inserts the code necessary
		 *  to move a image into the document
		 */
		JMenuItem tp = new JMenuItem("Teletransportar imagen");
		tp.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("tp"), codeEditor.getCaretPosition());
			}
		});
		
		/**
		 * When clicked, this button inserts the code necessary
		 *  to make an image wait into the document
		 */
		JMenuItem esperar = new JMenuItem("Esperar imagen");
		esperar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("esperar"), codeEditor.getCaretPosition());
			}
		});
		
		/**
		 * When clicked, this button inserts the code necessary
		 *  to hide a image into the document
		 */
		JMenuItem ocultar = new JMenuItem("Ocultar imagen");
		ocultar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("ocultar"), codeEditor.getCaretPosition());
			}
		});
		
		/**
		 * When clicked, this button inserts the code necessary
		 *  to show a image into the document
		 */
		JMenuItem mostrar = new JMenuItem("Mostrar imagen");
		mostrar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("mostrar"), codeEditor.getCaretPosition());
			}
		});
		
		insertMenu.add(mover);
		insertMenu.add(tp);
		insertMenu.add(esperar);
		insertMenu.add(mostrar);
		insertMenu.add(ocultar);
		
		JMenu compileMenu = new JMenu("Ejecutar");
		/**
		 * When clicked, this button compiles the document
		 */
		JMenuItem compile = new JMenuItem("Compilar");
		compile.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//MainController.getInstance().doStuff(JOptionPane.showInputDialog("Escribe compilar"));
				MenuBugFix b = new MenuBugFix();
				b.start();
				revalidate();
				//MainController.getInstance().hey();
			}
		});
		
		compileMenu.add(compile);
		
		/**
		 * When clicked, this button shows some info about the developers of Fundom
		 */
		JMenuItem helpMenu = new JMenuItem("Acerca");
		helpMenu.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Batman");
				JOptionPane.showMessageDialog(null, "Fundom\nDesarrollado por:\nAngel Avila: Programador, Diseniador, Concepto Original\nFrancisco Aranguren: Programador, Diseniador, Pedagogo, Experto en ASM, Veterano de guerra\nJhair Naranjo: Diseniador");
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
