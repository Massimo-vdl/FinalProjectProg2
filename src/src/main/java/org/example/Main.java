package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Playlist playlist = new Playlist();
        //Playlist rockPlaylist = new Playlist();
        //Playlist chillPlaylist = new Playlist();
        //Playlist studyPlaylist = new Playlist();

        //List<Playlist> playlists = new ArrayList<>(List.of(rockPlaylist, chillPlaylist, studyPlaylist));
        List<Playlist> playlists = new ArrayList<>();
        Owner owner = new Owner("Massimo", "12345abcde", playlists);
        Listener listener = new Listener("Luca", "abcde12345");

        System.out.println("Welcome to PlaylistEditor, Please log in: ");
        System.out.print("Username: ");
        String inputUsername = scanner.nextLine();

        System.out.print("Password: ");
        String inputPassword = scanner.nextLine();

        if (inputUsername.equals(owner.getUsername()) && inputPassword.equals(owner.getPassword())) {
            System.out.println("✅ Owner logged in successfully!");
            System.out.println("Please select a Playlist to Edit");
            Playlist selected = selectPlaylist(scanner, playlists);
            System.out.println("Please type what you would like to do, Options: \n" +
                    "Play (Play)\nShuffle (Shuffle)\nSort by type of audio (SortByType)" +
                    "\nSearch for a creator (SearchByCreator)\nOrder audios by time (OrderByTime)" +
                    "\nSearch with a keyword (SearchByKeyword)\nType next for Owner exclusive options" +
                    "\nEnter your choice here: ");
            Options(scanner, selected, owner);
            System.out.println("Thank you for using PlaylistEditor!");

        } else if (inputUsername.equals(listener.getUsername()) && inputPassword.equals(listener.getPassword())) {
            System.out.println("✅ Listener logged in successfully!");
            System.out.println("Please select a Playlist to View: ");
            Playlist selected = selectPlaylist(scanner, playlists);
            System.out.println("Options: ");
            System.out.println("Please type what you would like to do (type as written in the brackets)\n[Options]\n" +
                    "Play (Play)\nShuffle (Shuffle)\nSort by type of audio (SortByType)" +
                    "\nSearch for a creator (SearchByCreator)\nOrder audios by time (OrderByTime)" +
                    "\nSearch with a keyword (SearchByKeyword)\nType next for Listener exclusive options" +
                    "\nEnter your choice here: ");
            Options(scanner, selected, listener);
            System.out.println("Thank you for using PlaylistEditor!");

        } else {
            System.out.println("❌ Login failed. Incorrect credentials.");
        }
    }

    /**
     * Calls all the functionalities of Owner and Playlist if the login is successful
     */
    public static void Options(Scanner scanner, Playlist playlist, User user) {
        if (user instanceof Listener && playlist == null) {
            return;
        }
        String answer = scanner.nextLine();

        switch (answer.toLowerCase()) {
            case "play" -> playlist.play();
            case "shuffle" -> playlist.shuffle();
            case "sortbytype" -> playlist.sortByType();
            case "searchbycreator" -> playlist.sortByCreator();
            case "orderbytime" -> playlist.orderByTime();
            case "searchbykeyword" -> {
                System.out.println("Please type in the keyword: "); 
                String keyword = scanner.nextLine();
                playlist.searchByKeyword(keyword);
            }
            case "next" -> {
                if (user instanceof Owner) {
                    System.out.println("Would you like to export this playlist or import audios: ");
                    String answer2 = scanner.nextLine();
                    if (answer2.equals("export")) {
                        ((Owner) user).exportPlaylist(playlist);

                    } else if (answer2.equals("import")) {
                        ((Owner) user).importAudio(playlist);

                    } else {
                        System.out.println("No valid option selected");
                    }
                } else if (user instanceof Listener) {
                    System.out.println("What would you like to rate this playlist? Select a number from 1-10");
                    int rating = scanner.nextInt();
                    ((Listener) user).ratePlaylist(playlist, rating);
                }
            }

        }
    }

    public static Playlist selectPlaylist(Scanner scanner, List<Playlist> playlists) {
        if (playlists.isEmpty()) {
            return null;
        }
        System.out.println("Available playlists:");
        for (int i = 0; i < playlists.size(); i++) {
            System.out.println(i + ": Playlist " + (i + 1));
        }

        int index = -1;
        while (index < 0 || index >= playlists.size()) {
            System.out.print("Enter the number of the playlist you want to use: ");
            if (scanner.hasNextInt()) {
                index = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        return playlists.get(index);
    }
}
