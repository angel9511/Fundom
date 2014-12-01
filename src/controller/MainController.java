package controller;

import java.awt.Color;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.antlr.v4.runtime.*; 
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;




import model.Document;
import model.Figure;
import model.FuncodeBaseListener;
import model.FuncodeErrorListener;
import model.FuncodeLexer;
import model.FuncodeParser;
import view.MainFrame;

public class MainController {
	
	private String _tittle = "Fundom";
	public MainController() {
		window = new MainFrame();
		document = new Document();
	}
	
	public void initGraphic(){
		window.setTitle(_tittle );
		window.setVisible(true);
		window.setBounds(0, 0, 1200, 720);
		window.setExtendedState( Frame.MAXIMIZED_BOTH );
		window.setBackground(Color.WHITE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void letsAntlr(){
		this.text = window.getText();
		JOptionPane.showMessageDialog(null, "Se ejecutara!\n" + text);
		try { 
			setConsoleMsm("");
			CharStream stream = new ANTLRInputStream(text);
			FuncodeLexer analex = new FuncodeLexer(stream);
			CommonTokenStream tokens = new CommonTokenStream(analex);
			FuncodeParser anasint = new FuncodeParser(tokens);
			anasint.removeErrorListeners();
			anasint.addErrorListener(new FuncodeErrorListener());
			ParseTreeWalker walker = new ParseTreeWalker();
		    FuncodeBaseListener listener = new FuncodeBaseListener();
		    walker.walk(listener, anasint.start());
		    stopThreads();
		} catch (Exception fnfe) { 
			System.err.println("No se encontro el archivo"); 
			fnfe.printStackTrace();
		}
	}
	
	public static MainController getInstance() {
		
		if ( main == null ) {
			main = new MainController();
		}
		return main;
	}
	
	public void newDocument() {
		int r = saveDocumentIfModified();
		if ( r == JOptionPane.CANCEL_OPTION ) {
			// noop
		}
		else {
			document.initialize();
		}
	}

	private void doLoadDocument() {
		text = window.getText();
		document.setText(text);
		JFileChooser fc = new JFileChooser( System.getProperty( "user.home" ) );
		fc.setFileSelectionMode( JFileChooser.FILES_ONLY );
		fc.setFileFilter( new FileFilter() {
			
			@Override
			public String getDescription() {

				return "FUN files";
			}
			
			@Override
			public boolean accept(File f) {
				
				return f.getName().endsWith( FUN_SUFFIX );
			}
		} );
		fc.showOpenDialog( window );
		
		File f = fc.getSelectedFile();
		if ( f != null ) {
		
			try {
				
				ObjectInputStream ois = new ObjectInputStream(
											new FileInputStream( f ) );
				document.load( ois );
				ois.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "El archivo no pudo ser \'LOAD\'");
			}
		}
		else {
			// noop
		}

		text = document.getSchema();
		window.setText(text);
	}

	public void loadDocument() {

		int r = saveDocumentIfModified();
		if ( r == JOptionPane.CANCEL_OPTION ) {
			// noop
		}
		else {
			doLoadDocument();
		}			
	}
	
	public boolean saveDocument() {

		text = window.getText();
		document.setText(text);
		boolean r = false;

		String name = document.getName(); 
		if ( name.isEmpty() ) {
			
			JFileChooser fc = new JFileChooser( System.getProperty( "user.home" ) );
			fc.showSaveDialog( window );
			
			File f = fc.getSelectedFile();
			if ( f != null ) {

				name = f.getAbsolutePath();
			}
		}
		
		if ( name.isEmpty() ) {
			
			// user cancelled
		}
		else {
			
			if ( name.endsWith( FUN_SUFFIX ) ) {
				// OK
			}
			else {
			
				name += FUN_SUFFIX;
			}
			
			try {
				
				File f = new File( name );
				// TODO if ( f.canWrite() )
				// TODO if ( f.exists() )
				ObjectOutputStream oos = new ObjectOutputStream(
											new FileOutputStream( f ) );
				document.save( oos );
				oos.close();
				
				document.setName( f.getAbsolutePath() );
				r = true;
				
			} catch (Exception e) {
				JOptionPane.showMessageDialog(window, "Ha ocurrido un error al guardar el documento");
			}
		}
		
		return r;
	}
	
	protected int saveDocumentIfModified() {
		
		int r = JOptionPane.YES_OPTION;
				
		if ( document.isModified() ) {

			r = JOptionPane.showConfirmDialog( 
					window, 
					"El documento ha sido modificado, desea guardarlo antes de continuar?",
					"Guardar documento",
					JOptionPane.YES_NO_CANCEL_OPTION, 
					JOptionPane.QUESTION_MESSAGE );
			
			if ( r == JOptionPane.YES_OPTION ) {
				
				if ( saveDocument() ) {
					
					// OK
				}
				else {
					
					// noop (user cancelled)
				}
			}
			else {
				
				// noop
			}
		}
		else {
			
			// noop
		}
		
		return r;
	}
	
	public void quit() {

		int r = saveDocumentIfModified();
		if ( r == JOptionPane.CANCEL_OPTION ) {
			
			// noop
		}
		else {
			
			System.exit(0);
		}
	}
	

	public void moveImage(String name, int dx, int dy) {
		window.moveImage(name,dx,dy);
	}
	
	public String getSchema() {
		return document.getSchema();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getInstance().figureMap  = new HashMap<>();
		getInstance().runningFigures = new LinkedList<>();
		System.out.println("There should be a window 0");
		MainController main = getInstance();
		System.out.println("There should be a window 1");
		main.initGraphic();
		System.out.println("There should be a window 2");
		Figure ghost= new Figure("fantasma");
		Figure zero= new Figure("enmascarado");
		Figure luffy= new Figure("cultivador");
		Figure lizardon= new Figure("lagarto");
		Figure nanoha= new Figure("nena1");
		Figure cat= new Figure("gato");
		Figure jojo= new Figure("chico1");
		Figure burger= new Figure("hamburguesa");
		Figure happyface= new Figure("feliz");
		Figure clown= new Figure("payaso");
		Figure elmo= new Figure("elmo");
		Figure cookiemonster= new Figure("monstruogalletas");
		Figure abelardo= new Figure("abelardo");
		Figure xd= new Figure("xD");
		Figure clavin= new Figure("calvin");
		Figure sun= new Figure("sol");
		Figure mohammed= new Figure("ejecutivo");
		Figure hp= new Figure("hp");
		Figure thething= new Figure("monstruo");
		Figure kids= new Figure("nenes");
		Figure swim= new Figure("nadador");
		Figure blackkentuckychickenguy= new Figure("chico2");
		Figure blondgirl= new Figure("chica1");
		Figure interracial= new Figure("ajedrez");
		Figure gyaradous= new Figure("dragonasiatico");
		Figure masterchief= new Figure("halo");
		Figure happyfire= new Figure("fueguito");
		Figure littleblondgirl= new Figure("nena2");
		Figure togepi= new Figure("huevo");
		Figure moyashimon= new Figure("germen");
		Figure carlostomate= new Figure("carlostomate");
		Figure nokidsallowed= new Figure("prohibido");
		Figure dragon= new Figure("dragon");
		Figure eyelessgirl= new Figure("chica2");
		Figure halfbearhalfbear= new Figure("oso");
		Figure mii= new Figure("mii");
		Figure surffer= new Figure("surfista");
		Figure revolution= new Figure("letrero");
		Figure moon= new Figure("luna");
		Figure heureusegateau= new Figure("pastelfeliz");
		Figure doratheexplorer= new Figure("peruana");
		getInstance().figureMap.put("fantasma",  ghost );
		getInstance().figureMap.put("enmascarado",  zero );
		getInstance().figureMap.put("cultivador",  luffy );
		getInstance().figureMap.put("lagarto",  lizardon );
		getInstance().figureMap.put("nena1",  nanoha );
		getInstance().figureMap.put("gato",  cat );
		getInstance().figureMap.put("chico1",  jojo );
		getInstance().figureMap.put("hamburguesa",  burger );
		getInstance().figureMap.put("feliz",  happyface );
		getInstance().figureMap.put("payaso",  clown );
		getInstance().figureMap.put("elmo",  elmo );
		getInstance().figureMap.put("monstruogalletas",  cookiemonster );
		getInstance().figureMap.put("abelardo",  abelardo );
		getInstance().figureMap.put("xD",  xd );
		getInstance().figureMap.put("calvin",  clavin );
		getInstance().figureMap.put("sol",  sun );
		getInstance().figureMap.put("ejecutivo",  mohammed );
		getInstance().figureMap.put("hp",  hp );
		getInstance().figureMap.put("monstruo",  thething );
		getInstance().figureMap.put("nenes",  kids );
		getInstance().figureMap.put("nadador",  swim );
		getInstance().figureMap.put("chico2",  blackkentuckychickenguy );
		getInstance().figureMap.put("chica1",  blondgirl );
		getInstance().figureMap.put("ajedrez",  interracial );
		getInstance().figureMap.put("dragonasiatico",  gyaradous );
		getInstance().figureMap.put("halo",  masterchief );
		getInstance().figureMap.put("fueguito",  happyfire );
		getInstance().figureMap.put("nena2",  littleblondgirl );
		getInstance().figureMap.put("huevo",  togepi );
		getInstance().figureMap.put("germen",  moyashimon );
		getInstance().figureMap.put("carlostomate",  carlostomate );
		getInstance().figureMap.put("prohibido",  nokidsallowed );
		getInstance().figureMap.put("dragon",  dragon );
		getInstance().figureMap.put("chica2",  eyelessgirl );
		getInstance().figureMap.put("oso",  halfbearhalfbear );
		getInstance().figureMap.put("mii",  mii );
		getInstance().figureMap.put("surfista",  surffer );
		getInstance().figureMap.put("letrero",  revolution );
		getInstance().figureMap.put("luna",  moon );
		getInstance().figureMap.put("pastelfeliz",  heureusegateau );
		getInstance().figureMap.put("peruana",  doratheexplorer );
//		getInstance().hey();
//		getInstance().letsAntlr();
//		try { 
//			CharStream stream = new ANTLRInputStream("inicio"+
//					" elementos sol : insertar posicion :200,200 abelardo : insertar "+
//					"posicion : 0,0 animacion sol : mover direccion : derecha " + 
//					"pasos : 200 tiempo : 5 segundos sol : mover direccion : abajo "+
//					"pasos : 200 tiempo : 15 segundos FUN");
//			FuncodeLexer analex = new FuncodeLexer(stream);
//			CommonTokenStream tokens = new CommonTokenStream(analex);
//			FuncodeParser anasint = new FuncodeParser(tokens);
//			ParseTreeWalker walker = new ParseTreeWalker();
//		    FuncodeBaseListener listener = new FuncodeBaseListener();
//		    walker.walk(listener, anasint.start());
//		} catch (Exception fnfe) { 
//			System.err.println("No se encontro el archivo"); 
//			fnfe.printStackTrace();
//		}
//		getInstance().figureMap.get("sol").setVisible();		
//		getInstance().figureMap.get("sol").setTp(200, 200);
//		System.out.println("Starting");
//		getInstance().figureMap.get("sol").start();
//		System.out.println("Joining");
//		try {
//			getInstance().figureMap.get("sol").join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		getInstance().figureMap.get("sol").setMovement(200, 0, 5);
//		getInstance().figureMap.get("sol").run();
//		try {
//			getInstance().figureMap.get("sol").join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		getInstance().figureMap.get("sol").setMovement(0, 200, 15);
//		getInstance().figureMap.get("sol").run();
	}

	public void hey()
	{
		letsAntlr();
	}
	
	public void defineFigure(String name, int x, int y)
	{
		figureMap.get(name).setVisible();
		figureMap.get(name).setTp(x, y);
		runningFigures.add(name);
	}
	
	public void moveFigure(String name, int dx, int dy, int time)
	{
		System.out.println("The Name is " + name);
		figureMap.get(name).setMovement(dx, dy, time);
		figureMap.get(name).run();
		try {
			figureMap.get(name).join();
		} catch (InterruptedException e) {
			System.out.println("Error joining " + name);
		}
	}
	
	public void tpFigure(String name, int dx, int dy)
	{
		figureMap.get(name).setTp(dx, dy);
		figureMap.get(name).run();
		try {
			figureMap.get(name).join();
		} catch (InterruptedException e) {
			System.out.println("Error joining " + name);
		}
	}
	
	public void hideFigure(String name)
	{
		figureMap.get(name).setHide();
		try {
			figureMap.get(name).join();
		} catch (InterruptedException e) {
			System.out.println("Error joining " + name);
		}
	}
	
	public void setConsoleMsm(String error){
		window.setConsoleMsm(error);
	}
	
	public void showFigure(String name)
	{
		figureMap.get(name).setVisible();
		try {
			figureMap.get(name).join();
		} catch (InterruptedException e) {
			System.out.println("Error joining " + name);
		}
	}
	
	public void waitFigure(String name, int time)
	{
		figureMap.get(name).setWait(time);
		figureMap.get(name).run();
	}
	
	public void doStuff(String s)
	{
		if(s.equals("compilar"))
			letsAntlr();
	}
	
	public void isModified(boolean b) {
		document.setModified(b);
	}
	
	public void repaint() {
		window.forceRepaint();
	}
	
	public void setVisible(String name, boolean b) {
		window.setItemVisible(name, b);
		
	}
	
	public void runThreads() {
		System.out.println("Starting to run threads");
		for(String s: runningFigures)
		{
			figureMap.get(s).start();
			System.out.println("Starting " + s);
//			repaint();
		}
		for(String s: runningFigures)
		{
			try {
				figureMap.get(s).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Couldn't Join");
			}
		}
		System.out.println("Ending to run threads");
	}
	
	public void stopThreads() {
		System.out.println("Starting to run threads");
		for(String s: runningFigures)
		{
			figureMap.get(s).stop();
			System.out.println("Stoping " + s);
		}
		
		System.out.println("Ending to stop threads");
	}

	Map<String, Figure> figureMap;
	List<String> runningFigures;
	public String errorMsm;
	private MainFrame window;
	private static MainController main;
	private Document document;
	private String text;
	public static String FUN_SUFFIX = ".fun";

}