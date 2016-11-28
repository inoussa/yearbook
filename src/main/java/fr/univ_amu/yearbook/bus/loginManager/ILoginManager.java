package fr.univ_amu.yearbook.bus.loginManager;

import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.exception.ManagerException;

/**
 * <b>ILoginManager</b> est l'interface qui gère le manager
 * Login.
 *
 * @see ManagerException
 *  
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 * @version 1.0
 *
 */
public interface ILoginManager {
	
	/**
	 * Renvoie la personne associée à l'email et au mot de passe.
	 * 
	 * @param email L'email de connexion.
	 * @param pwd Le mot de passe.
	 * @return La personne associée à l'email et au mot de passe ou NULL.
	 * @throws ManagerException Si une exception est levée.
	 */
	public Person personAssociedLoginPwd(String email, String pwd) throws ManagerException;
}
