package org.example;

public abstract class User {
    private String username;
    private String password;
    private status status;

    public enum status {
        OWNER, LISTENER
    }
}
