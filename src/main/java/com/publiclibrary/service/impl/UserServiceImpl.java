package com.publiclibrary.service.impl;

import com.publiclibrary.dto.mapper.UserMapper;
import com.publiclibrary.dto.request.UserRequest;
import com.publiclibrary.dto.response.UserResponse;
import com.publiclibrary.entity.UserEntity;
import com.publiclibrary.repository.UserRepository;
import com.publiclibrary.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    Using Request and Response with save and update user

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        UserEntity userEntity = UserMapper.MAPPER.fromRequestToEntity(userRequest);
        userRepository.save(userEntity);
        return UserMapper.MAPPER.fromEntityToResponse(userEntity);
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest, Long id) {

        Optional<UserEntity> checkExistingUser = findById(id);
        if (! checkExistingUser.isPresent())
            throw new RuntimeException("User Id "+ id + " Not Found!");

        UserEntity userEntity = UserMapper.MAPPER.fromRequestToEntity(userRequest);
        userEntity.setId(id);
        userRepository.save(userEntity);
        return UserMapper.MAPPER.fromEntityToResponse(userEntity);
    }

}

