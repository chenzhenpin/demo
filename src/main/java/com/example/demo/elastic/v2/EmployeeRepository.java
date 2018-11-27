package com.example.demo.elastic.v2;

import com.example.demo.elastic.v2.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface EmployeeRepository extends ElasticsearchRepository<Employee,String> {
    Employee queryEmployeeById(String id);
}
