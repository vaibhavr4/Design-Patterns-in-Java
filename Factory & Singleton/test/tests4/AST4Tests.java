package tests4;

import static org.junit.Assert.*;

import org.junit.Test;

import ast4.Expression;
import ast4.NodeFactory;
import ast4.Operator;
import ast4.Statement;
import ast4.Variable;

/**
 * @author VAIBHAV
 * It tests all the class of package ast4
 */
public class AST4Tests {

	@Test
	public void test4() {
		NodeFactory factory = NodeFactory.instance();
		
		//test for Singleton pattern
		NodeFactory fact = NodeFactory.instance();
		assertEquals(factory,fact);

		Variable x= factory.makeVar("x");
		Operator plus= factory.makeOptr("+");
		Expression one= factory.makeNumExp(1);
		Expression two= factory.makeNumExp(2);
		Expression exp= factory.makeInfix(plus,one,two);
		Statement assign= factory.makeAssignmentVar(x,exp);		
		Statement decl= factory.makeDeclaration(x);
		Statement seq= factory.makeSeq(decl,assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
		
		//test case for variable
		/**
		 * {@link Variable}
		 */
		Variable y= factory.makeVar("y");
		assertEquals(y.textRepresentation(),"y");
		Variable num = factory.makeVar("1");
		assertEquals(num.textRepresentation(),"");
		Variable validNum = factory.makeVar("x1");
		assertEquals(validNum.textRepresentation(),"x1");
		
		
		//test case for variable expression
		/**
		 * {@link VariableExpression}
		 */
		Expression varex= factory.makeVarexp(y);
		assertEquals(varex.textRepresentation(), "y");
		Expression varex2 = factory.makeVarexp(x);
		Expression varex3 = factory.makeVarexp(num);
	
		//test case for String expression
		/**
		 * {@link StringExpression}
		 */
		Expression strex = factory.makeStringexp("x= a + b;");
		assertEquals(strex.textRepresentation(), "x= a + b;");
		Expression space = factory.makeStringexp(" ");
		assertEquals(space.textRepresentation()," ");
		Expression text = factory.makeStringexp("return y");
		assertEquals(text.textRepresentation(),"return y");
		Expression text2 = factory.makeStringexp("hello");
		
		//test case for Number expression
		/**
		 * {@link NumberExpression}
		 */
		assertEquals(one.textRepresentation(), "1");
		Expression oneDeci = factory.makeNumExp(2.4);
		assertEquals(oneDeci.textRepresentation(),"2");
		Expression negNum = factory.makeNumExp(-2);
		assertEquals(negNum.textRepresentation(),"-2");
		Expression negDeci = factory.makeNumExp(-3.4);
		assertEquals(negDeci.textRepresentation(),"-3");
		
		//test case for declaration
		/**
		 * {@link Declaration}
		 */
		assertEquals(decl.textRepresentation(), "var x;");
		Statement decl2= factory.makeDeclaration(y);
		assertEquals(decl2.textRepresentation(),"var y;");
		Statement decl3 = factory.makeDeclaration(num);
		assertEquals(decl3.textRepresentation(),"");
		
		//test case for operator
		/**
		 * {@link Operator}
		 */
		assertEquals(plus.textRepresentation(), "+");
		Operator comma= factory.makeOptr(",");
		assertEquals(comma.textRepresentation(),"");
		
		//test case for infix expression
		/**
		 * {@link InfixExpression}
		 */
		Expression exp5 = factory.makeInfix(plus,varex,varex2);
		assertEquals(exp5.textRepresentation(),"y + x");
		assertEquals(exp.textRepresentation(),"1 + 2");
		Expression exp6 = factory.makeInfix(plus,varex,one);
		assertEquals(exp6.textRepresentation(),"y + 1");
		Expression exp7 = factory.makeInfix(plus,exp5,two);
		assertEquals(exp7.textRepresentation(),"y + x + 2");
		Expression exp2 = factory.makeInfix(comma,one,two);
		assertEquals(exp2.textRepresentation(), "1  2");
		Expression exp4 = factory.makeInfix(plus,space,varex);
		assertEquals(exp4.textRepresentation(),"  + y");
		Expression exp8 = factory.makeInfix(plus,exp5,varex3);
		assertEquals(exp8.textRepresentation(),"y + x + ");

		//test cases for prefix expression
		/**
		 * {@link PrefixExpression}
		 */
		Expression exp3= factory.makePrefix(plus,one,two);
		assertEquals(exp3.textRepresentation(), "+ 1 2");
		Expression exp9 = factory.makePrefix(plus,varex,varex2);
		assertEquals(exp9.textRepresentation(),"+ y x");
		Expression exp10 = factory.makePrefix(plus,space,varex);
		assertEquals(exp10.textRepresentation(),"+   y");
		
		//test cases for assignment
		/**
		 * {@link Assignment}
		 */
		assertEquals(assign.textRepresentation(), "x = 1 + 2;");
		Statement assign2= factory.makeAssignmentVar(y,exp5);
		assertEquals(assign2.textRepresentation(),"y = y + x;");
		Statement assign3 = factory.makeAssignmentExp(exp5,one);
		assertEquals(assign3.textRepresentation(),"y + x = 1;");
		Statement assign4 = factory.makeAssignmentExp(exp5,space);
		assertEquals(assign4.textRepresentation(),"y + x = \" \";");
		Statement assign5 = factory.makeAssignmentExp(exp5,exp6);
		assertEquals(assign5.textRepresentation(),"y + x = y + 1;");
		Statement assign6= factory.makeAssignmentExp(space,exp5);
		assertEquals(assign6.textRepresentation(),"");
		Statement assign7 = factory.makeAssignmentVar(x,text2);
		assertEquals(assign7.textRepresentation(),"x = \"hello\";");
				
		//test cases for sequence
		/**
		 * {@link Sequence}
		 */
		Statement seq2= factory.makeSeq(assign,decl);
		assertEquals(seq2.textRepresentation(), "x = 1 + 2; var x;");
		Statement seq3= factory.makeSeq(decl,assign,decl2);
		assertEquals(seq3.textRepresentation(),"var x; x = 1 + 2; var y;");
		Statement seq4 = factory.makeSeq(seq3,assign2);
		assertEquals(seq4.textRepresentation(),"var x; x = 1 + 2; var y; y = y + x;");
		Statement seq5= factory.makeSeq(decl,decl2,assign,assign2);
		assertEquals(seq5.textRepresentation(),"var x; var y; x = 1 + 2; y = y + x;");
		
		// test case for report(number of instances created)
		/**
		 * {@link NodeFactory}
		 */
		assertEquals(factory.getAssignCount(),7);
		assertEquals(factory.getDeclCount(),3);
		assertEquals(factory.getInfixCount(),7);
		assertEquals(factory.getNumexpCount(),5);
		assertEquals(factory.getPrefixCount(),3);
		assertEquals(factory.getSeqCount(),5);
		assertEquals(factory.getVarexpCount(),3);
		assertEquals(factory.getStringexpCount(),4);
		Expression sample = factory.makeStringexp("test");
		assertEquals(sample.textRepresentation(),"test");
		factory.report();
		assertEquals(factory.getStringexpCount(),5);
		
	}

}
