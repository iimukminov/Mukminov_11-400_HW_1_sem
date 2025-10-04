package ru.kpfu.itis.mukminov.entity;

import java.util.UUID;


public class User {

    private Integer id;
    private String name;
    private String lastname;
    private String password;
    private String login;

    public User() {}

    public User(Integer id, String name, String lastname, String password, String login) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.login = login;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
}
