package ru.fab.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.EnumSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u LEFT JOIN FETCH u.roles ORDER BY u.name")
})
@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
public class User extends AbstractEntity {

    public static final String DELETE = "User.delete";
    public static final String ALL_SORTED = "User.getAllSorted";

    @NotEmpty
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @NotEmpty
    @Column(name = "password", nullable = false)
    @Length(min = 5)
    private String password;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User(){
    }

    public User(String name, String password, Role role, Role... roles){
        this(null, name,password,EnumSet.of(role, roles));
    }

    public User(User u){
        this(u.getId(), u.getName(), u.getPassword(), u.getRoles());
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
