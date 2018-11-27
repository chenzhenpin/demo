package com.example.demo.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = 5639394324068493313L;
    private String typeId;
    private String typeName;
    private String src;
    private Boolean isLink;
    private Boolean status;
}
