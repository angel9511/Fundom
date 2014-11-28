// Generated from Funcode.g4 by ANTLR 4.2
package model;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FuncodeParser}.
 */
public interface FuncodeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FuncodeParser#position}.
	 * @param ctx the parse tree
	 */
	void enterPosition(@NotNull FuncodeParser.PositionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#position}.
	 * @param ctx the parse tree
	 */
	void exitPosition(@NotNull FuncodeParser.PositionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#operacion}.
	 * @param ctx the parse tree
	 */
	void enterOperacion(@NotNull FuncodeParser.OperacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#operacion}.
	 * @param ctx the parse tree
	 */
	void exitOperacion(@NotNull FuncodeParser.OperacionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(@NotNull FuncodeParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(@NotNull FuncodeParser.BodyContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#time}.
	 * @param ctx the parse tree
	 */
	void enterTime(@NotNull FuncodeParser.TimeContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#time}.
	 * @param ctx the parse tree
	 */
	void exitTime(@NotNull FuncodeParser.TimeContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#defining}.
	 * @param ctx the parse tree
	 */
	void enterDefining(@NotNull FuncodeParser.DefiningContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#defining}.
	 * @param ctx the parse tree
	 */
	void exitDefining(@NotNull FuncodeParser.DefiningContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#preaction}.
	 * @param ctx the parse tree
	 */
	void enterPreaction(@NotNull FuncodeParser.PreactionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#preaction}.
	 * @param ctx the parse tree
	 */
	void exitPreaction(@NotNull FuncodeParser.PreactionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#animate}.
	 * @param ctx the parse tree
	 */
	void enterAnimate(@NotNull FuncodeParser.AnimateContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#animate}.
	 * @param ctx the parse tree
	 */
	void exitAnimate(@NotNull FuncodeParser.AnimateContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(@NotNull FuncodeParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(@NotNull FuncodeParser.StartContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#direction}.
	 * @param ctx the parse tree
	 */
	void enterDirection(@NotNull FuncodeParser.DirectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#direction}.
	 * @param ctx the parse tree
	 */
	void exitDirection(@NotNull FuncodeParser.DirectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#defing}.
	 * @param ctx the parse tree
	 */
	void enterDefing(@NotNull FuncodeParser.DefingContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#defing}.
	 * @param ctx the parse tree
	 */
	void exitDefing(@NotNull FuncodeParser.DefingContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#action}.
	 * @param ctx the parse tree
	 */
	void enterAction(@NotNull FuncodeParser.ActionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#action}.
	 * @param ctx the parse tree
	 */
	void exitAction(@NotNull FuncodeParser.ActionContext ctx);

	/**
	 * Enter a parse tree produced by {@link FuncodeParser#steps}.
	 * @param ctx the parse tree
	 */
	void enterSteps(@NotNull FuncodeParser.StepsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FuncodeParser#steps}.
	 * @param ctx the parse tree
	 */
	void exitSteps(@NotNull FuncodeParser.StepsContext ctx);
}