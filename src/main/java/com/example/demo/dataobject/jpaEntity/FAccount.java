package com.example.demo.dataobject.jpaEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="f_account")
@Getter
@Setter
public class FAccount {
	@Id @Column(name="account_id")
	@GeneratedValue
	private Long accountId;

	@Column(name="username")
	private String username;

	@OneToOne(cascade={CascadeType.MERGE},mappedBy = "account")
	//@OneToOne(targetEntity=FPerson.class,cascade={CascadeType.MERGE})
	@JoinColumn(name = "person_id")
	private FPerson person;
	public FAccount() {
		
	}
	public FAccount(String username) {
		this.username=username;
	}



}
