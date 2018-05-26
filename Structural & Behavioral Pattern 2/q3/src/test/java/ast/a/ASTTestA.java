package ast.a;

import static org.junit.Assert.*;

import org.junit.Test;

import ast.a.Expression;
import ast.a.NodeFactory;
import ast.a.NumberExpression;
import ast.a.Operator;
import ast.a.Statement;
import ast.a.Variable;

/**
 * unit test for getId and getNode for AST
 * @author VAIBHAV
 *
 */

public class ASTTestA {
	
	/**
	 * test case for getId() for a Node in ASTs
	 */
	@Test
	public void testgetId()
	{
		NodeFactory factory = NodeFactory.instance();
		Variable x= factory.makeVar("x");
		Operator plus= factory.makeOptr("+");
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		Expression exp= factory.makeInfix(plus,one,two);
		Statement assign= factory.makeAssignmentVar(x,exp);	
		Statement decl= factory.makeDeclaration(x);
		Statement seq= factory.makeSeq(decl,assign);
		assertEquals(4,one.getId());
		assertEquals(5,two.getId());
		assertEquals(7,assign.getId());
		assertEquals(9,seq.getId());
		Expression numex = new NumberExpression(3);
		assertEquals(-1,numex.getId());
	}
	
	/**
	 * test for getNode() when given an ID for a Node in ASTs
	 */
	@Test
	public void testgetNode()
	{
		NodeFactory factory = NodeFactory.instance();
		Variable x= factory.makeVar("x");
		Operator plus= factory.makeOptr("+");
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		Expression exp= factory.makeInfix(plus,one,two);
		Statement decl= factory.makeDeclaration(x);
		int declid = decl.getId();
		assertEquals(factory.getNode(declid),decl);
		int infixid = exp.getId();
		assertEquals(factory.getNode(infixid),exp);
		assertEquals(null,factory.getNode(50));
	}

}
