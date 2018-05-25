package ast;
/**
 * 
 * @author VAIBHAV
 *
 */

/**
 * Represents an InfixExpression in an Expression
 * Returns string in the format Expression Operator Expression
 */

public class InfixExpression implements Expression
{
	String infixExp;
	
	/**
	 * creates an infix expression with operator and expressions
	 * @param op
	 * @param num1
	 * @param num2
	 */
	public InfixExpression(Operator op,Expression num1,Expression num2)
	{
		this.infixExp= num1.textRepresentation()+" "+op.textRepresentation()+" "+num2.textRepresentation();
	}

	/**
	 * @return a String
	 */
	@Override
	public String textRepresentation()
	{
		return this.infixExp;
	}
		
}