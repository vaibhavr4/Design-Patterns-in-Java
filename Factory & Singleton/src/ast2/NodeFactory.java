package ast2;

/**
 * @author VAIBHAV
 *
 */

/**
 * NodeFactory is a factory pattern class to create different specialized nodes
 * such as Statement, Sequence, Assignment, NumberExpression etc.
 */

public class NodeFactory {
	
	
	/**
	 * @param var
	 * @param exp
	 * @return Assignment
	 */
	public Assignment makeAssignmentVar(Variable var, Expression exp)
	{
		
		return new Assignment(var,exp);
	}
	/**
	 * @param exp
	 * @param exp2
	 * @return Assignment
	 */
	public Assignment makeAssignmentExp(Expression exp, Expression exp2)
	{
		return new Assignment(exp,exp2);
	}
	/**
	 * @param var
	 * @return Declaration
	 */
	public Declaration makeDeclaration(Variable var)
	{
		
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
		return new InfixExpression(op,num1,num2);
	}
	/**
	 * @param num
	 * @return NumberExpression
	 */
	public NumberExpression makeNumExp(double num)
	{
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
		return new PrefixExpression(op,num1,num2);
	}
	/**
	 * @param st
	 * @return Sequence
	 */
	public Sequence makeSeq(Statement ...st)
	{
		return new Sequence(st);
	}
	/**
	 * @param exp
	 * @return StringExpression
	 */
	public StringExpression makeStringexp(String exp)
	{
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
		return new VariableExpression(var);
	}
	
	

}
