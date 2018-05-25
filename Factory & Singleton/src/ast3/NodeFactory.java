package ast3;


import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author VAIBHAV
 *
 */

/**
 * NodeFactory is a factory pattern class to create different specialized nodes
 * such as Statement, Sequence, Assignment, NumberExpression etc.
 * It also consists of a report method which writes the number of times
 * an object is instantiated to the console.
 */

public class NodeFactory {
	
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
	
	//getter methods for testing purpose
	
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


	/**
	 * @param var
	 * @param exp
	 * @return Assignment
	 */
	public Assignment makeAssignmentVar(Variable var, Expression exp)
	{
		assignCount++;
		return new Assignment(var,exp);  
	}
	/**
	 * @param exp
	 * @param exp2
	 * @return Assignment
	 */
	public Assignment makeAssignmentExp(Expression exp, Expression exp2)
	{
		assignCount++;
		return new Assignment(exp,exp2);
	}
	/**
	 * @param var
	 * @return Declaration
	 */
	public Declaration makeDeclaration(Variable var)
	{
		declCount++;
		return new Declaration(var);
	}
	/**
	 * @param op
	 * @param num1
	 * @param num2
	 * @return InfixExpression
	 */
	public InfixExpression makeInfix(Operator op,Expression num1,Expression num2)
	{
		infixCount++;
		return new InfixExpression(op,num1,num2);
	}
	/**
	 * @param num
	 * @return NumberExpression
	 */
	public NumberExpression makeNumExp(double num)
	{
		numexpCount++;
		return new NumberExpression(num);
	}
	/**
	 * @param optr
	 * @return Operator
	 */
	public Operator makeOptr(String optr)
	{
		
		return new Operator(optr);
	}
	/**
	 * @param op
	 * @param num1
	 * @param num2
	 * @return PrefixExpression
	 */
	public PrefixExpression makePrefix(Operator op,Expression num1,Expression num2)
	{
		prefixCount++;
		return new PrefixExpression(op,num1,num2);
	}
	/**
	 * @param st
	 * @return Sequence
	 */
	public Sequence makeSeq(Statement ...st)
	{
		seqCount++;
		return new Sequence(st);
	}
	/**
	 * @param exp
	 * @return StringExpression
	 */
	public StringExpression makeStringexp(String exp)
	{
		stringexpCount++;
		return new StringExpression(exp);
	}
	/**
	 * @param var
	 * @return Variable
	 */
	public Variable makeVar(String var)
	{
		
		return new Variable(var);
	}
	/**
	 * @param var
	 * @return VariableExpression
	 */
	public VariableExpression makeVarexp(Variable var)
	{
		varexpCount++;
		return new VariableExpression(var);
	}
	
	/**
	 * Writes the number of instances created for each object to console
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
