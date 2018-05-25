package ast4;


/**
 * @author VAIBHAV
 *
 */
/**
 * Represents a Variable
 * Returns the given string
 */

public  class Variable
{
	String varExp;
	/**
	 * creates a Variable with the given String
	 * @param var
	 */
	public Variable(String var)
	{
		this.varExp=var;
	}
	
	
	/**
	 * @return String
	 */
	public String textRepresentation()
	{
		if(varExp.matches("[a-zA-Z][a-zA-Z0-9_]*"))
		{
			return this.varExp;
		}
		else
		{
			try
			{
			throw new WrongInputException("Invalid variable");
			}
			catch(WrongInputException ex)
			{
			return "";
			}
		}
	}
	
		
}
