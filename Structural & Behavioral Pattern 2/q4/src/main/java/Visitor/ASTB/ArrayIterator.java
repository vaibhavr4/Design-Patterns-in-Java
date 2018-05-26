package Visitor.ASTB;


/**
 * @author VAIBHAV
 * this class implements the Iterator
 * @param <T>
 */
public class ArrayIterator<T> implements Iterator<T> {
	
	 T[] values;
	 int current=0;
	 int len;
	 /**
	  * constructor for the class which sets the value for array
	 * @param values
	 */
	public ArrayIterator(T[] values) {
	        this.values = values;
	    }

	/**
	 * @see Iterator#hasAnotherElement()
	 * return boolean
	 * it returns true if the array has another element
	 */
	@Override
	public boolean hasAnotherElement() {
			return this.values.length>current;
	}

	/**
	 * @see Iterator#nextElement()
	 * return T an object
	 * it returns the next element from the array
	 */
	@Override
	public T nextElement() {
		if(!hasAnotherElement())
			return null;
		return values[current++];
	}
	

}
