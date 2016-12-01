package fr.univ_amu.yearbook.bus.loginManager.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.exception.ManagerException;
import fr.univ_amu.yearbook.bus.loginManager.ILoginManager;
import fr.univ_amu.yearbook.dao.IDatabaseManager;
import fr.univ_amu.yearbook.dao.IResultSetToBean;
import fr.univ_amu.yearbook.dao.exception.DAOException;
import fr.univ_amu.yearbook.dao.exception.DatabaseManagerException;
import fr.univ_amu.yearbook.dao.impl.ResultSetToBeanImpl;

/**
 * <b>LoginManagerImpl</b> est la classe qui implemente l'interface
 * {@link ILoginManager}.
 * 
 * Cette classe est caractérisée par :
 * <ul>
 * <li>Un objet qui crée une connection à la base de données.</li>
 * </ul>
 * 
 * @see Person
 * @see ManagerException
 * @see IDatabaseManager
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 * @version 1.0
 *
 */
@Service("loginManagerImpl")
public class LoginManagerImpl implements ILoginManager {
	
	/**
	 * L'objet qui établi la connection avec la base.
	 * 
	 * @see #personAssociedLoginPwd(String, String)
	 */
	@Autowired
	private IDatabaseManager dbManager;

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
		
		try (Connection conn = dbManager.newConnection()) {
			IResultSetToBean<Person> mapper = new ResultSetToBeanImpl<Person>(Person.class);
			
			String query = "SELECT * "
					+ "FROM YEARBOOK_Person "
					+ "WHERE email = ? AND pwd = PASSWORD(?)";			
			PreparedStatement st = conn.prepareStatement(query);
			
			st.setString(1, email);
			st.setString(2, pwd);
			
			ResultSet rs = st.executeQuery();
			
			if (rs.next())
				return mapper.toBean(rs);
			return null;
		} catch (SQLException | DatabaseManagerException | DAOException e){
			throw new ManagerException(e.getCause());
		}
	}
}
