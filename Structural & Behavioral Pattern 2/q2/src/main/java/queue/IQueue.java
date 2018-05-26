package queue;
/**
* A generic queue
*/
public interface IQueue<T> {
/**
 * @return boolean
* add an element to the head of the queue
*/
boolean add(T t);
/**
* remove an element from the end of the queue. Returns null if queue is empty
*/
T remove();
/**
* returns the head of the queue. Returns null if queue is empty
*/
T peek();
}