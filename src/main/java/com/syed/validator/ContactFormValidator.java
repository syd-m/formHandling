package com.syed.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.syed.model.ContactForm;

@Component
public class ContactFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ContactForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ContactForm user = (ContactForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "contactForm.firstName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "contactForm.lastName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "contactForm.email.empty");

		Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		if (!(pattern.matcher(user.getEmail()).matches())) {
			errors.rejectValue("email", "Pattern.contactForm.email");
		}
	}
}