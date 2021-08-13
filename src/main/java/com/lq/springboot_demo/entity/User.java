package com.lq.springboot_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@EqualsAndHashCode
@Data
@Table(name="t_user")

public class User extends  BaseEntity{


    //名字
    private String name;
    //年龄
    private String age;
   //密码
    private String password;

    //生日
    private Date birthday;
}
