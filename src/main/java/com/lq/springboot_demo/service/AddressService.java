package com.lq.springboot_demo.service;

import com.lq.springboot_demo.entity.Address;
import com.lq.springboot_demo.entity.request.AddressRequest;
import com.lq.springboot_demo.entity.request.UpdateAddress;

import java.util.List;

public interface AddressService {

    //添加收货地址
    String save(Address address);

    List<Address> queryAll(String userId);

    void saveAddress(Address address);

    void editAddress(UpdateAddress updateAddress);
}
