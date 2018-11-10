package com.mycompany.loginwithdb.tablemodels;

import java.util.Objects;

/**
 * @author oshan
 */
public class UserDTO {
    private String name;
    private String surname;
    private String email;
    private String login;
    private String password;
    private String blocked;

    public UserDTO() {
    }

    public UserDTO(String name, String surname, String email, String login, String password, String blocked) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.blocked = blocked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBlocked() {
        return blocked;
    }

    public void setBlocked(String blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(name, userDTO.name) &&
                Objects.equals(surname, userDTO.surname) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(login, userDTO.login) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(blocked, userDTO.blocked);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, email, login, password, blocked);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", blocked='" + blocked + '\'' +
                '}';
    }
}
