package ast.a;


/**
 * @author VAIBHAV
 *
 */

/**
 * 
 * Represents an interface Node which has an abstract method textRepresentation() and return String
 * a method getNode to get the node from id and an abstract getId() method
 */
public interface Node {
	/**
	 * @return String
	 */
	public abstract String textRepresentation();
	/**
	 * get unique id for a Node
	 * @return int
	 */
	public abstract int getId();
	

}
