package Sorter;
import java.util.Arrays;
/**
 * sorter stub for unit testing
 * @author VAIBHAV
 *
 * @param <T>
 */
public class SorterStub<T extends Comparable<T>> implements Sorter<T>{

	/**
	 * @param array of type T
	 */
	@Override
	public void sort(T[] list) {
		Arrays.sort(list);
	}


}
