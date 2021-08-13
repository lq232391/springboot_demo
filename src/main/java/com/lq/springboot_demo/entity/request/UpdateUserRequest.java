package com.lq.springboot_demo.entity.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String id;


    private String password;
}
