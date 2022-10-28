package com.demo.demo.apis.auth;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demo.service.auth.AuthService;
import com.demo.demo.service.response.ResponseObject;
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
        @RequestBody UserVO userVO,
        HttpSession session
    ) throws Throwable {

        UserVO user = this.userService.findUser(userVO);

        if(user == null) {
            return "이메일이 존재하지 않습니다.";
        }

        // session.invalidate();

        System.out.println(userVO);
        this.authService.login(userVO, session);

        return "로그인 되었습니다.";
    }

    @RequestMapping("/apis/auth/signup")
    public @ResponseBody ResponseObject signup(
        // @ModelAttribute("userVO") UserVO userVO
         @RequestBody UserVO userVO
    ) throws Throwable {

        UserVO findUser = this.userService.findUser(userVO);

        ResponseObject ret = new ResponseObject();

        if(findUser != null) {
            ret.setResultCode("이미 존재하는 이메일입니다.");
            return ret;
        }

        userService.insertUser(userVO);

        UserVO resultUser = this.userService.findUser(userVO);

        ret.setRes(resultUser);
        ret.setResultCode("등록 되었습니다.");

        return ret;
    }
}
