package Visitor.ASTB;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import Visitor.ASTB.Node;
import Visitor.ASTB.NodeFactory;


/**
 * @author VAIBHAV
 *
 */

/**
 * NodeFactory is a factory pattern class to create different specialized nodes
 * such as Statement, Sequence, Assignment, NumberExpression etc.
 * It also consists of a report method which writes the number of times
 * an object is instantiated to the console.
 */

public class NodeFactory {
	
	private int assignCount = 0;
	private int declCount=0;
	private int infixCount=0;
	private int numexpCount=0;
	
	private int prefixCount=0;
	private int seqCount=0;
	
	private int varexpCount=0;
	private int stringexpCount=0;
	Logger logger = Logger.getLogger(NodeFactory.class.getName());
	ConsoleHandler handler = new ConsoleHandler();
	int id=0;
	
	private Node[] nodearray= new Node[1];
	
	
	
	private static NodeFactory factoryObj=null;
	private NodeFactory() {}
	int count=0;
	
	public static NodeFactory instance()
	{
		if(factoryObj == null)
		{
			factoryObj = new NodeFactory();
		}
		return factoryObj;
	}
	
	//getter methods for testing purpose
	
	/**
	 * @return the assignCount
	 */
	public int getAssignCount() {
		return assignCount;
	}
	
	/**
	 * @return the declCount
	 */
	public int getDeclCount() {
		return declCount;
	}

	/**
	 * @return the infixCount
	 */
	public int getInfixCount() {
		return infixCount;
	}

	/**
	 * @return the numexpCount
	 */
	public int getNumexpCount() {
		return numexpCount;
	}

	/**
	 * @return the prefixCount
	 */
	public int getPrefixCount() {
		return prefixCount;
	}

	/**
	 * @return the seqCount
	 */
	public int getSeqCount() {
		return seqCount;
	}

	/**
	 * @return the varexpCount
	 */
	public int getVarexpCount() {
		return varexpCount;
	}

	/**
	 * @return the stringexpCount
	 */
	public int getStringexpCount() {
		return stringexpCount;
	}


	/**
	 * @param var
	 * @param exp
	 * @return Assignment
	 */
	public Assignment makeAssignmentVar(Variable var, Expression exp)
	{
		assignCount++;
		Assignment tempNode = new Assignment(var,exp);
		putNode(tempNode);
		return tempNode;  
	}
	/**
	 * @param exp
	 * @param exp2
	 * @return Assignment
	 */
	public Assignment makeAssignmentExp(Expression exp, Expression exp2)
	{
		assignCount++;
		Assignment tempNode = new Assignment(exp,exp2);
		putNode(tempNode);
		return tempNode;
	}
	/**
	 * @param var
	 * @return Declaration
	 */
	public Declaration makeDeclaration(Variable var)
	{
		declCount++;
		Declaration tempNode = new Declaration(var);
		putNode(tempNode);
		return tempNode;
	}
	/**
	 * @param op
	 * @param num1
	 * @param num2
	 * @return InfixExpression
	 */
	public InfixExpression makeInfix(Operator op,Expression num1,Expression num2)
	{
		infixCount++;
		InfixExpression tempNode = new InfixExpression(op,num1,num2);
		putNode(tempNode);
		return tempNode;
	}
	/**
	 * @param num
	 * @return NumberExpression
	 */
	public NumberExpression makeNumExp(int num)
	{
		numexpCount++;
		NumberExpression tempNode = new NumberExpression(num);
		putNode(tempNode);
		return tempNode;
	}
	/**
	 * @param optr
	 * @return Operator
	 */
	public Operator makeOptr(String optr)
	{
		
		return new Operator(optr);
	}
	/**
	 * @param op
	 * @param num1
	 * @param num2
	 * @return PrefixExpression
	 */
	public PrefixExpression makePrefix(Operator op,Expression num1,Expression num2)
	{
		prefixCount++;
		PrefixExpression tempNode = new PrefixExpression(op,num1,num2);
		putNode(tempNode);
		return new PrefixExpression(op,num1,num2);
	}
	/**
	 * @param st
	 * @return Sequence
	 */
	public Sequence makeSeq(Statement ...st)
	{
		seqCount++;
		Sequence tempNode = new Sequence(st);
		putNode(tempNode);
		return tempNode;
	}
	/**
	 * @param exp
	 * @return StringExpression
	 */
	public StringExpression makeStringexp(String exp)
	{
		stringexpCount++;
		StringExpression tempNode = new StringExpression(exp);
		putNode(tempNode);
		return tempNode;
	}
	/**
	 * @param var
	 * @return Variable
	 */
	public Variable makeVar(String var)
	{
		return new Variable(var);
	}
	/**
	 * @param var
	 * @return VariableExpression
	 */
	public VariableExpression makeVarexp(Variable var)
	{
		varexpCount++;
		VariableExpression tempNode = new VariableExpression(var);
		putNode(tempNode);
		return tempNode;
	}
	
	/**
	 * Writes the number of instances created for each object to console
	 */
	public void report()
	{
		if(logger.isLoggable(Level.INFO)){
			logger.log(Level.INFO, String.format("The number of instances created for Assignment is: {%d}", this.assignCount));
			logger.log(Level.INFO, String.format("The number of instances created for Declaration is: {%d}", this.declCount));
			logger.log(Level.INFO, String.format("The number of instances created for Infix is: {%d}", this.infixCount));
			logger.log(Level.INFO, String.format("The number of instances created for NumberExpression is: {%d}", this.numexpCount));
			logger.log(Level.INFO, String.format("The number of instances created for Prefix is: {%d}", this.prefixCount));
			logger.log(Level.INFO, String.format("The number of instances created for Sequence is: {%d}", this.seqCount));
			logger.log(Level.INFO, String.format("The number of instances created for VariableExpression is: {%d}", this.varexpCount));
			logger.log(Level.INFO, String.format("The number of instances created for StringExpression is: {%d}", this.stringexpCount));
			}
		
	}
	
	/**
	 * used to add a node to an array	
	 * @param n
	 */
	public void putNode(Node n) {
		if (id<nodearray.length) {
			nodearray[id]=n;
		}
		else {
			Node[] temp= new Node[nodearray.length+1];
			int index=0;
			for(Node n1: nodearray) {
				temp[index] =n1;
				index++;
			}
			temp[index] =n;
			nodearray = temp;
		}
		id ++;
	}
	
	/**
	 * used to get a unique id for each Node created
	 * @param node
	 * @return int
	 */
	public int getId(Node node) {
		for (int i=0;i<nodearray.length;i++) 
		{
			if(nodearray[i] ==node) 
				return i;
		}
		return -1;
	}
	
	/**
	 * get the Node for a particular id
	 * @param id
	 * @return Node
	 */
	public Node getNode(int id) {
		if(id< nodearray.length) {
			return nodearray[id];
		}
		return null;
	}
	
	public void accept(ASTVisitor v){
		for (Node n : nodearray){
		n.accept(v);
		}
		}
}
