package com.vitcon.progix_demo.apis.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vitcon.progix_demo.apis.auth.DTO.LoginDTO;
import com.vitcon.progix_demo.apis.user.dto.UserDTO;
import com.vitcon.progix_demo.core.exception.LoginFailedException;
import com.vitcon.progix_demo.core.jwt.TokenProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private TokenProvider jwtTokenProvider;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:sss");
    Date time = new Date();
    String localTime = format.format(time);

    @Autowired
    UserMapper userMapper;

    public String login(LoginDTO loginDTO) {
        UserDTO userDTO = userMapper.findUser(loginDTO.getUserId()).orElseThrow(() -> new LoginFailedException("잘못된 아이디 입니다."));
        if(!passwordEncoder.matches(loginDTO.getUserPw(), userDTO.getPassword())) {
            throw new LoginFailedException("잘못된 비밀번호 입니다.");
        }

        return userDTO.getUserId();
    }
}
