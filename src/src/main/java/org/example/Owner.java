package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Owner extends User{
    private List<Playlist> playlists;

    public Owner(String username, String password, List<Playlist> playlists) {
        super(username, password, status);
        this.playlists = new ArrayList<Playlist>();
        setStatus(User.status.OWNER);
    }

    /**
     * imports any type of audio from an outside txt file and adds it to a playlist
     * @param playlist the playlist the audios are being added to
     */
    public void importAudio(Playlist playlist) {
        String filepath = "src/src/main/resources/Audios.txt";
        try (Scanner scanner = new Scanner(new File(filepath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 4) {
                    String type = parts[0].trim();
                    String creator = parts[1].trim();
                    String title = parts[2].trim();
                    int duration;

                    try {
                        duration = Integer.parseInt(parts[3].trim());
                        Audio audio;

                        if (type.equalsIgnoreCase("Song")) {
                            audio = new Song(title, creator, duration);
                        } else if (type.equalsIgnoreCase("Podcast")) {
                            audio = new Podcast(title, creator, duration);
                        } else {
                            System.out.println("Unknown type: " + type);
                            continue;
                        }

                        playlist.addAudio(audio);
                        System.out.println("Added: " + title + " by " + creator);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid duration for: " + line);
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
            System.out.println("Audio import complete.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filepath);
        }
    }

    /**
     * exports a playlist to a txt file
     * @param playlist the playlist that will be exported
     */
    public void exportPlaylist(Playlist playlist) {
        try (FileWriter writer = new FileWriter("src/src/main/resources/Playlist.txt")) {
            for (Audio audio : playlist.getPlaylist()) {
                writer.write(audio.getClass().getSimpleName() + "," +
                        audio.getCreator() + "," +
                        audio.getTitle() + "," +
                        audio.getDuration() + "\n");
            }
            System.out.println("Playlist successfully exported to " + "src/src/main/resources/Playlist.txt");
        } catch (Exception e) {
            System.out.println("Error exporting playlist: " + e.getMessage());
        }
    }
}
