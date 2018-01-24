package com.syed.model;

import lombok.Data;

@Data
public class ContactForm {
	private String firstName;
	private String lastName;
	private String email;
	private boolean joinMailingList;
}
