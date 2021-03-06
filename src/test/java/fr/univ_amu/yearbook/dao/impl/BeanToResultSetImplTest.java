package fr.univ_amu.yearbook.dao.impl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.dao.IBeanToResultSet;
import fr.univ_amu.yearbook.dao.IPersonDAO;
import fr.univ_amu.yearbook.dao.exception.DAOException;
import fr.univ_amu.yearbook.dao.exception.DatabaseManagerException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_test.xml"})
public class BeanToResultSetImplTest {
	@Autowired
	IBeanToResultSet<Person> mapper;
	
	@Autowired
	IPersonDAO dao;
	
	@Test
	public void testInsertOrUpdate() throws DAOException, DatabaseManagerException {
		List<Person> p = (List<Person>) dao.findAllPersons();
		Person p1 = new Person();
		String[] parametersList = {"lastName", "firstName","email", "homePage", "birthDate", "pwd", "idG"};
		String query = "INSERT INTO YEARBOOK_Person (lastName, firstName, email, homepage, birthDate, pwd, idG)"
				+ "VALUES (?, ?, ?, ?, ?, PASSWORD(?), ?)";
		
		p1.setLastName("GATES");
		p1.setFirstName("Bill");
		p1.setEmail("bill.gates@localhost.fr");
		p1.setHomePage("www.bill_gates.fr");
		p1.setBirthDate(Date.valueOf("2016-01-01"));
		p1.setPwd("bill");
		p1.setIdG((long) 2);
		assertEquals (1, mapper.insertOrUpdate(p1, query, parametersList));
		
		dao.removePerson(p1);
		
		Person p2 = dao.findPerson(p.get(0).getId());
		String pwdTmp = p2.getEmail();
		p2.setEmail("new_mail@localhost.fr");
		String[] columnNameList = {"email", "id"};
		String queryUpdate = "UPDATE YEARBOOK_Person SET email = ? WHERE id = ?";
		int result = mapper.insertOrUpdate(p2, queryUpdate, columnNameList);
		assertEquals (1, result);
		assertNotEquals(-1, result);
		
		p2.setEmail(pwdTmp);
		String[] columnNameListBis = {"email", "id"};
		queryUpdate = "UPDATE YEARBOOK_Person SET email = ? WHERE id = ?";
		result = mapper.insertOrUpdate(p2, queryUpdate, columnNameListBis);
		assertEquals (1, result);
		assertNotEquals(-1, result);
	}

}
