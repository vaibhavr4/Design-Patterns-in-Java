package queue;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
/**
 * 
 * @author VAIBHAV
 * class to unit test Queue implementation
 */
public class QueueTests {

	/**
	 * method to test add() of Queue class
	 */
	@Test
	public void testadd() {
		List<Integer> al = new ArrayList<Integer>();
		Queue<Integer> q = new Queue<Integer>(al);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		assertEquals(4,al.size());
		assertEquals(0,al.indexOf(4));
		assertEquals(3,al.indexOf(1));
	}
	
	/**
	 * method to test remove of Queue class
	 */
	@Test
	public void testremove()
	{
		List<Integer> al = new ArrayList<Integer>();
		Queue<Integer> q = new Queue<Integer>(al);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		q.remove();
		assertEquals(3,al.size());
		assertEquals(0,al.indexOf(4));
		assertEquals(2,al.indexOf(2));
		assertEquals(-1,al.indexOf(1));
		for(int i=0;i<3;i++)
			q.remove();
		assertEquals(null,q.remove());
		
	}
	
	/**
	 * method to test peek of Queue class
	 */
	@Test
	public void testpeek()
	{
		List<Integer> al = new ArrayList<Integer>();
		Queue<Integer> q = new Queue<Integer>(al);
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		assertEquals(4,q.peek().intValue());
		q.add(5);
		assertEquals(5,q.peek().intValue());
		for(int i=0;i<5;i++)
			q.remove();
		assertEquals(null,q.peek());
		

	}
}

