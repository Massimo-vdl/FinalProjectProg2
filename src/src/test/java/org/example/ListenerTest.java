package org.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ListenerTest {
    private Listener listener;
    private Playlist playlist;

    public void setUp() {
        listener = new Listener("Luca", "abcde12345");
        playlist = new Playlist();
        playlist.setTitle("Playlist :)");  // So the message prints the title
    }

    /**
     * test if a valid rating properly changes the rating of a playlist
     */
    @Test
    public void ratePlaylistTest() {
        setUp();
        listener.ratePlaylist(playlist, 8);
        assertEquals(8, playlist.getRating());
    }

    /**
     * test that a invalid rating is not accepted and that it does not change the rating already set
     */
    @Test
    public void ratePlaylistInvalidRatingTest() {
        setUp();
        playlist.setRating(5);  // Set an initial valid rating
        listener.ratePlaylist(playlist, 11);  // Invalid rating
        assertEquals(5, playlist.getRating());  // Should not change
    }

}
