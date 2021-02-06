package net.javaci.SecurityDemo.jwt;

public class UserPwdRequest {
    private String username;
    private String password;

    public UserPwdRequest() {

    }

    public UserPwdRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
