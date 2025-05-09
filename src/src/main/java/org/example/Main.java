package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Playlist playlist = new Playlist();
        List<Playlist> playlists = new ArrayList<>();
        Owner owner = new Owner("Massimo", "12345abcde", playlists);
        Listener listener = new Listener("Luca", "abcde12345");

        System.out.println("Welcome to PlaylistEditor. Please log in: ");
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(owner.getUsername()) && inputPassword.equals(owner.getPassword())) {
            System.out.println("✅ Owner logged in successfully!");
            // Owner operations here
        } else if (inputUsername.equals(listener.getUsername()) && inputPassword.equals(listener.getPassword())) {
            System.out.println("✅ Listener logged in successfully!");
            // Listener operations here
        } else {
            System.out.println("❌ Login failed. Incorrect credentials.");
        }
    }

    /**
     * Calls all the functionalities of Owner and Playlist if the login is successful
     */
    public static void  ownerOptions() {

    }

    /**
     * Calls all the functionalities of Listener and Playlist if the login is successful
     */
    public static void  listenerOptions() {

    }
}