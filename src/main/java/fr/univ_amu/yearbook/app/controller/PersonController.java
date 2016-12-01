package fr.univ_amu.yearbook.app.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.univ_amu.yearbook.app.controller.validator.LoginValidator;
import fr.univ_amu.yearbook.app.controller.validator.PersonValidator;
import fr.univ_amu.yearbook.bean.Group;
import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.exception.ManagerException;
import fr.univ_amu.yearbook.bus.loginManager.ILoginManager;
import fr.univ_amu.yearbook.bus.personManager.IPersonManager;
import fr.univ_amu.yearbook.dao.IGroupDAO;
import fr.univ_amu.yearbook.dao.exception.DAOException;

/**
 * PersonController <br/> est le controller qui gère les
 * différentes actions éffectuées par une personne.
 * Ces actions peuvent être : l'authentification, lister les inscrits de l'annuaire,
 * modifier ces coordonnées, supprimer son compte, .....
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 *
 * @version 1.2
 */
@Controller
@RequestMapping("/person")
public class PersonController {

	/**
	 * Validateur du login.
	 * 
	 * @see #login(Person)
	 * @see #reminderUser(Person)
	 */
	@Autowired
    private LoginValidator loginValidator;
	
	/**
	 * Validateur des données d'inscriptions d'une personne.
	 * 
	 * @see #registerPerson(Person)
	 */
	@Autowired
    private PersonValidator personValidator;

	/**
	 * Manager d'une personnne
	 * 
	 * @see #
	 */
    @Autowired
    private IPersonManager pManager;
    
    /**
	 * Manager d'un groupe (Type à changer après maj github)
	 * 
	 * @see #
	 */
    @Autowired
    private IGroupDAO gManager;
    
    /**
     * Manager de l'authentification d'un utilisateur.
     * 
     * @see #
     */
    @Autowired
    private ILoginManager logManager;
    
    /**
     * 
     */
	protected final Log logger = LogFactory.getLog(getClass());
    
    /**
     * 
     * @return
     * @throws ManagerException
     */
    @ModelAttribute("people")
    Collection<Person> listPersonsMaking() throws ManagerException {
        logger.info("Making list of persons");
        return pManager.findAllPersons();
    }
    
    /**
     * 
     * @param id
     * @param model
     * @return
     * @throws ManagerException
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable("id") Long id, Model model) throws ManagerException {
        
    	logger.info("Running id controller with id =" + id);
        
        Person person = pManager.findPerson(id);
        
        if (person != null)  {
        	pManager.removePerson(person);
        	model.addAttribute("person", person);
        	return "formLogin";
        }
        return "redirect:../list";
    }
    
    /**
     * 
     * @param id
     * @param model
     * @return
     * @throws ManagerException
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable("id") Long id, Model model) throws ManagerException {
        
    	logger.info("Running id controller with id =" + id);
        
        Person person = pManager.findPerson(id);
        
        if (person != null)  {
        	model.addAttribute("person", person);
        	return "formPersonRegister";
        }
        return "redirect:../list";
    }
    
    /**
     * 
     * @param p
     * @return
     */
    @RequestMapping(value = "/forgotPwd", method = RequestMethod.GET)
    public String reminderUser(@ModelAttribute Person p) {
         return "formForgotPwdUser";
    }
    
    /**
     * 
     * @param p
     * @param result
     * @return
     * @throws ManagerException
     */
    @RequestMapping(value = "/forgotPwd", method = RequestMethod.POST)
    public String reminderUser(@ModelAttribute Person p, BindingResult result) throws ManagerException {
    	loginValidator.validate(p, result);
    	if (result.hasErrors()) {
            return "formForgotPwdUser";
        }
    	if (pManager.findPerson(p.getEmail()) != null)
    		return "redirect:login";
    	return "formForgotPwdUser";
    }
    
    /**
     * 
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPersons() {
        logger.info("List of persons");
        return "personsList";
    }
    
    /**
	 * 
	 * @param p
	 * @return
	 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute Person p) {
    	logger.info("Login");
        return "formLogin";
    }
    
    /**
     * 
     * @param p
     * @param result
     * @return
     * @throws ManagerException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid Person p, BindingResult result) throws ManagerException {
    	loginValidator.validate(p, result);
        if (result.hasErrors()) {
            return "formLogin";
        }
        
        Person person = logManager.personAssociedLoginPwd(p.getEmail(), p.getPwd());
        if (person instanceof Person)
        	return "redirect:list";
        return "formLogin";
    }
    
    /**
     * 
     * @param p
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPerson(@ModelAttribute @Valid Person p) {
        return "formPersonRegister";
    }
    
    /**
     * 
     * @param p
     * @param result
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPerson(@ModelAttribute @Valid Person p, BindingResult result) {
    	personValidator.validate(p, result);
        if (result.hasErrors()) {
            return "formPersonRegister";
        }
        return "formPersonRegister";
    }
    
    /**
     * 
     * @param id
     * @param model
     * @return
     * @throws ManagerException
     * @throws DAOException 
     */
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showPerson(@PathVariable("id") Long id, Model model) throws ManagerException, DAOException {
        
    	logger.info("Running id controller with id =" + id);
        
        Person person = pManager.findPerson(id);
        
        if (person != null)  {
        	Collection<Group> groups = gManager.find();
        	model.addAttribute("person", person);
        	model.addAttribute("groups", groups);
        	return "personShow";
        }
        return "redirect:../list";
    }
}