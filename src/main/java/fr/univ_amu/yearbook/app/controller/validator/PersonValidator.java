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
	private final String HOMEPAGE_PATTERN = "[w]{3}\\.[a-z\\._-]+\\.[a-z]{2,4}$";
	
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
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "person.lastName");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "person.firstName");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "person.email");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "birthDate", "person.birthDate");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwd", "person.pwd");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idG", "person.idG");
        
        if (person.getHomePage() != null) {
            if (!person.getPwd().matches(HOMEPAGE_PATTERN)) {
                errors.rejectValue("homePage", "person.homePage");
            }
        }
    }
}