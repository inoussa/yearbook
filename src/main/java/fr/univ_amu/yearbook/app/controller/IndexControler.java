package fr.univ_amu.yearbook.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.univ_amu.yearbook.bean.Person;

/**
 * <b>IndexController</b> est le controleur qui
 * mappe la porte d'entrée de l'application.
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 *
 * @version 1.2
 */
@Controller
@RequestMapping(value = "/login.htm") 
public class IndexControler {
    
    /**
     * Le logger.
     * 
     * @see #login(Person)
     */
	protected final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * Fait la redirection à partir de la page d'acceuil vers la page
	 * de login et mot de passe de l'applciation.
	 * 
	 * @param p Une personne.
	 * @return La redirection vers le login.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String login(@ModelAttribute Person p) {
    	logger.info("Login");
        return "redirect:/actions/person/login";
    }
}