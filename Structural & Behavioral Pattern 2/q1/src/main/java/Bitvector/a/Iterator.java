package Bitvector.a;
/**
 * 
 * @author VAIBHAV
 * this interface is yet to be implemented
 * @param <T>
 */
public interface Iterator<T> {

	/**
	 * @return boolean
	 */
	boolean hasAnotherElement();
	
	/**
	 * @return boolean
	 */
	T nextElement();
}
