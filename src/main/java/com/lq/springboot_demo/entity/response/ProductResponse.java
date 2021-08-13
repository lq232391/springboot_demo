package com.lq.springboot_demo.entity.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {

    private BigDecimal price;

    private String productName;

    private String standardValues;
}
