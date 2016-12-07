package fr.univ_amu.yearbook.bus.mailer;

import javax.mail.Message;
import javax.mail.Session;

/**
 * The IMailer interfaces gives methods to send email.
 * 
 * @author ZONGO
 * @version 1.0
 *
 */
public interface IMailer {
	/**
	 * sends a message.
	 * @param message the message to send.
	 * @throws MailerException
	 */
	public void send(Message message) throws MailerException;
	
	/**
	 * Envoie d'un email
	 * 
	 * @param to Email du destinataire
	 * @param subject Objet du message
	 * @param message Contenu du message
	 * @throws MailerException Si une exception empêche l'envoi du mail
	 */
	public void send(String to, String subject, String message) throws MailerException;
	
	/**
	 * 
	 * @return the session.
	 * @throws MailerException
	 */
	public Session getSession() throws MailerException;
}
