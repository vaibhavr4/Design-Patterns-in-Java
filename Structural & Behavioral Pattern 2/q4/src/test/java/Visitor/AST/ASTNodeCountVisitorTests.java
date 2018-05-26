package Visitor.AST;

import static org.junit.Assert.*;

import org.junit.Test;
import Visitor.AST.Expression;
import Visitor.AST.Operator;
import Visitor.AST.Statement;
import Visitor.AST.Variable;
import Visitor.AST.NodeFactory;

/**
 * to unit test ASTNodeCountVisitor
 * @author VAIBHAV
 *
 */
public class ASTNodeCountVisitorTests {

	/**
	 * to test the count of number of times a Node is instantiated
	 */
	@SuppressWarnings("unused")
	@Test
	public void testcount() {
		NodeFactory factory = NodeFactory.instance();
		Variable x= factory.makeVar("x");
		Operator plus= factory.makeOptr("+");
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		Expression exp= factory.makeInfix(plus,one,two);
		Statement assign= factory.makeAssignmentVar(x,exp);	
		Statement decl= factory.makeDeclaration(x);
		Statement seq= factory.makeSeq(decl,assign);
		ASTNodeCountVisitor visitor = new ASTNodeCountVisitor();
		factory.accept(visitor);
		visitor.report();
		assertEquals(2,visitor.getNumexpCount());
		assertEquals(0,visitor.getPrefixCount());
		assertEquals(1,visitor.getAssignCount());	
	}

}
