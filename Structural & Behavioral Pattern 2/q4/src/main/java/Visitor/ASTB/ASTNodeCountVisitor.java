package Visitor.ASTB;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * class that implements ASTVisitor to find the counts of node instantiation
 * @author VAIBHAV
 *
 */
public class ASTNodeCountVisitor implements ASTVisitor {

	private int assignCount = 0;
	private int declCount=0;
	private int infixCount=0;
	private int numexpCount=0;
	private int prefixCount=0;
	private int seqCount=0;
	private int varexpCount=0;
	private int stringexpCount=0;
	Logger logger = Logger.getLogger(NodeFactory.class.getName());
	ConsoleHandler handler = new ConsoleHandler();

	

	// getters for testing
	/**
	 * @return the assignCount
	 */
	public int getAssignCount() {
		return assignCount;
	}

	/**
	 * @return the declCount
	 */
	public int getDeclCount() {
		return declCount;
	}

	/**
	 * @return the infixCount
	 */
	public int getInfixCount() {
		return infixCount;
	}

	/**
	 * @return the numexpCount
	 */
	public int getNumexpCount() {
		return numexpCount;
	}

	/**
	 * @return the prefixCount
	 */
	public int getPrefixCount() {
		return prefixCount;
	}

	/**
	 * @return the seqCount
	 */
	public int getSeqCount() {
		return seqCount;
	}

	/**
	 * @return the varexpCount
	 */
	public int getVarexpCount() {
		return varexpCount;
	}

	/**
	 * @return the stringexpCount
	 */
	public int getStringexpCount() {
		return stringexpCount;
	}

	///////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * to increment count of Assignment when instantiated
	 * @param Assignment
	 * @see Visitor.AST.ASTVisitor#visit(Visitor.AST.Assignment)
	 */
	@Override
	public void visit(Assignment as) {
		assignCount++;	
	}
	
	/**
	 * to increment count of Declaration when instantiated
	 * @param Declaration
	 * @see Visitor.AST.ASTVisitor#visit(Visitor.AST.Declaration)
	 */
	@Override
	public void visit(Declaration dec) {
		declCount++;	
	}

	/**
	 * to increment count of Infix expression when instantiated
	 * @param InfixExpression
	 * @see Visitor.AST.ASTVisitor#visit(Visitor.AST.InfixExpression)
	 */
	@Override
	public void visit(InfixExpression infix) {
		infixCount++;		
	}

	/**
	 * to increment count of Number expression when instantiated
	 * @param NumberExpression
	 * @see Visitor.AST.ASTVisitor#visit(Visitor.AST.NumberExpression)
	 */
	@Override
	public void visit(NumberExpression numex) {
		numexpCount++;		
	}

	/**
	 * to increment count of Prefix expression when instantiated
	 * @param PrefixExpression
	 * @see Visitor.AST.ASTVisitor#visit(Visitor.AST.PrefixExpression)
	 */
	@Override
	public void visit(PrefixExpression prefix) {
		prefixCount++;	
	}

	/**
	 * to increment count of Sequence when instantiated
	 * @param Sequence
	 * @see Visitor.AST.ASTVisitor#visit(Visitor.AST.Sequence)
	 */
	@Override
	public void visit(Sequence seq) {
		seqCount++;	
	}

	/**
	 * to increment count of Variable expression when instantiated
	 * @param VariableExpression
	 * @see Visitor.AST.ASTVisitor#visit(Visitor.AST.VariableExpression)
	 */
	@Override
	public void visit(VariableExpression varex) {
		varexpCount++;	
	}

	/**
	 * to increment count of String expression when instantiated
	 * @param StringExpression
	 * @see Visitor.AST.ASTVisitor#visit(Visitor.AST.StringExpression)
	 */
	@Override
	public void visit(StringExpression strex) {
		stringexpCount++;	
	}

	/**
	 * to print the count to console
	 */
	public void report()
	{
		if(logger.isLoggable(Level.INFO)){
			logger.log(Level.INFO, String.format("The number of instances created for Assignment is: {%d}", this.assignCount));
			logger.log(Level.INFO, String.format("The number of instances created for Declaration is: {%d}", this.declCount));
			logger.log(Level.INFO, String.format("The number of instances created for Infix is: {%d}", this.infixCount));
			logger.log(Level.INFO, String.format("The number of instances created for NumberExpression is: {%d}", this.numexpCount));
			logger.log(Level.INFO, String.format("The number of instances created for Prefix is: {%d}", this.prefixCount));
			logger.log(Level.INFO, String.format("The number of instances created for Sequence is: {%d}", this.seqCount));
			logger.log(Level.INFO, String.format("The number of instances created for VariableExpression is: {%d}", this.varexpCount));
			logger.log(Level.INFO, String.format("The number of instances created for StringExpression is: {%d}", this.stringexpCount));
			}
		
	}

	
}
