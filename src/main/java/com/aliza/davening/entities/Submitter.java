package com.aliza.davening.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//No ToString in order to override and write one without Davenfors (causes recursive Json)

@Entity
public class Submitter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Allowing only letters and spaces, no leading spaces
	@Pattern(regexp = "^[a-zA-Z '\\-\\ ]*$", message = "Submitter name must contain only letters and may have spaces in between. ")
	private String name;

	@NotBlank(message = "Submitter's email missing. ") // NotBlank includes NotNull option.
	@Pattern(regexp = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,5}))?$", message = "Please provide a valid email for submitter. ")
	private String email;

	// Strings are preferable to long in this case as a phone number can reach 19
	// digits.
	// Also in case I want to allow dashes in the future (would have to omit the
	// pattern though).

	@Pattern(regexp = "^[0-9]+$", message = "Whatsapp number can contain only numeric digits.")
	private String whatsapp;

	@Pattern(regexp = "^[0-9]+$", message = "Whatsapp number can contain only numeric digits.")
	private String phone;

	// Constructor with only email, for quick creation.
	public Submitter(
			@NotBlank(message = "Submitter's email missing. ") @Pattern(regexp = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,5}))?$", message = "Please provide a valid email for submitter. ") String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "Submitter [id=" + id + ", name=" + name + ", email=" + email + ", whatsapp=" + whatsapp + ", phone="
				+ phone + "]";
	}

}
