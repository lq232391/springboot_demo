package com.lq.springboot_demo.service;

import com.lq.springboot_demo.entity.User;
import com.lq.springboot_demo.entity.request.UpdateUserRequest;
import com.lq.springboot_demo.entity.request.UserRequest;
import com.lq.springboot_demo.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements  UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public void saveUser(UserRequest userRequest) {
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);
        user.setId(UUID.randomUUID().toString().replaceAll("-",""));
        user.setCreateTime(new Date());
        user.setIsDelete(Boolean.FALSE);
        userMapper.insert(user);
    }

    @Override
    public void updateUser(UpdateUserRequest request) {
        User user = userMapper.selectByPrimaryKey(request.getId());
        if(StringUtils.isEmpty(user)){
            System.out.println("该用户不存在");
        }
        userMapper.updatePassword(request);

        
    }
}
