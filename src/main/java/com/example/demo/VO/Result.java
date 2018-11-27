package com.example.demo.VO;

import lombok.Data;

import java.util.List;

@Data
public class Result<T> {
    private Boolean success= true;
    private List<T> msg;
}
