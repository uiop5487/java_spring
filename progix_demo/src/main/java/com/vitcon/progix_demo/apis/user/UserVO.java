package com.vitcon.progix_demo.apis.user;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    public UserVO(String subject, String string, Collection<? extends GrantedAuthority> authorities) {
    }
    private String userId;
    private String userName;
    private String password;
    private int grade;
    private String puserId; 
    private String mobile;
    private String languagecd;
}