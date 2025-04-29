package org.example;

public class Owner extends User{
    private status owner = status.OWNER;

    public Owner(String username, String password, User.status status, User.status owner) {
        super(username, password, status);
        this.owner = User.status.OWNER;
    }
}
