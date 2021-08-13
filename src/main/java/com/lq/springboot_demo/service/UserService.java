package com.lq.springboot_demo.service;

import com.lq.springboot_demo.entity.request.UpdateUserRequest;
import com.lq.springboot_demo.entity.request.UserRequest;

public interface UserService {

    void saveUser(UserRequest userRequest);

    /**
     *
     * @param request
     */
    void updateUser(UpdateUserRequest request);
}
