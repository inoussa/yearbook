package fr.univ_amu.yearbook.app.controller.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.univ_amu.yearbook.bean.Person;

/**
 * PasswordRecoverValidator</br> gère la validation des données rentrées par
 * un utilisateur lors de l'nvoi d'un nouveau mot de passe.
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 *
 * @version 1.2
 */
@Service("pwdRecoverValidator")
public class PasswordRecoverValidator implements Validator {
	
	/**
	 * Le format du mail doit appartenir au parttern.
	 * 
	 * @see #validate(Object, Errors)
	 */
	private final String EMAIL_PATTERN = "^[a-z][\\.\\w]*@[a-z]+[a-z\\.-]+[a-z]+\\.[a-z]{2,4}$";
	
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
        
        if (person.getEmail() == null) {
    		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "person.email");
    	}
        else {
        	if (!person.getEmail().matches(EMAIL_PATTERN)) {
                errors.rejectValue("email", "person.email");
            }
        }
    }
}