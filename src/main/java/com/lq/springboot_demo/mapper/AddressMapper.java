package com.lq.springboot_demo.mapper;

import com.lq.springboot_demo.entity.Address;

import com.lq.springboot_demo.entity.request.UpdateAddress;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;


@Repository
public interface AddressMapper extends BaseMapper<Address> {

    Address findById(String id);

    void updateAddress(UpdateAddress updateAddress);

    void saveAddress(Address address);

    List<Address> queryAll(String userId);

    List<String> findByUserId(String userId);
}
