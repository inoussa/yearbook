package fr.univ_amu.yearbook.app.controller.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.univ_amu.yearbook.bean.Person;

/**
 * LoginValidator gère la validation des données rentrées par
 * un utilisateur lors de son authentification.
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 *
 * @version 1.2
 */
@Service("loginValidator")
public class LoginValidator implements Validator {
	
	/**
	 * @param clazz Le type entré en paramètre.
	 * @return True si le type correspond au type Person et false sinon.
	 */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }
    
    /**
     * Gère la validité des données de l'utilisateur.
     * 
     * @param target L'objet sur lequel on ferra le test.
     * @param errors La classe errors.
     * 
     * @see Object
     * @see Error
     */
    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        
        if (person.getEmail() != null || person.getEmail().length() < 6) {
    		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "person.email");
    	}
    
    	if (person.getPwd() == null || person.getPwd().length() < 6) {
    		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "person.pwd");
    	}
    }
}