package com.lq.springboot_demo.entity.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {

    private String id;

    //产品规格值
    private String standardValues;

    private BigDecimal price;

    private int count;

    private String productName;
}
