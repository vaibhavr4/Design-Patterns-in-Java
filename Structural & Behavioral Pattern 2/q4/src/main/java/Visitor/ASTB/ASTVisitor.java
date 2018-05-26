package Visitor.ASTB;

/**
 * an interface to implement Visitor pattern on nodes
 * @author VAIBHAV
 *
 */
public interface ASTVisitor {
		/**
		 * @param as
		 */
		public void visit(Assignment as);
		/**
		 * @param dec
		 */
		public void visit(Declaration dec);
		/**
		 * @param infix
		 */
		public void visit(InfixExpression infix);
		/**
		 * @param numex
		 */
		public void visit(NumberExpression numex);
		/**
		 * @param prefix
		 */
		public void visit(PrefixExpression prefix);
		/**
		 * @param seq
		 */
		public void visit(Sequence seq);
		/**
		 * @param varex
		 */
		public void visit(VariableExpression varex);
		/**
		 * @param strex
		 */
		public void visit(StringExpression strex);
}
