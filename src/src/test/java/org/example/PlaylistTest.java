package org.example;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PlaylistTest {
    private Playlist playlist;
    private Song song1, song2;
    private Podcast podcast1;

    public void setUp() {
        playlist = new Playlist();
        song1 = new Song("Song One", "Artist A", 180);
        song2 = new Song("Song Two", "Artist B", 210);
        podcast1 = new Podcast("Podcast One", "Host A", 360);
        playlist.addAudio(song1);
        playlist.addAudio(song2);
        playlist.addAudio(podcast1);
    }

    /**
     * test if play will properly play every song by checking if playlist is empty due to recursion
     */
    @Test
    public void testPlay() {
        setUp();
        playlist.play();
        assertTrue(playlist.getPlaylist().isEmpty());
    }

    /**
     * calls the shuffle method and makes sure songs where not removed
     */
    @Test
    public void testShuffle() {
        setUp();
        playlist.shuffle();
        assertEquals(3, playlist.getPlaylist().size());
    }

    /**
     * makes sure the keys and number of songs in each category are correct
     */
    @Test
    public void testSortByType() {
        setUp();
        Map<String, Playlist> result = playlist.sortByType();
        assertEquals(2, result.get("Song").getPlaylist().size());
        assertEquals(1, result.get("Podcast").getPlaylist().size());
    }

    /**
     * makes sure each key is correct as well as the amount of audios for said key
     */
    @Test
    public void testSortByCreator() {
        setUp();
        Map<String, List<Audio>> map = playlist.sortByCreator();
        assertTrue(map.containsKey("Artist A"));
        assertTrue(map.containsKey("Artist B"));
        assertTrue(map.containsKey("Host A"));
        assertEquals(1, map.get("Artist A").size());
    }

    /**
     * test if when a creator is not found the audio is place into the unknown creator category
     */
    @Test
    public void testSortByCreatorNoCreatorFound() {
        setUp();
        Map<String, List<Audio>> map = playlist.sortByCreator();
        assertFalse(map.containsKey("Unknown Artist"));
    }

    /**
     * checks if the first audio is shorter than the last to establish if they were correctly sorted by time
     */
    @Test
    public void testOrderByTime() {
        setUp();
        LinkedList<Audio> sorted = playlist.orderByTime();
        assertEquals(song1, sorted.getFirst());
        assertEquals(podcast1, sorted.getLast());
    }

    /**
     * checks that the audios do get sorted by keyword
     */
    @Test
    public void testSearchByKeyword() {
        setUp();
        List<Audio> result = playlist.searchByKeyword("One");
        assertEquals(2, result.size());
    }

    /**
     * checks that even if the keyword is capitalized it will still find them
     */
    @Test
    public void testSearchByKeywordIsCapitalized() {
        setUp();
        List<Audio> result = playlist.searchByKeyword("sOnG");
        assertEquals(2, result.size());
    }

    /**
     * checks that if no audio contains the keyword the list will be empty
     */
    @Test
    public void testSearchByKeywordNotDetected() {
        setUp();
        List<Audio> result = playlist.searchByKeyword("Nonexistent");
        assertTrue(result.isEmpty());
    }

}
