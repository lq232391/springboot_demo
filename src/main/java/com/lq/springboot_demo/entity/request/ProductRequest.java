package com.lq.springboot_demo.entity.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {


    private BigDecimal price;


    private int count;



    private String productName;

    private String standardValues;

    private  String userId;

}
