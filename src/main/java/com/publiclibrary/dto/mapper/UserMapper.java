package com.publiclibrary.dto.mapper;

import com.publiclibrary.dto.request.UserRequest;
import com.publiclibrary.dto.response.UserResponse;
import com.publiclibrary.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
    UserEntity fromRequestToEntity(UserRequest userRequest);
    UserResponse fromEntityToResponse(UserEntity userEntity);
}