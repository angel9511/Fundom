package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

import controller.MainController;

public class ImageButton extends JButton {

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
