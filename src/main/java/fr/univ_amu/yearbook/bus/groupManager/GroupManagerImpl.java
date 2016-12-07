package fr.univ_amu.yearbook.bus.groupManager;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univ_amu.yearbook.bean.Group;
import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.dao.IGroupDAO;
import fr.univ_amu.yearbook.dao.exception.DAOException;

@Service("groupManager")
public class GroupManagerImpl implements IGroupManager {
	@Autowired
	IGroupDAO groupDao;
	
	public GroupManagerImpl() {
		
	}

	@Override
	public Group find(Long id) throws GroupManagerException {
		try {
			return groupDao.find(id);
		} catch (DAOException e) {
			throw new GroupManagerException(e);
		}
	}

	@Override
	public Collection<Group> find() throws GroupManagerException {
		try {
			return groupDao.find();
		} catch (DAOException e) {
			throw new GroupManagerException(e);
		}
	}

	@Override
	public Group saveOrUpdate(Group group) throws GroupManagerException {
		try {
			return groupDao.saveOrUpdate(group);
		} catch (DAOException e) {
			throw new GroupManagerException(e);
		}
	}

	@Override
	public int delete(Long id) throws GroupManagerException {
		try {
			return groupDao.delete(id);
		} catch (DAOException e) {
			throw new GroupManagerException(e);
		}

	}

	@Override
	public int delete(Group group) throws GroupManagerException {
		try {
			return groupDao.delete(group);
		} catch (DAOException e) {
			throw new GroupManagerException(e);
		}
	}

	@Override
	public Collection<Person> getPersons(Long id) throws GroupManagerException {
		try {
			return groupDao.findPersons(id);
		} catch (DAOException e) {
			throw new GroupManagerException(e);
		}
	}

}
