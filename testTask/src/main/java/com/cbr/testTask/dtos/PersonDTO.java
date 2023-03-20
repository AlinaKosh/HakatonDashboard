package com.cbr.testTask.dtos;


import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class PersonDTO {
    /*
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длиной")
    private String username;
    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private int yearOfBirth;
    private String password;

     */

    @NotEmpty(message = "Имя не должно быть пустым!")
    private String username;

    @NotEmpty(message = "Email не должно быть пустым!")
    @Email
    private String email;

    @NotEmpty(message = "Пароль не должно быть пустым!")
    private String password;

    @NotEmpty
    private String phoneNumber;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
