package view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Library extends JPanel {
	
	public Map<String, BufferedImage> imageDictionary = new HashMap<String, BufferedImage>();
	public Library() {
		// TODO Auto-generated constructor stub
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
