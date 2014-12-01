package model;

import controller.MainController;

public class MenuBugFix extends Thread {

	@Override
	public void run()
	{
		MainController.getInstance().letsAntlr();
		System.out.println("Animatin'");
	}
}
