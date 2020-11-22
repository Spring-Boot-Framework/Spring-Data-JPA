package io.github.anantharajuc.sdjpa.model;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * Simple JavaBean domain object representing a person.
 *
 * @author <a href="mailto:arcswdev@gmail.com">Anantha Raju C</a>
 */
@Entity
@Table(name="person") 
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Person extends AuditEntity
{
	private static final long serialVersionUID = 1L;

	@Size(min=3, max=15, message="Name must be between 3 and 15 characters.")
	@Column(name="name", nullable = false)
	String name;
	
	@Column(name="username", unique=true)
	@Size(min=3, max = 15, message="username must not be empty.")
	String username;
	
	@Column(name="phone", unique=true, nullable=false)
	Long phone;
	
	@Size(max=255, message="Must be a valid email id")
	@Column(name="email_primary", unique=true, nullable = false)
	String emailPrimary;
	
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
	@Column(name="email_secondary", nullable = true)
	String emailSecondary;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender", nullable=false)
	GenderEnum gender;
	
	@Column(name="age", nullable=true)
	int age;
	
	@Size(min=6, max = 15, message="password must not be empty.")
	@JsonProperty(access=JsonProperty.Access.WRITE_ONLY)
	@Size(max = 100)
	@Column(name = "password")
	String password;

	@JsonFormat(pattern="dd-MM-yyyy", timezone="Asia/Kolkata")
	@Column(name="dob", nullable = true)
	LocalDate dob;
	
	@Column(name = "is_adult", nullable=false, length=1)
	Boolean isAdult;
	
	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="address_id")
	Address address;
}