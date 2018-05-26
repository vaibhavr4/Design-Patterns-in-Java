package Visitor.ASTB;

import java.util.StringJoiner;

/**
 * @author VAIBHAV
 *
 */

/**
 * Represents an Sequence in a Statement
 * Returns a sequence of Statement.
 */

public class Sequence implements Statement
{
	StringJoiner seqExp=new StringJoiner(" ");
	/**
	 * creates a sequence of statements
	 * @param st
	 */
	public Sequence(Statement ...st)
	{
		for (Statement i: st)
			seqExp.add(i.textRepresentation());
			
	}
	/* (non-Javadoc)
	 * @see ast.Statement#textRepresentation()
	 */
	@Override
	public String textRepresentation() {
		
		return this.seqExp.toString();
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
