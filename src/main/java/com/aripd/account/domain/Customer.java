package com.aripd.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.aripd.common.entity.BaseEntity;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

	private static final long serialVersionUID = -6094813584577638738L;
	
	public Customer() {
	}

	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Column(nullable = true, unique = false)
	private String firstName;

	@Column(nullable = true, unique = false)
	private String lastName;

	@OneToOne(mappedBy = "customer")
	private Company company;

	@Transient
	public String getFullname() {
		StringBuilder sb = new StringBuilder();

		sb.append(firstName);
		sb.append(" ");
		sb.append(lastName);

		return sb.toString();
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
