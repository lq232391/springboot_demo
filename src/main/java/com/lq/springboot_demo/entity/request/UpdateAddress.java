package com.lq.springboot_demo.entity.request;

import lombok.Data;

@Data
public class UpdateAddress {

    /**
     * 收货人姓名
     */
    private String id;

    private String nickname;

    /**
     * 手机号码
     */

    private String phone;

    /**
     * 省
     */

    private String province;

    /**
     * 市
     */

    private String city;

    /**
     * 区
     */

    private String area;



    private String street;

    /**
     * 详细地址
     */

    private String address;

    /**
     * 邮政编码
     */

    private String postcode;

    /**
     * 是否为默认地址
     */
    private Boolean isDefault;

}
