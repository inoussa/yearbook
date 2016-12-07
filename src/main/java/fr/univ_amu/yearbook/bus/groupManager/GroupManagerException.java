package fr.univ_amu.yearbook.bus.groupManager;

/**
 * GroupManagerException class is designed to represent and encapsulate 
 * the exceptions from the service GroupManager.
 * @author ZONGO
 * @version 1.0
 *
 */
public class GroupManagerException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.<br>
	 * Creates a new GroupManagerException by indicating its cause.
	 * @param source the source of the exception.
	 */
	public GroupManagerException(Throwable cause){
		super(cause);
	}
	
	/**
	 * Constructor.<br>
	 * Creates a new GroupManagerException by giving a message for the excepion.
	 * @param message the message for this this exception.
	 */
	public GroupManagerException(String message){
		super(message);
	}
	
	/**
	 * Constructor.<br>
	 * Creates a new GroupManagerException by giving a message and the cause of the exception.
	 * @param message the message fot this exception.
	 * @param cause the cause of of the exception.
	 */
	public GroupManagerException(String message, Throwable cause){
		super(message,cause);
	}

}
