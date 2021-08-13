package com.lq.springboot_demo.mapper;


import com.lq.springboot_demo.entity.User;
import com.lq.springboot_demo.entity.request.UpdateUserRequest;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface UserMapper extends BaseMapper<User> {

void updatePassword(UpdateUserRequest request);


}
