package ast.a;

import java.util.Arrays;
import java.util.List;
/**
 * 
 * @author VAIBHAV
 *
 */

/**
 * Represents an Assignment in a statement
 * Returns string in the format Variable = Expression
 */
public class Assignment implements Statement
{

	String assignExp;
	List<String> spaceList= Arrays.asList(""," ");
	/**
	 * Used to represent an assignment of an expression to a variable
	 * @param var
	 * @param exp
	 */
	public Assignment(Variable var, Expression exp)
	{
		
		if(exp instanceof StringExpression)
			this.assignExp=var.textRepresentation()+" "+"="+" "+"\""+exp.textRepresentation()+"\""+";";
		else
			this.assignExp= var.textRepresentation()+" "+"="+" "+exp.textRepresentation()+";";
	}
	/**
	 * 
	 * @param exp1
	 * @param exp2
	 */
	public Assignment(Expression exp1, Expression exp2)
	{
		
		if(exp2 instanceof StringExpression)
			this.assignExp=exp1.textRepresentation()+" "+"="+" "+"\""+exp2.textRepresentation()+"\""+";";
		else if(exp1 instanceof StringExpression)
			this.assignExp="";
		else
			this.assignExp= exp1.textRepresentation()+" "+"="+" "+exp2.textRepresentation()+";";
	}

	/**
	 * throws WrongInputException if the variable on left hand side is blank
	 * @return a String
	 */
	@Override
	public String textRepresentation()
	{
		if(this.assignExp.equals(""))
		{
			try
			{
			throw new WrongInputException("Invalid assignment");
			}
			
			catch(WrongInputException ex)
			{
			return "";
			}
		}
		else
			return this.assignExp;
	}
	
	/**
	 * @return int
	 * to generate unique id for a Node
	 */
	@Override
	public int getId() {
		NodeFactory nf = NodeFactory.instance();
		return nf.getId(this);
	}
	
}
