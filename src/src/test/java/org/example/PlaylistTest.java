package org.example;

import org.junit.Test;

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

    @Test
    public void testPlay() {
        setUp();
    }

    @Test
    public void testShuffle() {

    }

    @Test
    public void testSortByType() {

    }

    @Test
    public void testSortByCreator() {

    }

    @Test
    public void testSortByCreatorNoCreatorFound() {

    }

    @Test
    public void testOrderByTime() {

    }

    @Test
    public void testSearchByKeyword() {

    }

    @Test
    public void testSearchByKeywordIsCapitalized() {

    }

    @Test
    public void testSearchByKeywordNotDetected() {

    }

}
