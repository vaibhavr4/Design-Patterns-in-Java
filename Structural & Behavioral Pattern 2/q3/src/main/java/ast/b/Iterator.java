package ast.b;

/**
 * @author VAIBHAV
 * this interface is used to implement the iterator
 * @param <T>
 */
public interface Iterator<T> {

	/**
	 * @return boolean
	 */
	boolean hasAnotherElement();
	
	/**
	 * @return T the object
	 */
	T nextElement();
}
