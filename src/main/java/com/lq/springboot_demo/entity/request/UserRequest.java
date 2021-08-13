package com.lq.springboot_demo.entity.request;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserRequest {

    //名字
    private String name;
    //年龄
    private String age;
    //密码
    private String password;

    //生日
    @DateTimeFormat(pattern = "yyyy-MM-dd", iso = DateTimeFormat.ISO.DATE_TIME)
    private Date birthday;


}
