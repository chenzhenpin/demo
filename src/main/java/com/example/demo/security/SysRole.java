package com.example.demo.security;




import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

//spring security
@Data
@Entity
public class SysRole implements Serializable{

    private static final long serialVersionUID = 3830761821703367116L;
    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
