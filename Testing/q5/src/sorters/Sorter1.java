package sorters;

/**
 * class to sort objects of any type using quick sort
 * @author VAIBHAV
 *
 * @param <T>
 */
public class Sorter1<T extends Comparable<T>> implements Sorter<T>{
	
	private T[] arr;

	/**
	 * sort array of any type T using the sift down method
     * @param array of type T
	 */
	@Override
	public void sort(T[] arr) {
		this.arr = arr;
		quicksort(0, arr.length - 1);
	}
	
	/**
	 * compare two objects
	 * @param o1 of type T
	 * @param o2 of type T
	 * @return integer as a result of comparison
	 */
	public int compare(T o1, T o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.compareTo(o2);
    }
	
	/**
	 * sort using quick sort
	 * @param left of type integer
	 * @param right of type integer
	 */
		
	private void quicksort(int left, int right) {
		
		if(left >= right) {
			return;
		}
		
		T pivot = arr[left + (right - left)/2];
		
		int i = left;
		int j = right;
		
		while (i <= j) {
			
			while((compare(arr[i],pivot)) < 0) {
				i++;
			}
			
			while((compare(arr[j],pivot)) > 0) {				
				j--;
			}
			
			if(i <= j) {
				swap(i, j);
				i++;
				j--;
			}
		}
		quicksort(left, j);
		quicksort(i, right);
	}
	
	/**
	 * swap two integers
	 * @param a of type integer
	 * @param b of type integer
	 */
	
	private void swap(int a, int b) {
		T x = arr[a];
		arr[a] = arr[b];
		arr[b] = x;
	}

}

