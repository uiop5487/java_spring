package com.demo.demo.service.auth;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import com.demo.demo.core.auth.UserAuthentication;
// import com.demo.demo.service.user.UserService;
import com.demo.demo.service.user.UserVO;

@Service
public class AuthService {
    
    // @Autowired
    // private UserService userService;

    public HashMap<String, Object> login(UserVO userVO, HttpSession session) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        System.out.println(userVO);

        UserAuthentication authentication = new UserAuthentication(userVO.getUseremail(), AuthorityUtils.createAuthorityList("any"), true);

        // System.out.println(authentication);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        session.setAttribute("useremail", userVO.getUseremail());

        // System.out.println("session :" + session);

        result.put("result", "success");

        return result;
    }
}
