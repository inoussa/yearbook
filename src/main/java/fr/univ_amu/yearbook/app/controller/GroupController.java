package fr.univ_amu.yearbook.app.controller;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.univ_amu.yearbook.bean.Group;
import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.groupManager.IGroupManager;

@Controller
@RequestMapping("/group")
public class GroupController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	IGroupManager grMgr;
	
	@ModelAttribute("groups")
	public Collection<Group> groups(){
		return grMgr.find();
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String allGroup(){
		return "groupList";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String groupDetail(@PathVariable("id") Long id, Model model){
		Group group = null;
		Collection<Person> people = null;
		
		if(id != null) {
			group = grMgr.find(id);
			people = grMgr.getPersons(id);
		}
		
		model.addAttribute("group", group);
		model.addAttribute("people", people);
		
		return "groupShow";
	}	
}
