package com.demo.demo.apis.auth;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.service.auth.AuthService;
import com.demo.demo.service.user.UserService;
import com.demo.demo.service.user.UserVO;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    AuthService authService;

    @RequestMapping("/apis/auth/login")
    public String login(
        @ModelAttribute("userVO") UserVO userVO,
        HttpSession session
    ) throws Throwable {

        UserVO user = this.userService.findUser(userVO);

        if(user.get_Id() == null) {
            return "이메일이 존재하지 않습니다.";
        }

        // HashMap<String, Object> result = this.authService.login(userVO, session);

        // System.out.println(result.get("result"));

        return userVO.toString();
    }

    @RequestMapping("/apis/auth/signup")
    public String signup(
        @ModelAttribute("userVO") UserVO userVO
    ) throws Throwable {

        UserVO user = this.userService.findUser(userVO);

        if(user.get_Id() != null) {
            return "이미 존재하는 이메일입니다.";
        }


        userService.insertUser(userVO);

        return "등록 성공";
    }
}
