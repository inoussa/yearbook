package fr.univ_amu.yearbook.bus.passwordRecover.impl;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.exception.ManagerException;
import fr.univ_amu.yearbook.bus.mailer.IMailer;
import fr.univ_amu.yearbook.bus.passwordRecover.IPasswordRecoverManager;
import fr.univ_amu.yearbook.dao.IPersonDAO;
import fr.univ_amu.yearbook.dao.exception.DAOException;

/**
 * <b>PasswordRecoverImpl</b> implémente le manager IPasswordRecover.<br/>
 * Cette classe gère la génération et l'envoie d'un nouveau mot de passe
 * à un utilisateur donné.
 * 
 * @see IPersonDAO
 * @see IMailer
 * @see ManagerException
 *  
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 * @version 1.2
 *
 */
@Service("passwordRecoverManager")
public class PasswordRecoverManagerImpl implements IPasswordRecoverManager {
	
	/**
	 * Un objet de type IPersonDAO.
	 * 
	 * @see #sendNewPwd(String)
	 */
	@Autowired
	IPersonDAO pDao;
	
	/**
	 * Un objet de type IMailer.
	 * 
	 * @see #sendNewPwd(String)
	 */
	@Autowired
	IMailer mailer;
	
	/**
	 * Si l'email existe dans la bdd, un mail contenant le nouveau
	 * mot de passe est envoyé à la personne dont l'email est rentré en paramètre.
	 * 
	 * @param email L'email de la personne.
	 * @return True si le processus est exécuté correctement et false sinon.
	 * @throws ManagerException Si une exception est levée.
	 */
	@Override
	public boolean sendNewPwd(String email) throws ManagerException {

		try {
			boolean sendOk = false;
			Person p = pDao.findPerson(email);
			
			if (p != null){
				String subject = "YEARBOOK : Nouveau mot de passe";
				String message = "Bonjour, " + p.getFirstName() + " " + p.getLastName() + ". "
						+ "Votre nouveau mot de passe est : ";
				String newPwd = this.generatePwd();
				
				p.setPwd(newPwd);
				pDao.saveOrUpdatePerson(p);
			
				mailer.send(email, subject, message + newPwd);
				sendOk = true;
			}
			return sendOk;
		} catch (DAOException e) {
			throw new ManagerException(e.getCause());
		}
	}
	
	/**
	 * Génère un mot de passe de 20 caractères.
	 * 
	 * @return Le mot de passe généré.
	 */
	private String generatePwd() {
	
		Random rdmGen = new Random();
		String pattern = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	    String pwd = "";
	    
	    for (int i = 0; i < 20 ; i++) {
	    	int nbRdm = rdmGen.nextInt(62);
	    	pwd += pattern.charAt(nbRdm);
	    }
	    return pwd;
	}
}
