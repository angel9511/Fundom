package model;

import controller.MainController;

public class Figure extends Thread {
	
	/**
	 * The constructor set the field name as the incoming
	 * parameter. A Figure extends from Thread 
	 * @param name
	 */
	public Figure(String name)
	{
		this.name = name;
	}
	
	/**
	 * Set the movement of the figure. This is a override method from
	 * Thread and increase the coordinates to move the figure
	 */
	@SuppressWarnings("static-access")
	@Override
	public void run() 
	{
		int currentdx = 0;
		int currentdy = 0;
		while(currentdy <  Math.abs(dy) || currentdx <  Math.abs(dx))
		{
			if(time == 0)
			{
				dy = -dy;
				dx = -dx;
				currentdy = dy;
				currentdx = dx;
				MainController.getInstance().moveImage(name, -dx, -dy);
			}
			if(currentdy < Math.abs(dy) && currentdx < Math.abs(dx)){
				currentdy++;
				currentdx++;				
				MainController.getInstance().moveImage(name, dx/Math.abs(dx), dy/Math.abs(dy));
			}
			else{
				if(currentdy < Math.abs(dy)){
					currentdy++;	
					MainController.getInstance().moveImage(name, 0, dy/Math.abs(dy));
				}
				else{
					if(currentdx < Math.abs(dx)){
					currentdx++;				
					MainController.getInstance().moveImage(name, dx/Math.abs(dx), 0);
					}
				}
			}
			try {
				this.sleep(time * 1000 / (( Math.max(Math.abs(dx), Math.abs(dy) ))+1));
				MainController.getInstance().repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
			if((currentdx % 100 == 0 && currentdx != dx )|| (currentdy % 100 == 0&& currentdy!=dy))
				System.out.println(currentdx + "   " + currentdy);
		}
	}
	
	/**
	 * Set the dx, dy and time values to the run method
	 * @param dx
	 * @param dy
	 * @param time
	 */
	public void setMovement(int dx, int dy, int time)
	{
		this.dx = dx;
		this.dy = dy;
		this.time = time;
		//run();
	}
	
	/**
	 * Set the dx and dy values to the run method. Also set the
	 * time value 0, that simulate the Tp effect. 
	 * @param dx
	 * @param dy
	 */
	public void setTp(int dx, int dy)
	{
		this.dx = dx;
		this.dy = dy;
		this.time = 0;
		//run();
	}
	
	/**
	 * Set the time value to the run method. Also set the dx and dy(
	 * increment variables) on 1. That simulate the wait effect
	 * @param time
	 */
	public void setWait(int time)
	{
		this.dx = 1;
		this.dy = 1;
		this.time = time;
		//run();
	}
	
	/**
	 * Set the visible value of a given image to false. That image disappears
	 */
	public void setHide()
	{
		MainController.getInstance().setVisible(name, false);
	}
	
	/**
	 * Set the visible value of a given image to true. That image is painted
	 */
	public void setVisible()
	{
		MainController.getInstance().setVisible(name, true);
	}
	
	public void reset()
	{
		setHide();
		MainController.getInstance().resetImage(name);
	}
	
	
	private int dx;
	private int dy;
	private int time;
	private String name;
}
