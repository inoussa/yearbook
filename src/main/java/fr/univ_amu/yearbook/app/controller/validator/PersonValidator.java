package fr.univ_amu.yearbook.app.controller.validator;

import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.univ_amu.yearbook.bean.Person;

/**
 * <b>PersonValidator<b/> gère la validation des données rentrées par
 * un utilisateur lors de son inscription.
 * 
 * Cette classe comprend :
 * <ul>
 * <li>Une expression régulière sur l'email.</li>
 * <li>Une expression régulière sur le mot de passe.</li>
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
	private final String EMAIL_PATTERN = "^[a-z][\\.\\w]*@[a-z]+[a-z\\.-]+[a-z]+\\.[a-z]{2,4}$";
	
	/**
	 * Le format du mot de passe doit appartenir au parttern.
	 * 
	 * @see #validate(Object, Errors)
	 */
	private final String PWD_PATTERN = "[a-z1-9]+";

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
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
                "person.lastName");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
                "person.firstName");

        if (person.getEmail() != null) {
        	if (!person.getEmail().matches(EMAIL_PATTERN)) {
                errors.rejectValue("email", "person.email");
            }
        }
        
        if (person.getBirthDate() != null) {
        	if (person.getBirthDate().after(Calendar.getInstance().getTime())) {
        		errors.rejectValue("birthDate", "person.birthDate");
        	}
        }
        
        if (person.getPwd() != null) {
            if (!person.getPwd().matches(PWD_PATTERN)) {
                errors.rejectValue("pwd", "person.pwd");
            }
        }
    }
}