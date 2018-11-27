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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;


//总结 双向
//一对多关系，多的一端维护外键,负责外键更新。使用 @JoinColumn，一的一端使用mappedBy，mappedBy的name值是对方的属性名。
//@JoinColumn 的一端关联删除才有效。
//一对多，多对多关系 CascadeType.REMOVE 要慎用。多对多关系 CascadeType.REMOVE使用报错
//使用 @JoinColumn一端关联保存
@Entity
@Table(name = "f_person")
@Getter
@Setter
public class FPerson  {
	
    @Id @Column(name="person_id")
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE")
//    @SequenceGenerator(name="SEQ_STORE", sequenceName="Q_SQE_TEST_ID",allocationSize = 1)
    @GeneratedValue
    private Long personId;

    @Column(name = "created")
    private Long created = System.currentTimeMillis();

    @Column(name = "username")
    private String username;
    
    //@ManyToOne(targetEntity=FAddress.class,cascade={CascadeType.REFRESH,CascadeType.PERSIST})
    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn(name = "address_id")
    private FAddress address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "remark")
    private String remark;

	@OneToMany(targetEntity=FArticle.class,cascade=CascadeType.ALL, mappedBy = "person")
	private Set<FArticle> articles = new HashSet<FArticle>();

	@ManyToMany(targetEntity=FProduct.class,cascade={CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH}, fetch=FetchType.LAZY)
	@JoinTable(name="f_person_product",
	joinColumns=@JoinColumn(name="person_id",referencedColumnName="person_id"),
	inverseJoinColumns=@JoinColumn(name="product_id",referencedColumnName="product_id"))
	private Set<FProduct> products  = new HashSet<FProduct>();
	
	//@OneToOne(targetEntity=FAccount.class,cascade={CascadeType.ALL},mappedBy ="person" )
    @OneToOne(targetEntity=FAccount.class,cascade={CascadeType.ALL})
    @JoinColumn(name="account_id" )
	private FAccount account;

    public void addArticle(FArticle article){
        article.setPerson(this);
        this.articles.add(article);
    }

    public void addProduct(FProduct product){
        this.products.add(product);
    }

	
	public FPerson(){
			
	}


}
