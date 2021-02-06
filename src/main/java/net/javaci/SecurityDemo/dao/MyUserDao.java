package net.javaci.SecurityDemo.dao;

import java.util.Optional;

public interface MyUserDao {

    public Optional<MyUser> findByUsername(String username);

}
