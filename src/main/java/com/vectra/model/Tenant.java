package com.vectra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tenant")
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	@Column(name = "TENANT_FIRSTNAME", nullable = false)
	private String firstName;

	@NotNull
	@Column(name = "TENANT_LASTNAME", nullable = false)
	private String lastName;

	@NotNull
	@Column(name = "TENANT_PHONE", nullable = false)
	private String phone;

	@NotNull
	@Column(name = "TENANT_EMAIL", nullable = false)
	private String email;

	public Tenant() {

	}

	public Tenant(String firstName, String lastName, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return String.format("Tenant[id=%d,firstname=%s,lastname=%s,phone=%s,email=%s]" + "\n", id, firstName, lastName, phone, email);
	}

	public boolean equals(Object other) {
		return (other instanceof Tenant) && (id != null) ? id.equals(((Tenant) other).id) : (other == this);
	}

	// Tenant with the same id should return the same hashcode.
	public int hashCode() {
		return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
	}
}
