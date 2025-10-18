package ru.kpfu.itis.mukminov.dto;

public class UserDto {

    private String name;
    private String login;
    private String imagePath;

    public UserDto(String name, String login) {
        this.name = name;
        this.login = login;
    }

    public UserDto(String name, String login, String imagePath) {
        this.name = name;
        this.login = login;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getImagePath() {
        return imagePath;
    }
}
