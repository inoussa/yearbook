package fr.univ_amu.yearbook.bus.groupManager;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.univ_amu.yearbook.bean.Group;
import fr.univ_amu.yearbook.bean.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_test.xml"})
public class GroupManagerImplTest {

	@Autowired
	IGroupManager groupMgr;

	@Test
	public void testFindLong() {
		Group group = groupMgr.find(1L);
		assertTrue(group != null);
		assertTrue(group.getId() == 1);
		assertEquals(group.getName(), "M2 FED 2015/2016");

		Group group2 = groupMgr.find(Long.MAX_VALUE);
		assertNull(group2);
	}

	@Test
	public void testFind() {
		Collection<Group> groups = groupMgr.find();
		assertEquals(groups.size(),9);
	}

	@Test
	public void testSaveOrUpdate() {
		Group group = new Group();
		Timestamp timestamp =  new Timestamp(System.currentTimeMillis());
		String groupName = "Group "+timestamp.toString();
		group.setName(groupName);
		Group savedGroup = groupMgr.saveOrUpdate(group);
		assertEquals(savedGroup.getName(), group.getName());
		assertNotNull(savedGroup.getId());

		Integer groupCount = groupMgr.find().size();
		assertEquals(groupCount, new Integer(10));

		//update the group
		String newName = "New group name";
		savedGroup.setName(newName);
		Group updatedGroup = groupMgr.saveOrUpdate(savedGroup);
		assertNotNull(updatedGroup);
		assertEquals(savedGroup.getName(), newName);

		//Cleaning db
		groupMgr.delete(updatedGroup.getId());
	}

	@Test
	public void testDeleteLong() {
		//Add a new group
		Timestamp timestamp =  new Timestamp(System.currentTimeMillis());
		String groupName = "Group "+timestamp.toString();
		Group group = new Group();
		group.setName(groupName);
		Long groupId = groupMgr.saveOrUpdate(group).getId();

		//Counting group
		Integer groupCount = groupMgr.find().size();

		//Deleting group
		int deleteStatus = groupMgr.delete(groupId);

		//Counting group
		Integer groupCount2 = groupMgr.find().size();

		assertTrue(deleteStatus == 1);
		assertTrue(groupCount2 == groupCount-1);

		//Deleting non existing group
		int deleteStatus2 = groupMgr.delete(groupId+1);
		assertTrue(deleteStatus2 == 0);
	}

	@Test
	public void testDeleteGroup() {
		//Add a new group
		Timestamp timestamp =  new Timestamp(System.currentTimeMillis());
		String groupName = "Group "+timestamp.toString();
		Group group = new Group();
		group.setName(groupName);
		Group savedGroup = groupMgr.saveOrUpdate(group);

		//Count row
		Integer groupCount = groupMgr.find().size();

		//Deleting group
		int deleteStatus = groupMgr.delete(savedGroup);

		//Counting group
		Integer groupCount2 = groupMgr.find().size();

		assertTrue(deleteStatus == 1);
		assertTrue(groupCount2 == groupCount-1);

		//Deleting non existing group
		Group fictifGroup = new Group();
		fictifGroup.setId(Long.MAX_VALUE);
		int deleteStatus2 = groupMgr.delete(fictifGroup);
		assertTrue(deleteStatus2 == 0);
	}

	@Test
	public void testGetPersons() {
		Collection<Person> persons = groupMgr.getPersons(1L);
		assertTrue(persons.size()==3);

		Collection<Person> persons2 = groupMgr.getPersons(7L);
		assertTrue(persons2.size()==1);

		Collection<Person> persons3 = groupMgr.getPersons(8L);
		assertTrue(persons3.isEmpty());
	}

}
