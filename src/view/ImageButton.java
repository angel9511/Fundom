package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import controller.MainController;

public class ImageButton extends JButton {

	/**
	 * Defines a button with an image inside. When clicked, the code
	 *  necessary to insert that image into the animation will be pasted
	 *  inside the current position of the caret in the code editor 
	 * @param icon The image that will be displayed in the button
	 * @param insert The name of the image
	 * @param codeEditor The Editor where the code will be inserted
	 */
	public ImageButton( Icon icon, final String insert, final Editor codeEditor) {
		super(icon);
		addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				codeEditor.insert("\t \t " + insert + ": insertar \n"
						+ "\t \t \t posicion : __,__ \n", codeEditor.getCaretPosition());
			}
		});
	}

}
