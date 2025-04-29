package org.example;

import java.util.Objects;

public abstract class User {
    private String username;
    private String password;
    private status status;

    public User(String username, String password, User.status status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) && Objects.equals(password, user.password) && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, status);
    }

    @Override
    public String toString() {
        return "User: " + username + '\n' + "Status: " + status + '}';
    }

    public String getUsername() {
        return username;
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

    public User.status getStatus() {
        return status;
    }

    public void setStatus(User.status status) {
        this.status = status;
    }

    public enum status {
        OWNER, LISTENER
    }
}
