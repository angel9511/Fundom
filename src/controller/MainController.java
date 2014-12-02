package controller;

import java.awt.Color;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import view.MainFrame;

public class MainController {
	
	private String _tittle = "Fundom";
	
	/**
	 * MainController constructor 
	 * initializes document used to store the code and the window
	 */
	public MainController() {
		window = new MainFrame();
		document = new Document();
	}
	
	/**
	 * Initializes the window with the default parameters and title
	 */
	public void initGraphic(){
		window.setTitle(_tittle );
		window.setVisible(true);
		window.setBounds(0, 0, 1200, 720);
		window.setExtendedState( Frame.MAXIMIZED_BOTH );
		window.setBackground(Color.WHITE);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	/**
	 * Compiles the code written in the code editor using ANTLR
	 * Create a instance of a charStream with a string get from
	 * texteditor. Next, create a lexer, inicialize the tokens and
	 * create the parser with the charStram. Next, add the custom
	 * error listener and run the lenguaje interpreter 
	 */
	public void letsAntlr(){
		for(String s: runningFigures)
		{
			figureMap.get(s).reset();
			System.out.println("Hiding " + s);
//			repaint();
		}
		for(String s: runningFigures)
		{
			try {
				figureMap.get(s).join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hiding " + s);
//			repaint();
		}
		runningFigures.clear();
		this.text = window.getText();
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
		} catch (Exception fnfe) { 
			System.err.println("No se encontro el archivo"); 
			fnfe.printStackTrace();
		}
	}
	
	/**
	 * Singleton design pattern
	 * @return MainController instance of the singleton pattern
	 */
	public static MainController getInstance() {
		if ( main == null ) {
			main = new MainController();
		}
		return main;
	}
	
	/**
	 * Creates a new document. If the current document has
	 *  not been saved since last modification, prompts user
	 *  for confirmation
	 */
	public void newDocument() {
		int r = saveDocumentIfModified();
		if ( r == JOptionPane.CANCEL_OPTION ) {
			// Do nothing
		}
		else {
			document.initialize();
		}
	}

	/**
	 * Loads a FUN file from disk in the text editor
	 */
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
			// Do nothing
		}
		text = document.getSchema();
		window.setText(text);
	}

	/**
	 * Asks user for prompt in the case they try to load
	 *  a document but the current document has not been
	 *  saved, they can either load without saving, load
	 *  after saving or cancel the load operation
	 */
	public void loadDocument() {
		int r = saveDocumentIfModified();
		if ( r == JOptionPane.CANCEL_OPTION ) {
			// Do nothing
		}
		else {
			doLoadDocument();
		}			
	}
	
	/**
	 * Saves the document into disk
	 * @return True if the save operation was successful, false otherwise
	 */
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
				// OK, Do nothing
			}
			else {
				name += FUN_SUFFIX;
			}
			try {	
				File f = new File( name );
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
	
	/**
	 * When the user tries to close in some way a document
	 *  a JOptionPane will ask user for prompt in the case
	 *  the document has been modified, they can either 
	 *  save it, continue the operation that would close
	 *  the document or cancel it
	 * @return An integer indicating the option selected by the user
	 */
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
					// Do nothing (user cancelled)
				}
			}
			else {
				// Do nothing
			}
		}
		else {
			// noop
		}		
		return r;
	}
	
	/**
	 * Asks user for prompt in the case they try to close
	 *  the program but the current document has not been
	 *  saved, they can either quit without saving, quit
	 *  after saving or don't quit the program
	 */
	public void quit() {
		int r = saveDocumentIfModified();
		if ( r == JOptionPane.CANCEL_OPTION ) {
			// Do nothing
		}
		else {
			System.exit(0);
		}
	}
	
	/**
	 * Moves an image present in the canvas to another position 
	 * @param name the name of the image
	 * @param dx   the distance in x the image will be moved, can be negative
	 * @param dy   the distance in y the image will be moved, can be negative
	 */
	public void moveImage(String name, int dx, int dy) {
		window.moveImage(name,dx,dy);
	}
	
	/**
	 * @return The schema of the document
	 */
	public String getSchema() {
		return document.getSchema();
	}
	
	public static void main(String[] args) {
		getInstance().figureMap  = new HashMap<>();
		getInstance().runningFigures = new LinkedList<>();
		System.out.println("There should be a window 0");
		MainController main = getInstance();
		System.out.println("There should be a window 1");
		main.initGraphic();
		System.out.println("There should be a window 2");
		Figure ghost= new Figure("fantasma");
		ghost.start();
		Figure zero= new Figure("enmascarado");
		zero.start();
		Figure luffy= new Figure("cultivador");
		luffy.start();
		Figure lizardon= new Figure("lagarto");
		lizardon.start();
		Figure nanoha= new Figure("nena1");
		nanoha.start();
		Figure cat= new Figure("gato");
		cat.start();
		Figure jojo= new Figure("chico1");
		jojo.start();
		Figure burger= new Figure("hamburguesa");
		burger.start();
		Figure happyface= new Figure("feliz");
		happyface.start();
		Figure clown= new Figure("payaso");
		clown.start();
		Figure elmo= new Figure("elmo");
		elmo.start();
		Figure cookiemonster= new Figure("monstruogalletas");
		cookiemonster.start();
		Figure abelardo= new Figure("abelardo");
		abelardo.start();
		Figure xd= new Figure("xD");
		xd.start();
		Figure clavin= new Figure("calvin");
		clavin.start();
		Figure sun= new Figure("sol");
		sun.start();
		Figure mohammed= new Figure("ejecutivo");
		mohammed.start();
		Figure hp= new Figure("hp");
		hp.start();
		Figure thething= new Figure("monstruo");
		thething.start();
		Figure kids= new Figure("nenes");
		kids.start();
		Figure swim= new Figure("nadador");
		swim.start();
		Figure blackkentuckychickenguy= new Figure("chico2");
		blackkentuckychickenguy.start();
		Figure blondgirl= new Figure("chica1");
		blondgirl.start();
		Figure interracial= new Figure("ajedrez");
		interracial.start();
		Figure gyaradous= new Figure("dragonasiatico");
		gyaradous.start();
		Figure masterchief= new Figure("halo");
		masterchief.start();
		Figure happyfire= new Figure("fueguito");
		happyfire.start();
		Figure littleblondgirl= new Figure("nena2");
		littleblondgirl.start();
		Figure togepi= new Figure("huevo");
		togepi.start();
		Figure moyashimon= new Figure("germen");
		moyashimon.start();
		Figure carlostomate= new Figure("carlostomate");
		carlostomate.start();
		Figure nokidsallowed= new Figure("prohibido");
		nokidsallowed.start();
		Figure dragon= new Figure("dragon");
		dragon.start();
		Figure eyelessgirl= new Figure("chica2");
		eyelessgirl.start();
		Figure halfbearhalfbear= new Figure("oso");
		halfbearhalfbear.start();
		Figure mii= new Figure("mii");
		mii.start();
		Figure surffer= new Figure("surfista");
		surffer.start();
		Figure revolution= new Figure("letrero");
		revolution.start();
		Figure moon= new Figure("luna");
		moon.start();
		Figure heureusegateau= new Figure("pastelfeliz");
		heureusegateau.start();
		Figure doratheexplorer= new Figure("peruana");
		doratheexplorer.start();
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
/*---------------------------------------------------------------------------------------
*		 TEXT AREA 
*		 
*		
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
 * 
 ------------------------------------------------------------------------*/
	}
	
	/**
	 * Creates an image in the given position, so it can be animated
	 * @param name The name of the image that will be defined for the animation
	 * @param x Starting position of the defined image in the x-axis
	 * @param y Starting position of the defined image in the y-axis
	 */
	public void defineFigure(String name, int x, int y)
	{
		figureMap.get(name).setVisible();
		figureMap.get(name).setTp(x, y);
		runningFigures.add(name);
	}
	
	/**
	 * Slides a given image a distance during certain amount of time
	 * @param name the name of the image that will be moved
	 * @param dx   the distance in x the image will be moved, can be negative
	 * @param dy   the distance in y the image will be moved, can be negative
	 * @param time the amount of time(In seconds) the sliding will last
	 */
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
	
	/**
	 * Moves a image(Instantly) a given amount of pixels
	 * @param name the name of the image will be moved
	 * @param dx   the distance in x the image will be moved, can be negative
	 * @param dy   the distance in y the image will be moved, can be negative
	 */
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
	
	/**
	 * A given image will become invisible in the canvas
	 * @param name The name of the image
	 */
	public void hideFigure(String name)
	{
		figureMap.get(name).setHide();
		try {
			figureMap.get(name).join();
		} catch (InterruptedException e) {
			System.out.println("Error joining " + name);
		}
	}
	
	/**
	 * Prints in the IDE console any error that might appear
	 * @param error
	 */
	public void setConsoleMsm(String error){
		window.setConsoleMsm(error);
	}
	
	/**
	 * A given image will become visible in the canvas
	 * @param name The name of the image
	 */
	public void showFigure(String name)
	{
		figureMap.get(name).setVisible();
		try {
			figureMap.get(name).join();
		} catch (InterruptedException e) {
			System.out.println("Error joining " + name);
		}
	}
	
	/**
	 * A given image will not execute any of it's future actions
	 *  during the duration of the given time
	 * @param name The name of the image
	 * @param time Time the figure will be waiting, given in seconds
	 */
	public void waitFigure(String name, int time)
	{
		figureMap.get(name).setWait(time);
		figureMap.get(name).run();
	}
	
	/**
	 * Sets the modified field in Document to the boolean b received
	 * @param b
	 */
	public void isModified(boolean b) {
		document.setModified(b);
	}
	
	/**
	 * Forces a repaint in the Window and it's canvas component
	 */
	public void repaint() {
		window.forceRepaint();
	}
	
	/**
	 * A given image will become either visible or invisible
	 *  in the canvas
	 * @param name The name of the given image
	 * @param b    True if the image will become visible, false otherwise
	 */
	public void setVisible(String name, boolean b) {
		window.setItemVisible(name, b);
	}
	
	/**
	 * Sets starting positions of the images defined in the document
	 */
	public void runThreads() {
		System.out.println("Starting to run threads");
		for(String s: runningFigures)
		{
			figureMap.get(s).run();
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

	public void resetImage(String name)
	{
		window.resetImage(name);
	}
	
	/**
	 * Check if a inserted image exist on the library
	 * @param string name of the image to check
	 * @return
	 */
	public boolean validImage(String string) {
		return figureMap.containsKey(string);		
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