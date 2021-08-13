package com.lq.springboot_demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Data
@MappedSuperclass
public abstract class BaseEntity {


    private String id;

    //是否删除

    private Boolean isDelete=false;

    private Date createTime;



    //插入数据时初始化available和delete字段

    public void prePersist(){
   
        if (this.isDelete == null){
            this.isDelete = false;
        }
    }
}
