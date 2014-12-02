// Generated from Funcode.g4 by ANTLR 4.2
package model;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import controller.MainController;

/**
 * This class provides an empty implementation of {@link FuncodeListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class FuncodeBaseListener implements FuncodeListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	List< String > variable = new LinkedList<>();
	List< Integer > variablex = new LinkedList<>();
	List< Integer > variabley = new LinkedList<>();
	String name;
	String accion;
	
	@Override public void enterPosition(@NotNull FuncodeParser.PositionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPosition(@NotNull FuncodeParser.PositionContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterOperacion(@NotNull FuncodeParser.OperacionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitOperacion(@NotNull FuncodeParser.OperacionContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBody(@NotNull FuncodeParser.BodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBody(@NotNull FuncodeParser.BodyContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterTime(@NotNull FuncodeParser.TimeContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitTime(@NotNull FuncodeParser.TimeContext ctx) { }

	/**
	 * Reads the incoming string and split it. Next take information referent to the insert block
	 * of the code. Can sent error messages and define the given figures. 
	 * 
	 */
	@Override public void enterDefining(@NotNull FuncodeParser.DefiningContext ctx) 
	{ 
		String a = ctx.getText();
		String s = "";
		for(int c = 0; c < a.length(); c++)
		{
			//System.out.println(s);
			if(a.charAt(c) == ':' && !s.equals("insertarposicion")){
				System.out.println(" | " + s);				
				variable.add(s);
				s = "";
			}
			else
				if(a.charAt(c)==':' && s.equals("insertarposicion"))
				{
					s="";
					c++;
					String futureInt = "" + a.charAt(c);
					while(c< a.length()-1 && (a.charAt(c+1) == '1' || a.charAt(c+1) == '2' || a.charAt(c+1) == '3' || a.charAt(c+1) == '4' || a.charAt(c+1) == '5' || a.charAt(c+1) == '6' || a.charAt(c+1) == '7' || a.charAt(c+1) == '8' || a.charAt(c+1) == '9' || a.charAt(c+1) == '0'))
					{
						c++;
						futureInt+= a.charAt(c);
					}
					variablex.add(Integer.parseInt(futureInt));
					c++;
					c++;
					futureInt = "" + a.charAt(c);
					System.out.println(c + "  " + a.length() + "  Wazzap! " + futureInt);
					while(c< a.length()-1 && (a.charAt(c+1) == '1' || a.charAt(c+1) == '2' || a.charAt(c+1) == '3' || a.charAt(c+1) == '4' || a.charAt(c+1) == '5' || a.charAt(c+1) == '6' || a.charAt(c+1) == '7' || a.charAt(c+1) == '8' || a.charAt(c+1) == '9' || a.charAt(c+1) == '0'))
					{
						c++;
						futureInt+= a.charAt(c);
					}
					variabley.add(Integer.parseInt(futureInt));
				}
				else
					s= s + a.charAt(c);
			if(s.equals("elementos"))
				s = "";	
		}
		System.out.println("ANTLEAER " + ctx.getText() + "\n" + variable+ "\n" + variablex + "\n" + variabley);
		for (int index = 0; index < variable.size(); index++)
			if (MainController.getInstance().validImage(variable.get(index)))
				MainController.getInstance().defineFigure(variable.get(index), variablex.get(index), variabley.get(index));
			else
				MainController.getInstance().setConsoleMsm("Imagen '"+variable.get(index)+ "' no se encuentra en la biblioteca\n");
				
		MainController.getInstance().runThreads();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDefining(@NotNull FuncodeParser.DefiningContext ctx) {
	}

	/**
	 *Read all the animation block and take all the information about it. Set the animation methods
	 *(move, tp, hide, show, wait) and can send error messages.
	 *
	 */
	@Override public void enterPreaction(@NotNull FuncodeParser.PreactionContext ctx) 
	{
		String a = ctx.getText();
		String s = "";
		String name;
		System.out.println(a);
		for(int c = 0; c < a.length(); c++)
		{
			if(a.charAt(c)== ':')
			{
				System.out.println("ce " + c + "|" + s);
				name = s;
				if(c+10 < a.length() && a.substring(0, c+10).contains("mover")){
					c = c+16;
					System.out.println(a.subSequence(c, c+9));
					if(c+9 < a.length() && a.substring(c, c+9).contains("derecha"))
					{
						c = c+13;
						int time = 0;
						String futureInt = "" + a.charAt(c);
						while((a.charAt(c+1) != 't' ))
						{
							c++;
							futureInt+= a.charAt(c);
						}
						c = c+8;
						String futureInt2 = "" + a.charAt(c);
						while(c+1< a.length() && (a.charAt(c+1) != 's' && a.charAt(c+1) != '+' && a.charAt(c+1) != '-'))
						{
							c++;
							futureInt2+= a.charAt(c);
						}
						c++;
						System.out.println("Za past " + futureInt);
						System.out.println("Za future " + futureInt2);
						time += Integer.parseInt(futureInt2);
						boolean plus = true;
						while(c+1< a.length() && (a.charAt(c) == '+' || a.charAt(c) == '-'))
						{
							plus = (a.charAt(c) == '+'); 
							c++;
							futureInt2 = "" + a.charAt(c);
							while(c+1< a.length() && (a.charAt(c+1) != 's' && a.charAt(c+1) != '+' && a.charAt(c+1) != '-'))
							{
								c++;
								futureInt2+= a.charAt(c);
							}
							c++;
							if(plus)
								time+=Integer.parseInt(futureInt2);
							else
								time-=Integer.parseInt(futureInt2);
						}
						if (time > 0)
							if (variable.contains(name))
								MainController.getInstance().moveFigure(name, Integer.parseInt(futureInt), 0,time);
							else
								MainController.getInstance().setConsoleMsm("La imagen '"+name+"' no ha sido insertada\n");
						else
							MainController.getInstance().setConsoleMsm("El tiempo debe ser positivo\n");
						c = a.length()+17;
					}
					if(c+9 < a.length() && a.substring(c, c+9).contains("izquierda"))
					{
						c = c+15;
						int time = 0;
						String futureInt = "" + a.charAt(c);
						while(c+1< a.length() && (a.charAt(c+1) != 't' ))
						{
							c++;
							futureInt+= a.charAt(c);
						}
						c = c+8;
						String futureInt2 = "" + a.charAt(c);
						while(c+1< a.length() && (a.charAt(c+1) != 's' && a.charAt(c+1) != '+' && a.charAt(c+1) != '-'))
						{
							c++;
							futureInt2+= a.charAt(c);
						}
						c++;
						time += Integer.parseInt(futureInt2);
						boolean plus = true;
						while(c+1< a.length() && (a.charAt(c) == '+'|| a.charAt(c) == '-'))
						{
							plus = (a.charAt(c) == '+'); 
							c++;
							futureInt2 = "" + a.charAt(c);
							while(c+1< a.length() &&(a.charAt(c+1) != 's' && a.charAt(c+1) != '+' && a.charAt(c+1) != '-'))
							{
								c++;
								futureInt2+= a.charAt(c);
							}
							c++;
							if(plus)
								time+=Integer.parseInt(futureInt2);
							else
								time-=Integer.parseInt(futureInt2);
						}
						if (time > 0)
							if (variable.contains(name))
								MainController.getInstance().moveFigure(name, -Integer.parseInt(futureInt), 0,time);																						
							else
								MainController.getInstance().setConsoleMsm("La imagen '"+name+"' no ha sido insertada\n");
						else
							MainController.getInstance().setConsoleMsm("El tiempo debe ser positivo\n");
						c = a.length()+17;
					}
					if(c+9 < a.length() && a.substring(c, c+9).contains("arriba"))
					{
						c = c+12;
						int time = 0;
						String futureInt = "" + a.charAt(c);
						while(c+1< a.length() && (a.charAt(c+1) != 't' ))
						{
							c++;
							futureInt+= a.charAt(c);
						}
						c = c+8;
						String futureInt2 = "" + a.charAt(c);
						while(c+1< a.length() && (a.charAt(c+1) != 's' && a.charAt(c+1) != '+' && a.charAt(c+1) != '-'))
						{
							c++;
							futureInt2+= a.charAt(c);
						}
						c++;
						time += Integer.parseInt(futureInt2);
						boolean plus = true;
						while(c+1< a.length() && (a.charAt(c) == '+'|| a.charAt(c) == '-'))
						{
							plus = (a.charAt(c) == '+'); 
							c++;
							futureInt2 = "" + a.charAt(c);
							while(c+1< a.length() && (a.charAt(c+1) != 's' && a.charAt(c+1) != '+' && a.charAt(c+1) != '-'))
							{
								c++;
								futureInt2+= a.charAt(c);
							}
							c++;
							if(plus)
								time+=Integer.parseInt(futureInt2);
							else
								time-=Integer.parseInt(futureInt2);
						}
						if (time > 0)
							if (variable.contains(name))
								MainController.getInstance().moveFigure(name, 0 ,  -Integer.parseInt(futureInt),time);															
								else
									MainController.getInstance().setConsoleMsm("La imagen '"+name+"' no ha sido insertada\n");
						else
							MainController.getInstance().setConsoleMsm("El tiempo debe ser positivo\n");
						c = a.length()+17;
					}
					if(c+9 < a.length() && a.substring(c, c+9).contains("abajo"))
					{
						c = c+11;
						int time = 0;
						String futureInt = "" + a.charAt(c);
						while(c+1< a.length() && (a.charAt(c+1) != 't' ))
						{
							c++;
							futureInt+= a.charAt(c);
						}
						c = c+8;
						String futureInt2 = "" + a.charAt(c);
						while(c+1< a.length() && (a.charAt(c+1) != 's' && a.charAt(c+1) != '+' && a.charAt(c+1) != '-'))
						{
							c++;
							futureInt2+= a.charAt(c);
						}
						c++;
						time += Integer.parseInt(futureInt2);
						boolean plus = true;
						while(c+1< a.length() && (a.charAt(c) == '+'|| a.charAt(c) == '-'))
						{
							plus = (a.charAt(c) == '+'); 
							c++;
							futureInt2 = "" + a.charAt(c);
							while(c+1< a.length() &&(a.charAt(c+1) != 's' && a.charAt(c+1) != '+' && a.charAt(c+1) != '-'))
							{
								c++;
								futureInt2+= a.charAt(c);
							}
							c++;
							if(plus)
								time+=Integer.parseInt(futureInt2);
							else
								time-=Integer.parseInt(futureInt2);
						}
						if (time > 0)
							if (variable.contains(name))
								MainController.getInstance().moveFigure(name, 0 , Integer.parseInt(futureInt),time);															
								else
									MainController.getInstance().setConsoleMsm("La imagen '"+name+"' no ha sido insertada\n");
						else
							MainController.getInstance().setConsoleMsm("El tiempo debe ser positivo \n");
						c = a.length()+17;
					}
					
				}
				else {
					if(c+10 < a.length() && a.substring(0, c+10).contains("ocultar")){
						c = c+7;
						if (variable.contains(name))
							MainController.getInstance().hideFigure(name);							
						else
							MainController.getInstance().setConsoleMsm("La imagen '"+name+"' no ha sido insertada\n");
						c = a.length()+17;
					}
					else{
						if(c+10 < a.length() && a.substring(0, c+10).contains("mostrar")){
							c = c+7;
							if (variable.contains(name))
								MainController.getInstance().showFigure(name);								
							else
								MainController.getInstance().setConsoleMsm("La imagen '"+name+"' no ha sido insertada\n");
							c = a.length()+17;
						}
						else{
							if(c+10 < a.length() && a.substring(0, c+10).contains("esperar")){
								c = c+15;
								String futureInt = "" + a.charAt(c);
								while(c< a.length()-1 && (a.charAt(c+1) == '1' || a.charAt(c+1) == '2' || a.charAt(c+1) == '3' || a.charAt(c+1) == '4' || a.charAt(c+1) == '5' || a.charAt(c+1) == '6' || a.charAt(c+1) == '7' || a.charAt(c+1) == '8' || a.charAt(c+1) == '9' || a.charAt(c+1) == '0'))
								{
									c++;
									futureInt+= a.charAt(c);
								}
								MainController.getInstance().waitFigure(name, Integer.parseInt(futureInt));
								c = a.length()+17;
							}
						}
					}
				}
				//if(a.c)
			}
			if(c< a.length())
				s += a.charAt(c);
		}
		System.out.println("Out of buggy 4");
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitPreaction(@NotNull FuncodeParser.PreactionContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAnimate(@NotNull FuncodeParser.AnimateContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAnimate(@NotNull FuncodeParser.AnimateContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterStart(@NotNull FuncodeParser.StartContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitStart(@NotNull FuncodeParser.StartContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDirection(@NotNull FuncodeParser.DirectionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDirection(@NotNull FuncodeParser.DirectionContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterDefing(@NotNull FuncodeParser.DefingContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDefing(@NotNull FuncodeParser.DefingContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterAction(@NotNull FuncodeParser.ActionContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitAction(@NotNull FuncodeParser.ActionContext ctx) 
	{
		String a = ctx.getText();
		System.out.println(a);
	}

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterSteps(@NotNull FuncodeParser.StepsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitSteps(@NotNull FuncodeParser.StepsContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(@NotNull TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
}