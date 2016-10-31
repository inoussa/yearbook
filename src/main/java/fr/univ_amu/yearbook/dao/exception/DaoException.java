package fr.univ_amu.yearbook.dao.exception;

/**
 * <b>DaoException</b> est la classe qui gère les différentes
 * exceptions liées à l'accès aux données.
 * 
 * @see Exception
 * 
 * @author Aboubacar Sidy DIALLO & Inoussa ZONGO
 * @version 1.0
 *
 */
public class DaoException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur par défaut de la classe DaoException.
	 */
	public DaoException() {
		super();
	}

	/**
	 * Constructeur de la classe DaoException.
	 * 
	 * @param message Le message à retourner.
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	 * Constructeur de la classe DaoException.
	 * 
	 * @param cause La cause de l'exception.
	 */
	public DaoException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructeur de la classe DaoException.
	 * 
	 * @param message Le message à retourner.
	 * @param cause La cause de l'exception.
	 */
	public DaoException(String message, Throwable cause) {
		super(message, cause);
	}
}