package net.javaci.SecurityDemo.dao;

import net.javaci.SecurityDemo.MyRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("mock")
public class MockUserDao implements  MyUserDao {
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public MockUserDao(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<MyUser> findByUsername(String username) {
        return users().stream().filter(u-> {
            return u.getUsername().equals(username);
        }).findFirst();
    }

    private List<MyUser> users() {
        List<MyUser> list = new ArrayList<>();
        list.add(new MyUser("koray", passwordEncoder.encode("koray"), true,
                true,true, true, MyRoles.USER.getAuthorities()));
        list.add(new MyUser("ozkan", passwordEncoder.encode("ozkan"), true,
                true,true, true, MyRoles.ADMIN.getAuthorities()));
        return list;
    }
}
