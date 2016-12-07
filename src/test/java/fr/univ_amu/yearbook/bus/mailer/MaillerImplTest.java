package fr.univ_amu.yearbook.bus.mailer;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MaillerImplTest {
	
	@Autowired
	IMailer mailler;

	@Test
	public void testSend() throws AddressException, MessagingException {
		Session session = mailler.getSession();
		Message msg = new MimeMessage(session);
		msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse("zongoinoussa01@gmail.com"));
		msg.setSubject("Yearbook password recovery");
		msg.setText("Dear Mail Crawler," +"\n\n No spam to my email, please!");
		
		mailler.send(msg);
	}
	
	@Test
	public void testSendString() {
		String to = "sidediallo@yahoo.fr";
		String subject = "yearbook : envoi de mail ";
		String message = "Bonjour pour le bien de notre merveilleuse planète, merci de ne pas m'imprimer!!!";
		
		mailler.send(to, subject, message);
	}

}
