package sorters;

/**
 * class to sort objects of any type using heap sort
 * @author VAIBHAV
 *
 * @param <T>
 */
public class Sorter2<T extends Comparable<T>> implements Sorter<T>
{

    /**
     * sort array of any type T using the sift down method
     * @param array of type T
     */
    public void sort(T[] array)
    {
        heapSort(array);
    }

    /** 
     * sort array of type T using sift down method
     * @param array of type T
     */
    public void heapSort(T[] array)
    {
        heapify(array, array.length);
        int end = array.length - 1;
        while (end >= 0)
        {
            swap(array, end, 0);
            end--;
            siftDown(array, 0, end);
        }
        return;

    }

    /**
     * Swap two members of array
     * @param array of type T
     * @param first index of element to swap
     * @param second index of element to swap with first
     */
    private static <T extends Comparable<T>> T[] swap(T[] array, int first, int second)
    {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
        return array;
    }

    /**
     * Create a heap of array into max heap using sift down
     * @param array of type T
     * @param length of array of type integer
     */
    private void heapify(T[] array, int length)
    {
        int start = (length- 2)/2;
        while (start >= 0)
        {
            siftDown(array, start, length - 1);
            start--;
        }
        return;
    }

    
    /**
     * Sift Down
     * @param array of type T
     * @param start index of type integer
     * @param end index of type integer
     */
    private void siftDown(T[] array, int start, int end)
    {
        int root = start;
        while (root * 2 + 1 <= end)
        {
            int child = root * 2 + 1;
            int swap = root;
            if (compare(array[swap],array[child]) < 0)
            {
                swap = child;
            }
            if ((child + 1 <= end) && (compare(array[swap],array[child + 1]) < 0))
            {
                swap = child + 1;
            }
            if (swap==root)
            {
                return;
            }
            else
            {
                swap(array, root, swap);
                root = swap;
            }
        }
        return;
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
}
