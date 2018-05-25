package ast4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author VAIBHAV
 *
 */

/**
 * Represents an Operator
 * Returns any one of the operators ",-,*,/ as a string.
 */

public class Operator {
	

	String optrExp;
	/**
	 * creates an operator with given string of optr with constraints
	 * @param optr
	 */
	public Operator(String optr)
	{
		this.optrExp=optr;
	}
	
	/**
	 * 
	 * @return String
	 */
	public String textRepresentation()
	{
		
		List<String> optrList= new ArrayList<>();
		optrList.addAll(Arrays.asList("+","-","*","/"));
		
		if(optrList.contains(optrExp))
		{
			return optrExp;
		}
		
		else
		{
			try
			{
			throw new WrongInputException("Invalid operator");
			}
			catch(WrongInputException ex)
			{
			return "";
			}
		}
		
	}
	

}
