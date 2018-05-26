package Visitor.ASTB;

import Visitor.ASTB.Node;

/**
 * @author VAIBHAV
 *
 */

/**
 * 
 * Represents an interface Node which has an abstract method textRepresentation() and return String
 *
 */
public interface Node {
	/**
	 * @return String
	 */
	public abstract String textRepresentation();
	public abstract int getId();

	public void accept(ASTVisitor v);
	

}
