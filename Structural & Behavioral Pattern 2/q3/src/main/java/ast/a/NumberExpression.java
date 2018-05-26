package ast.a;

/**
 * @author VAIBHAV
 *
 */

/**
 * Represents an NumberExpression in an Expression
 * Returns string in the format String(Integer)
 */

public class NumberExpression implements Expression
{

	double numExp;
	/**
	 * creates a NumberExpression with given number
	 * @param num
	 */
	public NumberExpression(int num)
	{
		this.numExp=num;
	}
	/* (non-Javadoc)
	 * @see ast.Expression#textRepresentation()
	 */
	@Override
	public String textRepresentation()
	{
		return Integer.toString((int)this.numExp);
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
