package view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Library extends JPanel {
	
	public Library(Editor e) {
		super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();
                
        blibrary = new ButtonLibrary(e);
        bscroll = new JScrollPane(blibrary);
        tabbedPane.addTab("Botones", bscroll);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        ilibrary = new ImageLibrary(e);
        iscroll = new JScrollPane(ilibrary);
        tabbedPane.addTab("Imagenes", iscroll);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        llibrary = new LessonLibrary();
        lscroll = new JScrollPane(llibrary);
        tabbedPane.addTab("Lecciones", lscroll);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
           
        add(tabbedPane);
      
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
	}
	
	ImageLibrary ilibrary;
	JScrollPane iscroll;
	ButtonLibrary blibrary;
	JScrollPane bscroll;
	LessonLibrary llibrary;
	JScrollPane lscroll;

}
