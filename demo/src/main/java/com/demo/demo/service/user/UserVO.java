package com.demo.demo.service.user;

public class UserVO {
    
    private String _id;
    private String useremail;
    private String username;
    private String userpassword;
    private String phone;

    public String get_Id() {
        return this._id;
    };

    public String getUseremail() {
        return this.useremail;
    }
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return this.userpassword;
    }
    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserVO [_id=" + _id 
        + ", useremail=" + useremail 
        + ", userpassword=" + userpassword 
        + ", username=" + username 
        + ", phone=" + phone 
        + "]";
    }
}
