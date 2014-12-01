package view;

import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import controller.MainController;

public class Editor extends JTextArea {
	
	public Editor() {
		super(schema);
		getDocument().addDocumentListener(new DocumentListener() {

	        @Override
	        public void removeUpdate(DocumentEvent e) {
	        	MainController.getInstance().isModified(true);
	        }

	        @Override
	        public void insertUpdate(DocumentEvent e) {
	        	MainController.getInstance().isModified(true);
	        }

	        @Override
	        public void changedUpdate(DocumentEvent arg0) {
	        }
	    });
	}
	
	
	
	static String schema = MainController.getInstance().getSchema();

}
