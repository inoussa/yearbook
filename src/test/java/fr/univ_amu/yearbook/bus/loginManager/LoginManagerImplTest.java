package fr.univ_amu.yearbook.bus.loginManager;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.exception.ManagerException;
import fr.univ_amu.yearbook.bus.personManager.IPersonManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_test.xml"})
public class LoginManagerImplTest {

	@Autowired
	ILoginManager loginManager;
	
	@Autowired
	IPersonManager personManager;
	
	@Test
	public void testPersonAssociedLoginPwd() throws ManagerException {
		Person p = new Person();
		
		p.setLastName("JOBS");
		p.setFirstName("Steve");
		p.setEmail("steve.jobs@localhost.fr");
		p.setHomePage("www.steve_jobs.fr");
		p.setBirthDate(Date.valueOf("2016-01-01"));
		p.setPwd("steve");
		p.setIdG((long) 2);
		personManager.saveOrUpdatePerson(p);
		
		String email = "steve.jobs@localhost.fr";
		String pwd = "steve";
		
		Person p1 = loginManager.personAssociedLoginPwd(email, pwd);
		
		assertNotNull(p1);
		assertTrue("true", p1 instanceof Person);
		
		p1 = loginManager.personAssociedLoginPwd(email, "ceci n'est pas un mdp valide");
		assertNull(p1);
		assertFalse(p1 instanceof Person);
		
		p1 = loginManager.personAssociedLoginPwd("pas.valide@localhost.fr", "ceci n'est pas un mdp valide");
		assertNull(p1);
		assertFalse(p1 instanceof Person);
		
		personManager.removePerson(p);
	}
}