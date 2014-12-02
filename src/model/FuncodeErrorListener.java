package model;

import org.antlr.v4.runtime.*;

import controller.MainController;

public class FuncodeErrorListener extends BaseErrorListener {

	/**
	 * Special errorlistener. This method redirects the form to print a error on
	 * ANTLR. The message is printed on the console.
	 */
	@Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg,
                            RecognitionException e)
    {
        MainController.getInstance().setConsoleMsm("linea "+line+":"+charPositionInLine+" error: "+msg+"\n");
    }

}
