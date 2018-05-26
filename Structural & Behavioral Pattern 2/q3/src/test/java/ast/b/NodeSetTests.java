package ast.b;

import org.junit.Test;

import ast.b.Expression;
import ast.b.NodeFactory;
import ast.b.NodeSet;
import ast.b.Operator;
import ast.b.Statement;
import ast.b.Variable;
import junit.framework.TestCase;

/**
 * unit test for NodeSet class
 * @author VAIBHAV
 *
 */
public class NodeSetTests extends TestCase {
	
	/**
	 * to test add and contains of the NodeSet
	 */
	@Test
	public void testaddcontains()
	{
		NodeSet s = new NodeSet();
		NodeFactory factory = NodeFactory.instance();
		Operator plus= factory.makeOptr("+");
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		Expression exp= factory.makeInfix(plus,one,two);
		s.add(one);
		s.add(two);
		assertTrue(s.contains(one));
		assertTrue(s.contains(two));
		assertFalse(s.contains(exp));
	}
	
	/**
	 * to test remove of the NodeSet
	 */
	@Test
	public void testremove()
	{
		NodeSet s = new NodeSet();
		NodeFactory factory = NodeFactory.instance();
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		s.add(one);
		s.add(two);
		s.remove(two);
		assertFalse(s.contains(two));
		assertEquals(1,s.size());
	}
	
	/**
	 * to test to string method
	 */

	@Test
	public void testtostring()
	{
		NodeSet t = new NodeSet();
		NodeFactory factory = NodeFactory.instance();
		Variable x= factory.makeVar("x");
		Expression three= factory.makeNumExp(3);
		Expression four= factory.makeNumExp(4);
		Statement decl= factory.makeDeclaration(x);
		t.add(three);
		t.add(four);
		t.add(decl);
		assertEquals("3,4,var x;",t.toString());
	}
	
	/**
	 * to test add al Nodes of NodeSet
	 */
	@Test
	public void testaddall()
	{
		NodeSet s = new NodeSet();
		NodeFactory factory = NodeFactory.instance();
		Variable x= factory.makeVar("x");
		Operator plus= factory.makeOptr("+");
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		Expression exp= factory.makeInfix(plus,one,two);
		Statement assign= factory.makeAssignmentVar(x,exp);	
		Statement decl= factory.makeDeclaration(x);
		Statement seq= factory.makeSeq(decl,assign);
		s.add(one);
		s.add(two);
		s.add(exp);
		s.add(seq);
		assertEquals(4,s.size());
		NodeSet t= new NodeSet();
		Expression three= factory.makeNumExp(3);
		Expression four= factory.makeNumExp(4);
		t.add(three);
		t.add(four);
		s.addAll(t);
		assertEquals(6,s.size());
		t.addAll(s);
		assertEquals(6,t.size());
	}
	
	
	/**
	 * to test iterator of the NodeSet
	 */
	@Test
	public void testiterator()
	{
		NodeSet s = new NodeSet();
		NodeFactory factory = NodeFactory.instance();
		Variable x= factory.makeVar("x");
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		Statement decl= factory.makeDeclaration(x);
		s.add(one);
		s.add(two);
		s.add(decl);
		Iterator<Node> in = s.iterator();
		assertTrue(in.hasAnotherElement());
		assertEquals(one,in.nextElement());
		s.remove(one);
		s.remove(two);
		s.remove(decl);
		while(in.hasAnotherElement())
			in.nextElement();
		assertFalse(in.hasAnotherElement());
		assertEquals(null,in.nextElement());
	}
	

}
