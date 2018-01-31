package ru.fab.model;

import java.util.EnumSet;
import java.util.Set;

public class User extends AbstractEntity {

    private String name;
    private String password;
    private Set<Role> roles;

    public User(String name, String password, Role role, Role... roles){
        this(null, name,password,EnumSet.of(role, roles));

    }

    public User(Integer id, String name, String password, Role role, Role... roles) {
        this(id, name, password, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String password, Set<Role> roles) {
        super(id);
        this.name = name;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return String.format("User{id=%s, name='%s', password='%s', roles=%s}", getId(), name, password, roles);
    }


}
