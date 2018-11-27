package com.example.demo.dataobject.jpaEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "f_product")
@Getter
@Setter
public class FProduct {
	@Id @Column(name="product_id")
	@GeneratedValue
	private Long productid;
	
	@Column(name="price")
	private int price;
	
	@ManyToMany(targetEntity=FPerson.class, fetch=FetchType.LAZY)
	@JoinTable(name="f_person_product",
	joinColumns=@JoinColumn(name="product_id",referencedColumnName="product_id"),
	inverseJoinColumns=@JoinColumn(name="person_id",referencedColumnName="person_id"))
	private Set<FPerson> person =new HashSet<FPerson>();
	
	public FProduct() {
		
	}
	public FProduct(int price) {
		this.price=price;
	}



}
