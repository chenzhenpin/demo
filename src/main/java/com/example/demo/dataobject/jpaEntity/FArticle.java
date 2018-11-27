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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="f_article")
@Setter
@Getter
public class FArticle   {
	//主从表id不能一样
	@Id @Column(name="article_id")
	@GeneratedValue
	private Long articleId;
	@Column(name = "content")
	private String content;

	@ManyToOne(targetEntity=FPerson.class,cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST})
    @JoinColumn(name="person_id") //nullable=false,使用该属性插入时要注意使用的控制端。否则容易出现字段不为空。
	private FPerson person;
	public FArticle() {
		
	}
	public FArticle(String content) {
		this.content=content;
	}



}