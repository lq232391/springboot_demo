package com.lq.springboot_demo.entity.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UpdateCountRequest {

    private String id;

    private int count;
}
