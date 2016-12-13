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
import fr.univ_amu.yearbook.app.controller.validator.PasswordRecoverValidator;
import fr.univ_amu.yearbook.app.controller.validator.PersonValidator;
import fr.univ_amu.yearbook.bean.Group;
import fr.univ_amu.yearbook.bean.Person;
import fr.univ_amu.yearbook.bus.exception.ManagerException;
import fr.univ_amu.yearbook.bus.groupManager.IGroupManager;
import fr.univ_amu.yearbook.bus.loginManager.ILoginManager;
import fr.univ_amu.yearbook.bus.passwordRecover.IPasswordRecoverManager;
import fr.univ_amu.yearbook.bus.personManager.IPersonManager;

/**
 * <b>PersonController</b> est le controller qui gère les
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
	
	@Autowired
	Person person;
	
	@Autowired
    private IPersonManager pManager;
	
	@Autowired
    private IGroupManager gManager;
	
	@Autowired
    private ILoginManager lManager;
	
	@Autowired
    private LoginValidator loginValidator;
	
	@Autowired
    private PersonValidator personValidator;
	
	@Autowired
	private PasswordRecoverValidator pwdValidator;
	
	@Autowired
	private IPasswordRecoverManager pRecover;
    
	protected final Log logger = LogFactory.getLog(getClass());
	
	@ModelAttribute("person")
    public Person newPerson() {
		logger.info("La personne qui sera chargée en session");
        return person;
    }
	
	@ModelAttribute("listGroups")
    public Collection<Group> listGroupsMaking() {
		logger.info("La liste de tous les groupes de la bdd");
        return gManager.find();
    }
	
	@ModelAttribute("listPersons")
    Collection<Person> listPersonsMaking() throws ManagerException {
        logger.info("La liste de toutes les personnes de la bdd");
        return pManager.findAllPersons();
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable("id") Long id) throws ManagerException {
    	logger.info("L'id de la personne qui serra supprimer est : " + id);
    	
    	if (person.getId() == null)
    		return "redirect:../list";
    	
        person = pManager.findPerson(id);
        pManager.removePerson(person);
        return "redirect:../disconnect";
    }
	
	@RequestMapping(value = "/disconnect", method = RequestMethod.GET)
    public String disconnect() {
        logger.info("Déconnexion.");
        person = new Person();
        return "redirect:login";
    }
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPerson(@PathVariable("id") Long id) throws ManagerException {
    	logger.info("Envoyer la personne ayant pour id =" + id);
    	
    	if (person.getId() != null)
    		person = pManager.findPerson(id);
        return "personEdit";
    }
    
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editPerson(@ModelAttribute @Valid Person person, BindingResult result) throws ManagerException {	
    	personValidator.validate(person, result);
        if (result.hasErrors())
            return "personEdit";
        
        pManager.saveOrUpdatePerson(person);
        return "redirect:../list";
    }
    
    @RequestMapping(value = "/forgotPwd", method = RequestMethod.GET)
    public String reminderUser() {
    	logger.info("Envoi d'un nouveau mot de passe.");
        return "formForgotPwdUser";
    }
    
    @RequestMapping(value = "/forgotPwd", method = RequestMethod.POST)
    public String reminderUser(@ModelAttribute @Valid Person p, BindingResult result) throws ManagerException {
    	pwdValidator.validate(p, result);
        if (result.hasErrors())
            return "formForgotPwdUser";

    	boolean sendNewPwd = pRecover.sendNewPwd(p.getEmail());
		if (sendNewPwd) {
			return "redirect:login";
		}
    	return "redirect:forgotPwd";
    }
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listPersons() {
        logger.info("Retourne la page contenant la liste de toutes les personnes de la bdd");
        return "personsList";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
    	logger.info("Login");
        return "formLogin";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute @Valid Person p, BindingResult result) throws ManagerException {
    	loginValidator.validate(p, result);
    	if (result.hasErrors())
            return "formLogin";
        
        person = lManager.personAssociedLoginPwd(p.getEmail(), p.getPwd());
        if (person instanceof Person)
        	return "redirect:list";
        person = new Person();
        return "formLogin";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPerson() {
        return "formPersonRegister";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPerson(@ModelAttribute @Valid Person p, BindingResult result) throws ManagerException {
    	personValidator.validate(p, result);
        if (result.hasErrors()) {
            return "formPersonRegister";
        }
        pManager.saveOrUpdatePerson(p);
        return "redirect:login";
    }
    
    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public String showPerson(@PathVariable("id") Long id, Model model) throws ManagerException {
    	logger.info("Retourne la page contenant les informations de la personne dont l'id est : " + id);
    	Person pShowPerson = pManager.findPerson(id);
    	
    	if (pShowPerson != null)  {
        	model.addAttribute("pShowPerson", pShowPerson);
        	return "personShow";
        }
        return "redirect:../list";
    }
}