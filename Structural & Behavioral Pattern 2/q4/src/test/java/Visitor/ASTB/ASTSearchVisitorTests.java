package Visitor.ASTB;

import static org.junit.Assert.*;

import org.junit.Test;

import Visitor.ASTB.ASTNodeCountVisitor;
import Visitor.ASTB.Expression;
import Visitor.ASTB.NodeFactory;
import Visitor.ASTB.Operator;
import Visitor.ASTB.Statement;
import Visitor.ASTB.Variable;

/**
 * unit test for ASTSearchVisitor
 * @author VAIBHAV
 *
 */
public class ASTSearchVisitorTests {

	/**
	 * to test ASTSearchVisitor
	 */
	@SuppressWarnings("unused")
	@Test
	public void testSearch() {
		NodeFactory factory = NodeFactory.instance();
		Variable x= factory.makeVar("x");
		Variable y = factory.makeVar("y");
		Operator plus= factory.makeOptr("+");
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		Expression exp= factory.makeInfix(plus,one,two);
		Statement assign= factory.makeAssignmentVar(x,exp);	
		Statement assign2 = factory.makeAssignmentVar(y, exp);
		Statement decl= factory.makeDeclaration(x);
		Statement seq= factory.makeSeq(decl,assign);
		ASTSearchVisitor visitor = new ASTSearchVisitor("x");
		factory.accept(visitor);
		
		assertTrue(visitor.ns.contains(assign));
		assertTrue(visitor.ns.contains(decl));
		assertFalse(visitor.ns.contains(one));	
		assertFalse(visitor.ns.contains(assign2));	
		
		ASTSearchVisitor visitor2 = new ASTSearchVisitor(x);
		factory.accept(visitor2);
		assertTrue(visitor2.ns.contains(assign));
		assertTrue(visitor2.ns.contains(decl));
		assertFalse(visitor2.ns.contains(one));	
		assertFalse(visitor2.ns.contains(assign2));	
		
		ASTNodeCountVisitor visitor3 = new ASTNodeCountVisitor();
		factory.accept(visitor3);
		visitor3.report();
		assertEquals(2,visitor3.getNumexpCount());
		assertEquals(0,visitor3.getPrefixCount());
		
	}

}
