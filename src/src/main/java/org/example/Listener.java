package org.example;

public class Listener extends User{
    private status listener = status.LISTENER;

    public Listener(String username, String password, User.status status, User.status listener) {
        super(username, password, status);
        this.listener = User.status.LISTENER;
    }
}
