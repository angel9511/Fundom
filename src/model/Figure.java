package model;

import controller.MainController;

public class Figure extends Thread {

	public Figure(String name)
	{
		this.name = name;
	}
	
	@SuppressWarnings("static-access")
	@Override
	public void run() 
	{
		int currentdx = 0;
		int currentdy = 0;
		while(currentdy < dy || currentdx < dx)
		{
			if(time == 0)
			{
				currentdy = dy;
				currentdx = dx;
				MainController.getInstance().moveImage(name, dx, dy);
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
				this.sleep(time * 1000 / Math.abs(Math.max(dx, dy))+1);
				MainController.getInstance().repaint();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			//System.out.println(currentdx + "   " + currentdy);
		}
	}
	
	public void setMovement(int dx, int dy, int time)
	{
		this.dx = dx;
		this.dy = dy;
		this.time = time;
		//run();
	}
	
	public void setTp(int dx, int dy)
	{
		this.dx = dx;
		this.dy = dy;
		this.time = 0;
		//run();
	}
	
	public void setWait(int time)
	{
		this.dx = 1;
		this.dy = 1;
		this.time = time;
		//run();
	}
	
	public void setHide()
	{
		MainController.getInstance().setVisible(name, false);
	}
	
	public void setVisible()
	{
		MainController.getInstance().setVisible(name, true);
	}
	
	
	private int dx;
	private int dy;
	private int time;
	private String name;
}
