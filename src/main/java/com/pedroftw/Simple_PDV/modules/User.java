package com.pedroftw.Simple_PDV.modules;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String pass;

    private boolean admin;

    public User() {}

    public User (String name, String pass, boolean admin) {
        this.name = name;
        this.pass = pass;
        this.admin = admin;
    }
    public Long getId() { return id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public boolean isAdmin() { return admin; }
    public void setAdmin(boolean admin) { this.admin = admin; }
}
