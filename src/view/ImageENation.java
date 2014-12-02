package view;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public class ImageENation {
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public BufferedImage getI() {
		return i;
	}

	public void setI(BufferedImage i) {
		this.i = i;
	}

	/**
	 * Returns whether the image is visible
	 * @return True if the image is visible, false if the image is invisible
	 */
	public boolean isVisible() {
		return isVisible;
	}

	/**
	 * Makes the image visible or invisible
	 * @param isVisible If true the image becose visible, is false the image 
	 *                   becomes invisible
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	private int x = 0;
	private int y = 0;
    private BufferedImage i = null;
    private boolean isVisible = false;
}
