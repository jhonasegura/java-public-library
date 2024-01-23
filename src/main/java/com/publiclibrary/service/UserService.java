package com.publiclibrary.service;

import com.publiclibrary.dto.request.UserRequest;
import com.publiclibrary.dto.response.UserResponse;
import com.publiclibrary.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserEntity> findAllUser();
    Optional<UserEntity> findById(Long id);
    UserEntity saveUser(UserEntity userEntity);
    UserEntity updateUser(UserEntity userEntity);
    void deleteUser(Long id);

    //    Using Request for Save and Update User
    UserResponse saveUser(UserRequest userRequest);
    UserResponse updateUser(UserRequest userRequest, Long id);


}