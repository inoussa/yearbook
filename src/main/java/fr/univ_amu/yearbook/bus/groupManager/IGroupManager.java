package fr.univ_amu.yearbook.bus.groupManager;

import java.util.Collection;

import fr.univ_amu.yearbook.bean.Group;
import fr.univ_amu.yearbook.bean.Person;

/**
 * GroupManger is a service that offer methods to manage a {@link fr.univ_amu.yearbook.bean.Group Group}.
 * @author ZONGO
 *@version 1.0
 */
public interface IGroupManager {
	/**
	 * Returns the group whose identifer is given in parameter.
	 * @param id the identifier of the group.
	 * @return the group whose identifier is given in parameter.
	 * @throws GroupManagerException
	 */
	public Group find(Long id) throws GroupManagerException;
	
	/**
	 * Returns all groups from datasource.
	 * @return all group in datasource.
	 * @throws GroupManagerException
	 */
	public Collection<Group> find() throws GroupManagerException;
	
	/**
	 * This method is responsible of saving or updating a Group instance.<br>
	 * In case the id of the group is set, the method makes an update of the 
	 * group in datasource identified by the group id with the group in parameter.<br>
	 * If the id of the group is null, the method insert the group in datasource and return the group with its assigned identifier.<br>
	 * @param group the group to save or update
	 * @return the Group that have been saved.
	 * @throws GroupManagerException
	 */
	public Group saveOrUpdate(Group group) throws GroupManagerException;
	/**
	 * Removes the group identified by the parameter from datasource.
	 * @param id identifier of the group.
	 * @throws GroupManagerException
	 */
	public int delete(Long id) throws GroupManagerException;
	
	/**
	 * removes the group in parameter from datasource.
	 * @param group the group to delete.
	 * @throws GroupManagerException
	 */
	public int delete(Group group) throws GroupManagerException;
	
	
	/**
	 * Returns all the {@link fr.univ_amu.yearbook.bean.Person persons} in this group.
	 * @return all the {@link fr.univ_amu.yearbook.bean.Person persons} in this group.
	 * @throws GroupManagerException
	 */
	public Collection<Person> getPersons(Long id) throws GroupManagerException;
}
