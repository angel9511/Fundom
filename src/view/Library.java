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
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class Library extends JPanel {
	
	public Map<String, BufferedImage> imageDictionary = new HashMap<String, BufferedImage>();
	public Library() {
		// TODO Auto-generated constructor stub
		super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();
                
        JLabel panel1 = new JLabel();
        tabbedPane.addTab("Botones", panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        
        JLabel panel2 = new JLabel();
        tabbedPane.addTab("Imagenes", panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        JLabel panel3 = new JLabel();
        tabbedPane.addTab("Lecciones", panel3);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
           
        add(tabbedPane);
      
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		
	}
	
	public void addImages(){
		// TODO Lista de elementos
		BufferedImage sun = null;
		BufferedImage moon = null;
		try {
			sun = ImageIO.read(new File("sol.jpg"));
			moon = ImageIO.read(new File("luna.jpg"));
		} catch (IOException e) {	}
		
		imageDictionary.put("Sol", sun);
		imageDictionary.put("Luna", moon);		
	}
	
	

}
