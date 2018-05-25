package ast;
/**
 * 
 * @author VAIBHAV
 *
 */

/**
 * Represents an Declaration in a statement
 * Returns string in the format 'var' Variable
 */
public class Declaration implements Statement
{
	String declExp;
	/**
	 * creates a Declaration of variable
	 * @param var
	 */
	public Declaration(Variable var)
	{
		if(var.textRepresentation()!="")
			this.declExp="var"+" "+var.textRepresentation()+";";
		else
			this.declExp="";
	}
	
	
	/**
	 * @return a String
	 */
	@Override
	public String textRepresentation() {
		
		return this.declExp;
	}
	
	
}
