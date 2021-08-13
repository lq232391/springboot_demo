package com.lq.springboot_demo.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;



import javax.persistence.Table;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "t_product")

public class Product extends  BaseEntity{


    private BigDecimal price;


    private int count;



    private String productName;

    private String standardValues;

    private  String userId;

}
