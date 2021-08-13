package com.lq.springboot_demo.controller;

import com.lq.springboot_demo.entity.request.UpdateUserRequest;
import com.lq.springboot_demo.entity.request.UserRequest;
import com.lq.springboot_demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(value = "/user", tags = {"用户管理"})
public class UserController {

    @Resource
    private UserService userService;

    @ApiModelProperty("新增用户")
    @PostMapping("add")
    public void insertUser(UserRequest userRequest){

        userService.saveUser(userRequest);
    }
    @ApiModelProperty("修改")
    @PutMapping("uodate")
    public void updateUser(UpdateUserRequest request){


        userService.updateUser(request);
    }
}
