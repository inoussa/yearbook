package fr.univ_amu.yearbook.dao.exception;

/**
 * DatabaseManagerException class is designed to represent and encapsulate the exceptions from the 
 * differents operations to database.
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 *	@version 1.0
 */
public class DatabaseManagerException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.<br>
	 * Creates a new DatabaseManagerException by indicating its cause.
	 * @param cause the source of the exception.
	 */
	public DatabaseManagerException(Throwable cause){
		super(cause);
	}
	
	/**
	 * Constructor.<br>
	 * Creates a new DatabaseManagerException by giving a message for the excepion.
	 * @param message the message for this this exception.
	 */
	public DatabaseManagerException(String message){
		super(message);
	}
	
	/**
	 * Constructor.<br>
	 * Creates a new DatabaseManagerException by giving a message and the cause of the exception.
	 * @param message the message fot this exception.
	 * @param cause the cause of of the exception.
	 */
	public DatabaseManagerException(String message, Throwable cause){
		super(message,cause);
	}
}
