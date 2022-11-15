package com.vitcon.progix_demo.apis.user;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vitcon.progix_demo.apis.user.dto.UserDTO;
import com.vitcon.progix_demo.core.exception.UserNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return  userMapper.findUser(userId).map(user -> addAuthrities(user)).orElseThrow(() -> new UserNotFoundException(userId + "ID를 찾을수 없습니다."));
    }
    
    private UserDTO addAuthrities(UserDTO userDTO) {
        userDTO.setAuthorities(Arrays.asList(new SimpleGrantedAuthority(userDTO.getUserRole())));

        return userDTO;
    }

}
