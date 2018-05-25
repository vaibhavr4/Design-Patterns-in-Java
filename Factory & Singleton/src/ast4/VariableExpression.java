package ast4;

/**
 * @author VAIBHAV
 *
 */

/**
 * Represents a VariableExpression in an Expression
 * Returns the given Variable as a String
 */

public class VariableExpression implements Expression
{
	String varExp;
	/**
	 * creates a VariableExpression with the given Variable
	 * @param var
	 */
	public VariableExpression(Variable var)
	{
		this.varExp=var.textRepresentation();
	}
	/* (non-Javadoc)
	 * @see ast.Expression#textRepresentation()
	 */
	@Override
	public String textRepresentation()
	{
		
		return this.varExp;
	}
}

