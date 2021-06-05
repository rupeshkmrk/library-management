package com.hcl.hacktohire.service.impl;

import com.hcl.hacktohire.service.UserService;
import com.hcl.hacktohire.dto.UserDTO;
import com.hcl.hacktohire.entity.User;
import com.hcl.hacktohire.exception.UserNotFoundException;
import com.hcl.hacktohire.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        var userEntity = new User();
        BeanUtils.copyProperties(userDTO, userEntity);
        userEntity.setUserId(UUID.randomUUID().toString());
        userEntity.setEcryptedPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        var persistedEntity = userRepository.save(userEntity);
        var returnValue = new UserDTO();
        BeanUtils.copyProperties(persistedEntity, returnValue);
        return returnValue;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        var user = userRepository.findByEmail(email);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public UserDTO getUserById(String userID) {
        var user = userRepository.findByUserId(userID);
        if(user == null) throw new UserNotFoundException();
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

   /* @Override
    public UserDTO getUserByFirstName(String firstName) {
        var user = userRepository.findByFirstName(firstName);
        if(null == user) throw new UserNotFoundException();
        UserDTO userDTO =new UserDTO();
        BeanUtils.copyProperties(user,userDTO);
        return userDTO;
    }*/

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findByEmail(email);
        if (null == user) throw new UsernameNotFoundException(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getEcryptedPassword(), new ArrayList<>());
    }
}
