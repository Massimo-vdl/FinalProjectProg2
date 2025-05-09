package org.example;

import java.util.Comparator;
import java.util.Objects;

public abstract class User implements Comparator<User> {
    protected String username;
    protected String password;
    protected static status status;

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

    /**
     * Compares users first by username then by status
     * @param u1 the first object to be compared.
     * @param u2 the second object to be compared.
     * @return 0 if equal 1 if user1 comes second -1 if user1 comes first
     */
    @Override
    public int compare(User u1, User u2) {
        int usernameCompare = u1.getUsername().compareToIgnoreCase(u2.getUsername());
        if (usernameCompare != 0) {
            return usernameCompare;
        }
        return u1.getStatus().compareTo(u2.getStatus());
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
