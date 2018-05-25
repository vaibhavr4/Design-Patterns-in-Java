package ast4;

/**
 * @author VAIBHAV
 *
 */

/**
 * Represents an StringExpression in an Expression
 * Returns the given String
 */

public class StringExpression implements Expression
{
	String strExp;
	/**
	 * creates a STringExpression with the given String
	 * @param exp
	 */
	public StringExpression(String exp)
	{
		this.strExp=exp;
	}
	/* (non-Javadoc)
	 * @see ast.Expression#textRepresentation()
	 */
	@Override
	public String textRepresentation()
	{
		return this.strExp;
	}
	
}
