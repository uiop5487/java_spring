package com.demo.demo.service.user;

import java.util.ArrayList;
// import java.util.List;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    
    public ArrayList<HashMap<String, Object>> findAll();

    public UserVO findUser(String useremail);

    public void insertUser(UserVO userVO) throws Throwable;
}
