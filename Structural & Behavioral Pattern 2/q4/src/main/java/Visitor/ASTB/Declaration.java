package Visitor.ASTB;
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
	String varname;
	/**
	 * creates a Declaration of variable
	 * @param var
	 */
	public Declaration(Variable var)
	{
		this.varname=var.textRepresentation();
		if(var.textRepresentation()!="")
			this.declExp="var"+" "+var.textRepresentation()+";";
		else
			this.declExp="";
	}
	
	
	/**
	 * @return the varname
	 */
	public String getVarname() {
		return varname;
	}


	/**
	 * @return a String
	 */
	@Override
	public String textRepresentation() {
		
		return this.declExp;
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
	
	/**
	 * accept for Visitor
	 */
	public void accept(ASTVisitor v){
		v.visit(this);
		}
}
