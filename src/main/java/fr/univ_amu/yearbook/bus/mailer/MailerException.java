package fr.univ_amu.yearbook.bus.mailer;

/**
 * MailerException class is designed to represent and encapsulate 
 * the exceptions thrown when performing email operation.
 * 
 * @author ZONGO
 *@version 1.0
 */
public class MailerException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor.<br>
	 * Creates a new MailerException by indicating its cause.
	 * @param source the source of the exception.
	 */
	public MailerException(Throwable cause){
		super(cause);
	}
	
	/**
	 * Constructor.<br>
	 * Creates a new MailerException by giving a message for the excepion.
	 * @param message the message for this this exception.
	 */
	public MailerException(String message){
		super(message);
	}
	
	/**
	 * Constructor.<br>
	 * Creates a new MailerException by giving a message and the cause of the exception.
	 * @param message the message fot this exception.
	 * @param cause the cause of of the exception.
	 */
	public MailerException(String message, Throwable cause){
		super(message,cause);
	}
}

