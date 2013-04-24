package com.aripd.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.aripd.common.entity.BaseEntity;

@Entity
@Table(name = "company")
public class Company extends BaseEntity {

	private static final long serialVersionUID = -1824288466740413585L;

	@Column(nullable = false, unique = true)
	private String taxno;

	private String name;
	private String content;
	private String phone;

	@OneToOne
	private Customer customer;
	
	public String getTaxno() {
		return taxno;
	}

	public void setTaxno(String taxno) {
		this.taxno = taxno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
