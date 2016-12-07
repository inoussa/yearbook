package fr.univ_amu.yearbook.bus.passwordRecover;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.exception.ManagerException;
import fr.univ_amu.yearbook.bus.personManager.IPersonManager;
import fr.univ_amu.yearbook.dao.exception.DAOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_test.xml"})
public class PasswordRecoverImplTest {

	@Autowired
	IPasswordRecover pwdRecover;
	
	@Autowired
	IPersonManager personManager;
	
	@Test
	public void testSendNewPwd() throws ManagerException, DAOException {
		List<Person> p = (List<Person>) personManager.findAllPersons();
		
		boolean test = pwdRecover.sendNewPwd(p.get(0).getEmail());
		assertTrue(test);
		
		String email = "notExistBDD@localhost.fr";
		test = pwdRecover.sendNewPwd(email);
		assertFalse(test);
	}

}
