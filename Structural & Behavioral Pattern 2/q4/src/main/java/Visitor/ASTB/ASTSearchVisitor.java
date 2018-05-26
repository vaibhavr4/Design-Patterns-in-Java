package Visitor.ASTB;
/**
 * to implement Search of a variable name in Assignment and Declaration
 * @author VAIBHAV
 *
 */

public class ASTSearchVisitor implements ASTVisitor{

	String varcomp;
	Set<Node> ns;
	
	/**
	 * constructor for ASTSearchVisitor to initialize variables
	 * @param varcomp(String)
	 */
	public ASTSearchVisitor(String varcomp)
	{
		ns = new NodeSet();
		this.varcomp=varcomp;
	}
	
	/**
	 * constructor for ASTSearchVisitor to initialize variables
	 * @param varcomp(Variable)
	 */
	public ASTSearchVisitor(Variable varcomp)
	{
		ns = new NodeSet();
		this.varcomp=varcomp.textRepresentation();
	}
	/**
	 * compares the given variable name with the Assignment variable
	 * @param Assignment
	 */
	@Override
	public void visit(Assignment as) {
		if(this.varcomp.equals(as.getVarname()))
			ns.add(as);
	}

	/**
	 * compares the given variable name with Declaration variable
	 * @param Declaration
	 */
	@Override
	public void visit(Declaration dec) {
		if(this.varcomp.equals(dec.getVarname()))
			ns.add(dec);
	}

	@Override
	public void visit(InfixExpression infix) {
		//do nothing because the search is only for declaration and assignment
	}

	@Override
	public void visit(NumberExpression numex) {
		//do nothing because the search is only for declaration and assignment
	}

	@Override
	public void visit(PrefixExpression prefix) {
		//do nothing because the search is only for declaration and assignment
	}

	@Override
	public void visit(Sequence seq) {
		//do nothing because the search is only for declaration and assignment
	}

	@Override
	public void visit(VariableExpression varex) {
		//do nothing because the search is only for declaration and assignment
		
	}

	@Override
	public void visit(StringExpression strex) {
		//do nothing because the search is only for declaration and assignment
		
	}


}
