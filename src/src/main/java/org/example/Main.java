package org.example;

import java.sql.SQLOutput;
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

        System.out.println("Welcome to PlaylistEditor please log in: ");
        if (scanner.nextLine().equals(owner.username)) {
            System.out.println("Please enter your password: ");
            if (scanner.nextLine().equals(owner.password)) {

            }
        }
    }
}