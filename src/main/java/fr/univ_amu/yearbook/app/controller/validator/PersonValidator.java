package fr.univ_amu.yearbook.app.controller.validator;

import java.util.Calendar;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.univ_amu.yearbook.bean.Person;

@Service("personValidator")
public class PersonValidator implements Validator {
	
	/**
	 * 
	 */
	private final String EMAIL_PATTERN = "^[a-z][\\.\\w]*@[a-z]+[a-z\\.-]+[a-z]+\\.[a-z]{2,4}$";
	
	/**
	 * 
	 */
	private final String PWD_PATTERN = "[a-z1-9]+";

	/**
	 * 
	 */
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    /**
     * 
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
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homePage",
                "person.homePage");
        
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