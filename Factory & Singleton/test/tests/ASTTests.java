package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ast.Assignment;
import ast.Declaration;
import ast.Expression;
import ast.InfixExpression;
import ast.NumberExpression;
import ast.Operator;
import ast.PrefixExpression;
import ast.Sequence;
import ast.Statement;
import ast.StringExpression;
import ast.Variable;
import ast.VariableExpression;

/**
 * @author VAIBHAV
 * It tests all the class of package ast
 */
public class ASTTests {

	
	@Test
	
	public void test1()
	{
		Variable x= new Variable("x");
		Operator plus= new Operator("+");
		Expression one= new NumberExpression(1);
		Expression two= new NumberExpression(2);
		Expression exp= new InfixExpression(plus,one,two);
		Statement assign= new Assignment(x,exp);		
		Statement decl= new Declaration(x);
		Statement seq= new Sequence(decl,assign);
		assertEquals(seq.textRepresentation(), "var x; x = 1 + 2;");
		
		//test case for variable
		/**
		 * {@link Variable}
		 */
		Variable y= new Variable("y");
		assertEquals(y.textRepresentation(),"y");
		Variable num = new Variable("1");
		assertEquals(num.textRepresentation(),"");
		Variable validNum = new Variable("x1");
		assertEquals(validNum.textRepresentation(),"x1");
		
		
		//test case for variable expression
		/**
		 * {@link VariableExpression}
		 */
		Expression varex= new VariableExpression (y);
		assertEquals(varex.textRepresentation(), "y");
		Expression varex2 = new VariableExpression(x);
		Expression varex3 = new VariableExpression(num);
	
		//test case for String expression
		/**
		 * {@link StringExpression}
		 */
		Expression strex = new StringExpression("x= a + b;");
		assertEquals(strex.textRepresentation(), "x= a + b;");
		Expression space = new StringExpression(" ");
		assertEquals(space.textRepresentation()," ");
		Expression text = new StringExpression("return y");
		assertEquals(text.textRepresentation(),"return y");
		Expression text2 = new StringExpression("hello");
		
		//test case for Number expression
		/**
		 * {@link NumberExpression}
		 */
		assertEquals(one.textRepresentation(), "1");
		Expression oneDeci = new NumberExpression(2.4);
		assertEquals(oneDeci.textRepresentation(),"2");
		Expression negNum = new NumberExpression(-2);
		assertEquals(negNum.textRepresentation(),"-2");
		Expression negDeci = new NumberExpression(-3.4);
		assertEquals(negDeci.textRepresentation(),"-3");
		
		//test case for declaration
		/**
		 * {@link Declaration}
		 */
		assertEquals(decl.textRepresentation(), "var x;");
		Statement decl2= new Declaration(y);
		assertEquals(decl2.textRepresentation(),"var y;");
		Statement decl3 = new Declaration(num);
		assertEquals(decl3.textRepresentation(),"");
		
		//test case for operator
		/**
		 * {@link Operator}
		 */
		assertEquals(plus.textRepresentation(), "+");
		Operator comma= new Operator(",");
		assertEquals(comma.textRepresentation(),"");
		
		//test case for infix expression
		/**
		 * {@link InfixExpression}
		 */
		Expression exp5 = new InfixExpression(plus,varex,varex2);
		assertEquals(exp5.textRepresentation(),"y + x");
		assertEquals(exp.textRepresentation(),"1 + 2");
		Expression exp6 = new InfixExpression(plus,varex,one);
		assertEquals(exp6.textRepresentation(),"y + 1");
		Expression exp7 = new InfixExpression(plus,exp5,two);
		assertEquals(exp7.textRepresentation(),"y + x + 2");
		Expression exp2 = new InfixExpression(comma,one,two);
		assertEquals(exp2.textRepresentation(), "1  2");
		Expression exp4 = new InfixExpression(plus,space,varex);
		assertEquals(exp4.textRepresentation(),"  + y");
		Expression exp8 = new InfixExpression(plus,exp5,varex3);
		assertEquals(exp8.textRepresentation(),"y + x + ");

		//test cases for prefix expression
		/**
		 * {@link PrefixExpression}
		 */
		Expression exp3= new PrefixExpression(plus,one,two);
		assertEquals(exp3.textRepresentation(), "+ 1 2");
		Expression exp9 = new PrefixExpression(plus,varex,varex2);
		assertEquals(exp9.textRepresentation(),"+ y x");
		Expression exp10 = new PrefixExpression(plus,space,varex);
		assertEquals(exp10.textRepresentation(),"+   y");
		
		//test cases for assignment
		/**
		 * {@link Assignment}
		 */
		assertEquals(assign.textRepresentation(), "x = 1 + 2;");
		Statement assign2= new Assignment(y,exp5);
		assertEquals(assign2.textRepresentation(),"y = y + x;");
		Statement assign3 = new Assignment(exp5,one);
		assertEquals(assign3.textRepresentation(),"y + x = 1;");
		Statement assign4 = new Assignment(exp5,space);
		assertEquals(assign4.textRepresentation(),"y + x = \" \";");
		Statement assign5 = new Assignment(exp5,exp6);
		assertEquals(assign5.textRepresentation(),"y + x = y + 1;");
		Statement assign6= new Assignment(space,exp5);
		assertEquals(assign6.textRepresentation(),"");
		Statement assign7 = new Assignment(x,text2);
		assertEquals(assign7.textRepresentation(),"x = \"hello\";");
				
		//test cases for sequence
		/**
		 * {@link Sequence}
		 */
		Statement seq2=new Sequence(assign,decl);
		assertEquals(seq2.textRepresentation(), "x = 1 + 2; var x;");
		Statement seq3= new Sequence(decl,assign,decl2);
		assertEquals(seq3.textRepresentation(),"var x; x = 1 + 2; var y;");
		Statement seq4 = new Sequence(seq3,assign2);
		assertEquals(seq4.textRepresentation(),"var x; x = 1 + 2; var y; y = y + x;");
		Statement seq5= new Sequence(decl,decl2,assign,assign2);
		assertEquals(seq5.textRepresentation(),"var x; var y; x = 1 + 2; y = y + x;");
			
		
	}
}
