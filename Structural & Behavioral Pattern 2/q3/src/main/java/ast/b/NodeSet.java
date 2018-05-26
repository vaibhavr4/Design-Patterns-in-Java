package ast.b;

import ast.b.NodeFactory;

/**
 * @author VAIBHAV
* Class NodeSet represents a set of AST Nodes.
*
*/
public class NodeSet implements Set<Node> {
	private IBitVector adaptee = new BitVector();
	NodeFactory factory = NodeFactory.instance();
	private Node[] nodearray;
	String []strarray;
	
/**
 * to add a Node
 * @see ast.b.Set#add(java.lang.Object)
 * @param Node
 */
@Override 
public void add(Node n)
{
	
	adaptee.set(n.getId());
}

/**
 * add all nodes
 * @see ast.b.Set#addAll(ast.b.Set)
 * @param Set<Node>
 */
@Override 
public void addAll(Set<Node> n)
{ 
	Iterator<Node> itr = n.iterator();
	while(itr.hasAnotherElement())
	{
		adaptee.set(itr.nextElement().getId());
	}
}

/**
 * to remove a Node
 * @see ast.b.Set#remove(java.lang.Object)
 * @param Node
 */
@Override 
public void remove(Node n)
{ 
	adaptee.clear(n.getId());
}

/** to check if a Node is present
 * @see ast.b.Set#contains(java.lang.Object)
 * return boolean
 * @param Node
 */
@Override 
public boolean contains(Node n)
{
	return adaptee.get(n.getId()); 
}

/**
 * return number of nodes
 * @see ast.b.Set#size()
 * @return int
 */
@Override 
public int size()
{
	return adaptee.size(); 
}

/** to iterate over the set of nodes
 * @see ast.b.Set#iterator()
 * @return Iterator<Node>
 */
@Override 
public Iterator<Node> iterator()
{
	idToNode();
	return new ArrayIterator<>(nodearray);
	
}

/**
 * @return a set of Node
 */
public Node[] idToNode()
{
	Integer[] idarray = retrieveid();
	nodearray = new Node[idarray.length];
	for(int i=0;i<nodearray.length;i++)
		nodearray[i] = factory.getNode(idarray[i]);

	return nodearray;
	
}


/**
 * @return Integer[]
 * to return an array of node ids
 */
public Integer[] retrieveid()
{
	Integer[] temparray = new Integer[1];
	Iterator<Integer> itr = adaptee.iterator();
	for(int i=0;i<temparray.length;i++)
	{
		temparray[i] = itr.nextElement();
		if(itr.hasAnotherElement())
			temparray=resize(temparray.length+1,temparray);
	}
	
	return temparray;
	
}

/**
 * @param capacity
 * @param arr
 * @return Integer[]
 */
private Integer[] resize(int capacity, Integer[] arr)
{
    Integer[] tmp = new Integer[capacity];
    System.arraycopy(arr, 0, tmp, 0, arr.length);        
    arr = tmp;
    return arr;
}

/**
 * over ride toString method
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	idToNode();
	strarray = new String[nodearray.length];
	for(int i=0; i<strarray.length; i++)
		strarray[i]=nodearray[i].textRepresentation();
	return String.join(",", strarray);
}

}
