package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

@SuppressWarnings("serial")
public class TextButton extends JButton {

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
