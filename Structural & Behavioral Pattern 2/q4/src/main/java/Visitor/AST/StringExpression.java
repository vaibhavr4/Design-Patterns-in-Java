package Visitor.AST;

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
	
	/**
	 * @return int
	 * to generate unique id for a Node
	 */
	@Override
	public int getId() {
		NodeFactory nf = NodeFactory.instance();
		return nf.getId(this);
	}
	
	/**
	 * accept for Visitor
	 */
	@Override
	public void accept(ASTVisitor v){
		v.visit(this);
		}
	
}
