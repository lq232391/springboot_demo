package com.lq.springboot_demo.service;

import com.lq.springboot_demo.entity.Address;
import com.lq.springboot_demo.entity.request.AddressRequest;
import com.lq.springboot_demo.entity.request.UpdateAddress;
import com.lq.springboot_demo.mapper.AddressMapper;
import com.lq.springboot_demo.util.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService{
    @Resource
    private AddressMapper addressMapper;
    @Resource
    private RedisUtil redisUtil;

    @Override
    public String save(Address address) {
        Address addressVo = new Address();
        BeanUtils.copyProperties(address,addressVo);
        addressVo.setId(UUID.randomUUID().toString());
        addressVo.setCreateTime(new Date());
         addressMapper.insert(addressVo);
        return "新建地址成功";
    }

    @Override
    public List<Address> queryAll(String userId) {

        return addressMapper.queryAll(userId);
    }

    @Override
    public void saveAddress(Address address) {
        Address addressVo = new Address();
        BeanUtils.copyProperties(address,addressVo);
        addressMapper.saveAddress(addressVo);
        List<String> byUserId = addressMapper.findByUserId(addressVo.getUserId());
        redisUtil.set("ADDRESS"+addressVo.getUserId(),byUserId);
    }

    @Override
    public void editAddress(UpdateAddress updateAddress) {
        Address address = addressMapper.findById(updateAddress.getId());
        if(StringUtils.isEmpty(address)){
            System.out.println("该地址不存在");
        }
     addressMapper.updateAddress(updateAddress);

    }
}
