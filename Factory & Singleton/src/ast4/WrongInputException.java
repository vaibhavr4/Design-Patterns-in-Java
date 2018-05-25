package ast4;

/**
 * @author VAIBHAV
 *
 */

/**
 * Represents a user defined exception for wrong input
 * 
 */

public class WrongInputException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @param s
	 */
	public WrongInputException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }

}
