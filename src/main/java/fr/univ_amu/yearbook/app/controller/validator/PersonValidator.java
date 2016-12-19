package fr.univ_amu.yearbook.app.controller.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.univ_amu.yearbook.bean.Person;

/**
 * PersonValidator gère la validation des données rentrées par
 * un utilisateur lors de son inscription.
 * 
 * Cette classe comprend :
 * <ul>
 * <li>Une expression régulière sur le site web.</li>
 * </ul>
 * 
 * @author Aboubacar Sidy DIALLO
 * @author Inoussa ZONGO
 *
 * @version 1.2
 */
@Service("personValidator")
public class PersonValidator implements Validator {
	
	/**
	 * Le format du mail doit appartenir au parttern.
	 * 
	 * @see #validate(Object, Errors)
	 */
	private final String HOMEPAGE_PATTERN = "[w]{3}\\.[a-z\\._-]+\\.[a-z\\.~/_-]{2,}$";
	
	/**
	 * Le format du nom doit appartenir au parttern.
	 * 
	 * @see #validate(Object, Errors)
	 */
	private final String LASTNAME_PATTERN = "[A-Za-z\\s]{2,}$";
	
	/**
	 * Le format du prénom doit appartenir au parttern.
	 * 
	 * @see #validate(Object, Errors)
	 */
	private final String FIRSTNAME_PATTERN = "[A-Za-z-\\s]{2,}$";
	
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
        
        if (person.getLastName() != null) {
        	if (!person.getLastName().matches(LASTNAME_PATTERN) || person.getLastName().length() > 20) {
                errors.rejectValue("lastName", "person.lastName");
            }
        }
        
        if (person.getFirstName() != null) {
        	if (!person.getFirstName().matches(FIRSTNAME_PATTERN) || person.getFirstName().length() > 20) {
                errors.rejectValue("firstName", "person.firstName");
            }
        }
        
        if (person.getEmail() != null) {
        	if (!person.getEmail().matches(EMAIL_PATTERN) || person.getEmail().length() > 30) {
                errors.rejectValue("email", "person.email");
            }
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", "person.birthDate");
        
        if (person.getPwd() != null && person.getPwd().length() < 6) {
        	errors.rejectValue("pwd", "person.pwd");
    	}
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idG", "person.idG");
        
        if (person.getHomePage() != null) {
            if (!person.getHomePage().matches(HOMEPAGE_PATTERN) || person.getHomePage().length() > 30) {
                errors.rejectValue("homePage", "person.homePage");
            }
        }
    }
}