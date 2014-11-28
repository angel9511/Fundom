package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.MainController;

public class Canvas extends JPanel {
	
	public Map<String, ImageENation> imageDictionary = new HashMap<String, ImageENation>();
	private List<ImageENation>  elements = new LinkedList<>();
	public Canvas() {
		
		try {
			ghost.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/1.jpg")));
			 zero.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/2.jpg")));
			 luffy.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/3.jpg")));
			 lizardon.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/4.jpg")));
			 nanoha.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/5.jpg")));
			 cat.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/6.jpg")));
			 jojo.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/7.jpg")));
			 burger.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/8.jpg")));
			 happyface.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/9.jpg")));
			 clown.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/10.jpg")));
			 elmo.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/11.jpg")));
			 cookiemonster.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/12.jpg")));
			 abelardo.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/13.jpg")));
			 xd.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/14.jpg")));
			 clavin.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/15.jpg")));
			 sun.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/16.jpg")));
			 mohammed.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/17.jpg")));
			 hp.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/18.jpg")));
			 thething.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/19.jpg")));
			 kids.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/20.jpg")));
			 swim.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/21.jpg")));
			 blackkentuckychickenguy.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/22.jpg")));
			 blondgirl.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/23.jpg")));
			 interracial.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/24.jpg")));
			 gyaradous.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/25.jpg")));
			 masterchief.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/26.jpg")));
			 happyfire.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/27.jpg")));
			 littleblondgirl.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/28.jpg")));
			 togepi.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/29.jpg")));
			 moyashimon.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/30.jpg")));
			 carlostomate.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/31.jpg")));
			 nokidsallowed.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/32.jpg")));
			 dragon.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/33.jpg")));
			 eyelessgirl.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/34.jpg")));
			 halfbearhalfbear.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/35.jpg")));
			 mii.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/36.jpg")));
			 surffer.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/37.jpg")));
			 revolution.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/38.jpg")));
			 moon.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/39.jpg")));
			 heureusegateau.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/40.jpg")));
			 doratheexplorer.setI(ImageIO.read(Canvas.class.getResourceAsStream("/images/41.jpg")));
		} catch (IOException e) {	}

		imageDictionary.put("fantasma",  ghost );
		imageDictionary.put("enmascarado",  zero );
		imageDictionary.put("cultivador",  luffy );
		imageDictionary.put("lagarto",  lizardon );
		imageDictionary.put("nena1",  nanoha );
		imageDictionary.put("gato",  cat );
		imageDictionary.put("chico1",  jojo );
		imageDictionary.put("hamburguesa",  burger );
		imageDictionary.put("feliz",  happyface );
		imageDictionary.put("payaso",  clown );
		imageDictionary.put("elmo",  elmo );
		imageDictionary.put("monstruogalletas",  cookiemonster );
		imageDictionary.put("abelardo",  abelardo );
		imageDictionary.put("xD",  xd );
		imageDictionary.put("calvin",  clavin );
		imageDictionary.put("sol",  sun );
		imageDictionary.put("ejecutivo",  mohammed );
		imageDictionary.put("hp",  hp );
		imageDictionary.put("monstruo",  thething );
		imageDictionary.put("nenes",  kids );
		imageDictionary.put("nadador",  swim );
		imageDictionary.put("chico2",  blackkentuckychickenguy );
		imageDictionary.put("chica1",  blondgirl );
		imageDictionary.put("ajedrez",  interracial );
		imageDictionary.put("dragonasiatico",  gyaradous );
		imageDictionary.put("halo",  masterchief );
		imageDictionary.put("fueguito",  happyfire );
		imageDictionary.put("nena2",  littleblondgirl );
		imageDictionary.put("huevo",  togepi );
		imageDictionary.put("germen",  moyashimon );
		imageDictionary.put("carlostomate",  carlostomate );
		imageDictionary.put("prohibido",  nokidsallowed );
		imageDictionary.put("dragon",  dragon );
		imageDictionary.put("chica2",  eyelessgirl );
		imageDictionary.put("oso",  halfbearhalfbear );
		imageDictionary.put("mii",  mii );
		imageDictionary.put("surfista",  surffer );
		imageDictionary.put("letrero",  revolution );
		imageDictionary.put("luna",  moon );
		imageDictionary.put("pastelfeliz",  heureusegateau );
		imageDictionary.put("peruana",  doratheexplorer );
		elements.add( ghost );
		elements.add( zero );
		elements.add( luffy );
		elements.add( lizardon );
		elements.add( nanoha );
		elements.add( cat );
		elements.add( jojo );
		elements.add( burger );
		elements.add( happyface );
		elements.add( clown );
		elements.add( elmo );
		elements.add( cookiemonster );
		elements.add( abelardo );
		elements.add( xd );
		elements.add( clavin );
		elements.add( sun );
		elements.add( mohammed );
		elements.add( hp );
		elements.add( thething );
		elements.add( kids );
		elements.add( swim );
		elements.add( blackkentuckychickenguy );
		elements.add( blondgirl );
		elements.add( interracial );
		elements.add( gyaradous );
		elements.add( masterchief );
		elements.add( happyfire );
		elements.add( littleblondgirl );
		elements.add( togepi );
		elements.add( moyashimon );
		elements.add( carlostomate );
		elements.add( nokidsallowed );
		elements.add( dragon );
		elements.add( eyelessgirl );
		elements.add( halfbearhalfbear );
		elements.add( mii );
		elements.add( surffer );
		elements.add( revolution );
		elements.add( moon );
		elements.add( heureusegateau );
		elements.add( doratheexplorer );
	}

	public void moveImage(String name, int dx, int dy) {
		imageDictionary.get(name).setX(imageDictionary.get(name).getX()+dx);
		imageDictionary.get(name).setY(imageDictionary.get(name).getY()+dy);
	}
	
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		for(ImageENation el : elements)
		{
			if(el.isVisible())
				g.drawImage(el.getI(), el.getX(), el.getY(), 83, 83, null);
		}
	}
	
	public void setItemVisible(String name, boolean b) {
		imageDictionary.get(name).setVisible(b);		
	}
	
	private ImageENation ghost = new ImageENation();
	private ImageENation zero = new ImageENation();
	private ImageENation luffy = new ImageENation();
	private ImageENation lizardon = new ImageENation();
	private ImageENation nanoha = new ImageENation();
	private ImageENation cat = new ImageENation();
	private ImageENation jojo = new ImageENation();
	private ImageENation burger = new ImageENation();
	private ImageENation happyface = new ImageENation();
	private ImageENation clown = new ImageENation();
	private ImageENation elmo = new ImageENation();
	private ImageENation cookiemonster = new ImageENation();
	private ImageENation abelardo = new ImageENation();
	private ImageENation xd = new ImageENation();
	private ImageENation clavin = new ImageENation();
	private ImageENation sun = new ImageENation();
	private ImageENation mohammed = new ImageENation();
	private ImageENation hp = new ImageENation();
	private ImageENation thething = new ImageENation();
	private ImageENation kids = new ImageENation();
	private ImageENation swim = new ImageENation();
	private ImageENation blackkentuckychickenguy = new ImageENation();
	private ImageENation blondgirl = new ImageENation();
	private ImageENation interracial = new ImageENation();
	private ImageENation gyaradous = new ImageENation();
	private ImageENation masterchief = new ImageENation();
	private ImageENation happyfire = new ImageENation();
	private ImageENation littleblondgirl = new ImageENation();
	private ImageENation togepi = new ImageENation();
	private ImageENation moyashimon = new ImageENation();
	private ImageENation carlostomate = new ImageENation();
	private ImageENation nokidsallowed = new ImageENation();
	private ImageENation dragon = new ImageENation();
	private ImageENation eyelessgirl = new ImageENation();
	private ImageENation halfbearhalfbear = new ImageENation();
	private ImageENation mii = new ImageENation();
	private ImageENation surffer = new ImageENation();
	private ImageENation revolution = new ImageENation();
	private ImageENation moon = new ImageENation();
	private ImageENation heureusegateau = new ImageENation();
	private ImageENation doratheexplorer = new ImageENation();
	
	
}
