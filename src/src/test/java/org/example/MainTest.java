package org.example;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {
    private Playlist playlist;
    private Playlist playlist1;
    private Playlist playlist2;
    private Playlist playlist3;
    private List<Playlist> playlists;
    private Owner owner;
    private Listener listener;

    public void setup() {
        playlist = new Playlist();
        playlist1 = new Playlist();
        playlist2 = new Playlist();
        playlist3 = new Playlist();
        List<Playlist> playlists = new ArrayList<>(List.of(playlist1, playlist2, playlist3));
        owner = new Owner("Massimo", "12345abcde", playlists);
        listener = new Listener("Luca", "abcde12345");
    }

    @Test
    public void testSelectPlaylist_ValidIndex() {
        setup();
        String input = "1\n";
        Scanner scanner = new Scanner(input);
        Playlist selected = Main.selectPlaylist(scanner, playlists);
        assertEquals(playlist2, selected);
    }

    @Test
    public void testSelectPlaylist_InvalidIndex() {
        setup();
        String input = "-1\n1\n";  // First invalid, then valid
        Scanner scanner = new Scanner(input);
        Playlist selected = Main.selectPlaylist(scanner, owner.getPlaylists());
        assertEquals(playlist2, selected);
    }

    //NOTE these tests are strictly testing if the scanner inputs work
    // the actual methods will be tested in the proper test classes

    /**
     * test whether the input "play" calls the play method
     */
    @Test
    public void testOptionsPlay() {
        setup();
        playlist.addAudio(new Song("Song1", "Creator1", 120));
        String input = "play\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, listener);
    }

    /**
     * test whether the input "play" calls the play method
     */
    @Test
    public void testOptionsShuffle() {
        setup();
        playlist.addAudio(new Song("Song1", "Creator1", 120));
        playlist.addAudio(new Song("Song2", "Creator2", 100));
        String input = "shuffle\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, listener);
    }

    /**
     * test whether the input "play" calls the play method
     * if it works no exception will be thrown
     */
    @Test
    public void testOptionsSortByType() {
        setup();
        playlist.addAudio(new Song("Song1", "Creator1", 120));
        String input = "sortbytype\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, listener);
    }

    /**
     * test whether the input "searchbycreator + creator" calls the searchByCreator method
     * if it works no exception will be thrown
     */
    @Test
    public void testOptionsSearchByCreator() {
        setup();
        playlist.addAudio(new Song("Song1", "Creator1", 120));
        String input = "searchbycreator\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, listener);
    }

    /**
     * test whether the input "orderbytime" calls the sortByTime method
     * if it works no exception will be thrown
     */
    @Test
    public void testOptionsOrderByTime() {
        setup();
        playlist.addAudio(new Song("Song1", "Creator1", 120));
        String input = "orderbytime\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, listener);
    }

    /**
     * test whether the input "searchbykeyword + keyword" calls the searchByKeyword method
     * if it works no exception will be thrown
     */
    @Test
    public void testOptionsSearchByKeyword() {
        setup();
        playlist.addAudio(new Song("Amazing Track", "Creator1", 120));
        String input = "searchbykeyword\nAmazing\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, listener);
    }

    /**
     * test whether the input "next" and not correct input call the export or import methods
     * if it works no exception will be thrown
     */
    @Test
    public void testOptionsOwnerOptions() {
        setup();
        String input = "next\ninvalid\n";  // next → invalid sub-option
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, owner);
    }

    /**
     * test whether the input "export" calls the exportPlaylist method
     * if it works no exception will be thrown
     */
    @Test
    public void testOptionsOwnerExport() {
        setup();
        String input = "next\nexport\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, owner);
    }

    /**
     * test whether the input "import" calls the importAudio method
     * if it works no exception will be thrown
     */
    @Test
    public void testOptionsOwnerImport() {
        setup();
        String input = "next\nimport\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, owner);
    }

    /**
     * test whether the input "next" and "int rating" call the ratePlaylist method
     * if it works no exception will be thrown
     */
    @Test
    public void testOptionsListenerRating() {
        setup();
        String input = "next\n8\n";
        Scanner scanner = new Scanner(input);
        Main.Options(scanner, playlist, listener);
    }
}
