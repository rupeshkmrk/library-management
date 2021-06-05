package com.hcl.hacktohire.controller;

import com.hcl.hacktohire.dto.UserDTO;
import com.hcl.hacktohire.service.UserService;
import com.hcl.hacktohire.entity.User;
import com.hcl.hacktohire.exception.UserNotFoundException;
import com.hcl.hacktohire.model.request.UserDetailRequestModel;
import com.hcl.hacktohire.model.response.UserDetailResponseModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/status")
    public String status() {
        return "Up";
    }

    @PostMapping
    public UserDetailResponseModel createUser(@RequestBody UserDetailRequestModel user) {
        UserDetailResponseModel userDetailResponseModel = new UserDetailResponseModel();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);

        var createdUser = userService.createUser(userDTO);
        BeanUtils.copyProperties(createdUser, userDetailResponseModel);
        return userDetailResponseModel;
    }

}
