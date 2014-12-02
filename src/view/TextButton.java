package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class TextButton extends JButton {

	/**
	 * Defines a button with an command inside. When clicked, the code
	 *  necessary to execute that action will be pasted
	 *  inside the current position of the caret in the code editor 
	 * @param arg0 The text that will be displayed inside the button
	 * @param arg1 The text that will be inserted into the editor when clicked
	 * @param codeEditor The Editor where the code will be inserted
	 */
	public TextButton(String arg0, final String arg1, final Editor codeEditor) {
		super(arg0);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert(arg1, codeEditor.getCaretPosition());				
			}
		});
	}

	
}
