package fr.univ_amu.yearbook.app.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Aboubacar Sidy DIALLO
 *
 */
@Controller
public class IndexControler {
    
    /**
     * 
     */
	protected final Log logger = LogFactory.getLog(getClass());
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {
		
		logger.debug("index()");
		model.addAttribute("redirect");
		return "redirect:/formLogin";
	}
}