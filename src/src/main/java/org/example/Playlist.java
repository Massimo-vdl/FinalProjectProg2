package org.example;

import java.util.Queue;

public class Playlist implements Playable{
    private String title;
    private Queue<Audio> playlist;

    public Playlist(String title, Queue<Audio> playlist) {
        this.title = title;
        this.playlist = playlist;
    }

    @Override
    public void play() {
        // TODO
    }
}
