package com.example.demo.service.jpaService.impl;

import com.example.demo.dataobject.jpaEntity.FProduct;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.jpaService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
   public FProduct saveProduct(FProduct product){
       return productRepository.save(product);
   }

}
