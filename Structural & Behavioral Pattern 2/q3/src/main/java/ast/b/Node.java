package ast.b;

import ast.b.Node;

/**
 * @author VAIBHAV
 * to implement textRepresentation() and id for nodes
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
	
	/**
	 * to get unique id for nodes
	 * @return int
	 */
	public abstract int getId();

}
