package model;

import controller.MainController;

public class MenuBugFix extends Thread {

	/**
	 * This class inherit from Thread. Its run method calls the
	 * letsAntlr method on main
	 */
	@Override
	public void run()
	{
		MainController.getInstance().letsAntlr();
		System.out.println("Animatin'");
	}
}
