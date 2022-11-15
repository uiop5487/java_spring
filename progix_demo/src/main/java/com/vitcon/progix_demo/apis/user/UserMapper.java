package com.vitcon.progix_demo.apis.user;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.vitcon.progix_demo.apis.user.dto.UserDTO;

@Mapper
public interface UserMapper {
    void join(UserDTO userVo);
    Optional<UserDTO> findUser(String userId);
    Optional<UserDTO> findUserId(String userId);
}
