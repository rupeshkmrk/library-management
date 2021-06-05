package com.hcl.hacktohire.service;

import com.hcl.hacktohire.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserByEmail(String email);

    UserDTO getUserById(String userID);

//    UserDTO getUserByFirstName(String firstName);
}
