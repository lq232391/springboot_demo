package com.lq.springboot_demo.controller;

import com.lq.springboot_demo.entity.Address;
import com.lq.springboot_demo.entity.request.AddressRequest;
import com.lq.springboot_demo.entity.request.UpdateAddress;
import com.lq.springboot_demo.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
@Api(value = "/address", tags = {"地址管理"})
public class AddressController {

    @Resource
    private AddressService addressService;

    @PostMapping("/add")
    @ApiModelProperty("添加地址")
    public void addAddress(Address address){
        addressService.saveAddress(address);
    }
    @GetMapping("/queryAddress")
    @ApiModelProperty("查询所有收货地址")
    public List<Address> queryAll(String userId){

        return  addressService.queryAll(userId);
    }
    @PutMapping("/editAddress")
    @ApiModelProperty("修改收货地址")
    public  void editAddress(UpdateAddress updateAddress){
        addressService.editAddress(updateAddress);
    }
}
