package com.example.demo.VO;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsItem implements Serializable {
    private static final long serialVersionUID = -8655073137454922776L;
    private String goodsId;
    private String goodsName;
    private String sysNumber;
    private String checkNumber;
    private Boolean status;
}
