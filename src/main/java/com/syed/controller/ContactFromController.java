package com.syed.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.syed.model.ContactForm;
import com.syed.service.EmailService;
import com.syed.validator.ContactFormValidator;

@Controller
public class ContactFromController {

	@Autowired
	ContactFormValidator contactFormValidator;

	// Set a form validator
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(contactFormValidator);
	}

	@Autowired
	private EmailService emailService;

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String showForm(Locale locale, Model model) {
		model.addAttribute("contactForm", new ContactForm());
		return "contact";
	}

	@RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
	public String sendEmail(@ModelAttribute("contactForm") @Validated ContactForm contactForm, BindingResult result,
			Model model) {
		System.out.print("sendEmail");
		if (result.hasErrors()) {
			return "contact";
		} else {
			emailService.sendEmail(contactForm.getEmail(),
					contactForm.getFirstName() + " " + contactForm.getLastName() + " is trying to reach you.",
					contactForm.getFirstName());
		}
		return "thankYou";
	}

}
