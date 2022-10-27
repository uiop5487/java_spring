package com.demo.demo.service.user;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public ArrayList<HashMap<String, Object>> findAll() {
        return userMapper.findAll();
    }

    public void insertUser(UserVO userVO) throws Throwable {
        userMapper.insertUser(userVO);
    }

    public UserVO findUser(UserVO userVO) throws Throwable {
        String useremail = userVO.getUseremail();
       UserVO user = userMapper.findUser(useremail);
       return user;
    }
}
