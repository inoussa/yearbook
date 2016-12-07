package fr.univ_amu.yearbook.bus.mailer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * The MailerImpl class is the default implementation of the {@link IMailer} interface.
 * @author ZONGO
 *@version 1.0
 */
@Service("maillerService")
@Primary
public class MailerImpl implements IMailer {
	
	final String HOST_PROPERTY = "host";
	final String SOCKET_FACTORY_PORT_PROPERTY = "socketFactory.port";
	final String SOCKET_FACTORY_CLASS_PROPERTY = "socketFactory.class";
	final String AUTH_PROPERTY = "auth";
	final String PORT_PROPERTY = "port";
	
	final String USERNAME_PROPERTY = "username";
	final String PASSWORD_PROPERTY = "password";
	
	/*
	 * The mail configuration file.
	 * The default configuration file is mail.properties.
	 */
	@Value("mail.properties")
	private String mailConfFile;
	
	private Session session;
	
	/**
	 * Default constructor.
	 */
	public MailerImpl() {
		
	}
	
	@PostConstruct
	public void init() throws MailerException{
		String host;
		String socketFactoryPort;
		String socketFactoryClass;
		String auth;
		String port;
		String username;
		String password;
		
		Properties mailProperties = new Properties();
		Properties properties = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream file = classLoader.getResourceAsStream(mailConfFile);
		
		if(file == null){
			throw new MailerException("file "+mailConfFile+" is missing");
		}
		
		try {
			properties.load(file);
			host = properties.getProperty(HOST_PROPERTY);
			socketFactoryPort = properties.getProperty(SOCKET_FACTORY_PORT_PROPERTY);
			socketFactoryClass = properties.getProperty(SOCKET_FACTORY_CLASS_PROPERTY);
			auth = properties.getProperty(AUTH_PROPERTY);
			port = properties.getProperty(PORT_PROPERTY);
			username = properties.getProperty(USERNAME_PROPERTY);
			password = properties.getProperty(PASSWORD_PROPERTY);
			
			mailProperties.setProperty("mail.smtp.host", host);
			mailProperties.setProperty("mail.smtp.socketFactory.port", socketFactoryPort);
			mailProperties.setProperty("mail.smtp.socketFactory.class", socketFactoryClass);
			mailProperties.setProperty("mail.smtp.auth", auth);
			mailProperties.setProperty("mail.smtp.port", port);
			
		} catch (IOException | NumberFormatException e) {
			throw new MailerException("Error when reading file"+mailConfFile,e);
		}
		
		session = Session.getDefaultInstance(mailProperties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username,password);
					}
				});
	}
	
	/**
	 * @see IMailer#send(Message)
	 */
	@Override
	public void send(Message message) throws MailerException {
		try {
			Transport.send(message);
		} catch (MessagingException e) {
			throw new MailerException(e.getMessage(),e);
		}
	}
	
	/**
	 * Envoie d'un email
	 * 
	 * @param to Email du destinataire
	 * @param subject Objet du message
	 * @param message Contenu du message
	 * @throws MailerException Si une exception empêche l'envoi du mail
	 */
	@Override
	public void send(String to, String subject, String message) throws MailerException {
		
		Session session = this.getSession();
		Message msg = new MimeMessage(session);
		try {
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
			msg.setSubject(subject);
			msg.setText(message);
		} catch (MessagingException e) {
			throw new MailerException(e.getCause());
		}
		send(msg);
	}

	/**
	 * returns the session
	 * @return the session.
	 */
	@Override
	public Session getSession() {
		return session;
	}
}
