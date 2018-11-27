package com.example.demo;

import com.example.demo.dataobject.jpaEntity.*;
import com.example.demo.service.jpaService.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JpaTest {
    @Autowired
    PersonService personService;
    @Autowired
    AccountService accountService;
    @Autowired
    ArticleService articleService;
    @Autowired
    AddressService addressService;
    @Autowired
    ProductService productService;


    @Test
    public void test1(){
        FAddress address=new FAddress("海口市");
        FProduct product1= new FProduct(23);
        FProduct product2= new FProduct(24);


        FPerson person1=new FPerson();
        person1.setUsername("chen");
        FArticle article1 =new FArticle("大江东去");
        FArticle article2 =new FArticle("物是人非");
        FAccount account=new FAccount("rich");



        person1.addArticle(article1);
        person1.addArticle(article2);
        person1.setAccount(account);





        FPerson person2=new FPerson();
        person2.setUsername("liu");

        FAccount account2=new FAccount("rose");

        FArticle article3 =new FArticle("2大江东去");
        FArticle article4 =new FArticle("2物是人非");
        person2.addArticle(article3);
        person2.addArticle(article4);

        person2.setAccount(account2);








        productService.saveProduct(product1);
        productService.saveProduct(product2);
        addressService.saveAddress(address);

        personService.savePerson(person1);
        personService.savePerson(person2);


        person1.addProduct(product1);
        person1.addProduct(product2);
        person2.addProduct(product1);
        person2.addProduct(product2);

        person1.setAddress(address);
        person2.setAddress(address);

        personService.savePerson(person1);
        personService.savePerson(person2);









    }



    @Test
    public void test2(){
        FPerson person=personService.findOne(Long.valueOf(1));
        if(person==null){
            return;
        }
        System.out.println(person.getCreated());
        System.out.println(person.getAccount().getUsername());
        System.out.println(person.getAddress().getAddressDetail());
        for (FArticle article :person.getArticles()) {
            System.out.println();
        }

        for (FProduct product :person.getProducts()) {
            System.out.println(product.getPrice());
        }

    }
//    @Test
//    public void test3(){
//        accountService.remove(Long.valueOf(1));
//    }
//    @Test
//    public void test4(){
//        articleService.remove(Long.valueOf(1));
//        articleService.remove(Long.valueOf(2));
//    }
    @Test
    //@Transactional 测试里面回滚
    public void test5(){
        personService.remove(Long.valueOf(1));
        personService.remove(Long.valueOf(2));
    }

}
