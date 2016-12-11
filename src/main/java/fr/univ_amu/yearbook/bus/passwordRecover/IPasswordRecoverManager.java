package fr.univ_amu.yearbook.bus.passwordRecover;

import fr.univ_amu.yearbook.bus.exception.ManagerException;

/**
 * <b>IPasswordRecover</b> est le manager qui gère l'envoi d'un nouveau mot de passe
 * à un utilisateur donné.
 * 
 * @see ManagerException
 *  
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 * @version 1.2
 *
 */
public interface IPasswordRecoverManager {

	/**
	 * Si l'email existe dans la bdd, un mail contenant le nouveau
	 * mot de passe est envoyé à la personne dont l'email est rentré en paramètre.
	 * 
	 * @param email L'email de la personne.
	 * @return True si le processus est exécuté correctement et false sinon.
	 * @throws ManagerException Si une exception est levée.
	 */
	public boolean sendNewPwd(String email) throws ManagerException;
}
