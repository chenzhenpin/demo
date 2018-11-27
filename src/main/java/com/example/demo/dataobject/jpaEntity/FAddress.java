package com.example.demo.dataobject.jpaEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="f_address")
@Getter
@Setter
public class FAddress   {
	//主从表id不能一样
	@Id @Column(name="address_id")
	@GeneratedValue
	private Long addressid;
	@Column(name = "addressDetail")
	private String addressDetail;

	@OneToMany(targetEntity=FPerson.class,cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE},mappedBy = "address")
	private Set<FPerson> persons =new HashSet<FPerson>();

	public void addPerson(FPerson person){
		person.setAddress(this);
		this.persons.add(person);
	}
	public FAddress() {
		
	}
	public FAddress(String addressDetail) {
		this.addressDetail=addressDetail;
	}

}
