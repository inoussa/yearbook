package fr.univ_amu.yearbook.bus.loginManager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.exception.ManagerException;
import fr.univ_amu.yearbook.bus.loginManager.ILoginManager;
import fr.univ_amu.yearbook.dao.IPersonDAO;
import fr.univ_amu.yearbook.dao.exception.DAOException;

/**
 * <b>LoginManagerImpl</b> est la classe qui implemente l'interface
 * {@link ILoginManager}.
 * 
 * Cette classe est caractérisée par :
 * <ul>
 * <li>Un objet de type IPersonDAO.</li>
 * </ul>
 * 
 * @see Person
 * @see ManagerException
 * @see IPersonManager
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 * @version 1.0
 *
 */
@Service("loginManagerImpl")
public class LoginManagerImpl implements ILoginManager {
	
	/**
	 * L'accès aux méthodes de la DAO.
	 * 
	 * @see #personAssociedLoginPwd(String, String)
	 */
	@Autowired
	private IPersonDAO personDAO;

	/**
	 * Renvoie la personne associée à l'email et au mot de passe.
	 * 
	 * @param email L'email de connexion.
	 * @param pwd Le mot de passe.
	 * @return La personne associée à l'email et au mot de passe ou NULL.
	 * @throws ManagerException Si une exception est levée.
	 */
	@Override
	public Person personAssociedLoginPwd(String email, String pwd) throws ManagerException {
		
			try {
				return personDAO.personAssociedLoginPwd(email, pwd);
			} catch (DAOException e) {
				throw new ManagerException(e.getCause());
			}
	}
}
