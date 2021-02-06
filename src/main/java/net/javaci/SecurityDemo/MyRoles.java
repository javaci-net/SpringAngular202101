package net.javaci.SecurityDemo;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public enum MyRoles {

    ADMIN(MyPermission.READ, MyPermission.CREATE, MyPermission.DELETE, MyPermission.UPDATE),
    USER(MyPermission.READ);

    private final Set<MyPermission> permissionSet;

    MyRoles(MyPermission ...permArray) {
        permissionSet = new TreeSet<>();
        for(MyPermission p : permArray) {
            permissionSet.add(p);
        }
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> collect = permissionSet.stream().map(p -> new SimpleGrantedAuthority(p.getPermission()))
                .collect(Collectors.toSet());
        collect.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return collect;
    }
}
