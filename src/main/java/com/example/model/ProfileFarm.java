package com.example.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profilefarm")
public class ProfileFarm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_farm;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private int password;
    @Column(name = "active")
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER )
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role>roles;

    public ProfileFarm() {
    }

    public Long getId_farm() {
        return id_farm;
    }

    public void setId_farm(Long id_farm) {
        this.id_farm = id_farm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
