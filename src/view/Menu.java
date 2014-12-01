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
			@Override
			public void actionPerformed(ActionEvent e) 
			{				
				MainController.getInstance().newDocument();
			}
		});
		
		JMenuItem fileSave = new JMenuItem( "Guardar" );
		fileSave.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().saveDocument();	
			}
		});
		
		JMenuItem fileSaveAs = new JMenuItem( "Guardar Como" );
		fileSaveAs.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().saveDocument();//TODO
			}
		});
		
		JMenuItem fileLoad = new JMenuItem( "Cargar" );
		fileLoad.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainController.getInstance().loadDocument();
			}
		});
		
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
		JMenuItem mover = new JMenuItem("Mover imagen");
		mover.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("mover"), codeEditor.getCaretPosition());
			}
		});
		
		JMenuItem tp = new JMenuItem("Teletransportar imagen");
		tp.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("tp"), codeEditor.getCaretPosition());
			}
		});
		
		JMenuItem esperar = new JMenuItem("Esperar imagen");
		esperar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("esperar"), codeEditor.getCaretPosition());
			}
		});
		
		JMenuItem ocultar = new JMenuItem("Ocultar imagen");
		ocultar.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(GrammarMap.getGrammar().get("ocultar"), codeEditor.getCaretPosition());
			}
		});
		
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
		
		JMenu helpMenu = new JMenu("Acerca");
		helpMenu.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Fundom\nDesarrollado por:\nAngel Avila: Programador, Diseniador, Concepto Original\nFrancisco Aranguren: Programador, Diseniador, Pedagogo, Experto en ASM, Veterano de guerra\nJhair Naranjo: Diseniador");
			}
		});
		
		helpMenu.add(helpMenu);
		
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
