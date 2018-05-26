package Visitor.ASTB;

/**
 * @author VAIBHAV
 *
 */

/**
 * Represents an PrefixExpression in an Expression
 * Returns string in the format Operator Expression Expression
 */

public class PrefixExpression implements Expression
{
	
	String prefixExp;
	/**
	 * creates a prefix expression with operator and expressions
	 * @param op
	 * @param num1
	 * @param num2
	 */
	public PrefixExpression(Operator op,Expression num1,Expression num2)
	{
		this.prefixExp= op.textRepresentation()+" "+num1.textRepresentation()+" "+num2.textRepresentation();
	}
	/* (non-Javadoc)
	 * @see ast.Expression#textRepresentation()
	 */
	@Override
	public String textRepresentation()
	{
		return this.prefixExp;
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
