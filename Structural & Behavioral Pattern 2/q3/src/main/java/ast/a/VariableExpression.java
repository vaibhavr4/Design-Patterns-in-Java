package ast.a;

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
	
	/**
	 * @return int
	 * to generate unique id for a Node
	 */
	@Override
	public int getId() {
		NodeFactory nf = NodeFactory.instance();
		return nf.getId(this);
	}
}

