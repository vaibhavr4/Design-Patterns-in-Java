package queue;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VAIBHAV
 * this class implements the operation of queue using ArrayList
 *
 * @param <T>
 */
public class Queue<T> implements IQueue<T> {
	
	List<T> queuelist = new ArrayList<>();
	/**
	 * @param queuelist
	 * constructor for the class which sets the value of array list
	 */
	public Queue(List<T> queuelist)
	{
		this.queuelist=queuelist;
	}
	/**
	 * @see IQueue#add(java.lang.Object)
	 * @return boolean
	 * returns true if the element has been successfully added into the queue
	 */
	@Override
	public boolean add(T t) {
		queuelist.add(0, t);
		return true;
	}

	/**
	 * @see IQueue#remove()
	 * @return T (object)
	 * returns the queue with an element removed from the tail of queue
	 */
	@Override
	public T remove() {
		try
		{
		T t = queuelist.get(queuelist.size()-1);
		queuelist.remove(t);
		return t;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	/**
	 * @see IQueue#peek()
	 * @return T(object)
	 * returns an element from head of the queue
	 */
	@Override
	public T peek() {
		if(!queuelist.isEmpty())
			return queuelist.get(0);
		return null;
	}

}
