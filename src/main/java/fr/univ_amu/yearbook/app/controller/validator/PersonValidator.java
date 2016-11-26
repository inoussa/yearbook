package fr.univ_amu.yearbook.app.controller.validator;

import java.util.Calendar;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import fr.univ_amu.yearbook.bean.Person;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
                "person.lastName");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
                "person.firstName");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "person.email");
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "homePage",
                "person.homePage");
        
        if (person.getBirthDate() != null) {
        	if (person.getBirthDate().after(Calendar.getInstance().getTime())) {
        		errors.rejectValue("birthDate", "person.birthDate");
        	}
        }
        
        if (person.getPwd() != null) {
            if (!person.getPwd().matches("[A-Z]")) {
                errors.rejectValue("pwd", "person.pwd");
            }
        }
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idG",
                "person.idG");
    }
}