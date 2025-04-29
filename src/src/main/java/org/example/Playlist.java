package org.example;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Playlist implements Playable{
    private String title;
    private Queue<Audio> playlist;
    private int rating;

    public Playlist(String title, Queue<Audio> playlist) {
        this.title = title;
        this.playlist = new LinkedList<>(playlist);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist1 = (Playlist) o;
        return rating == playlist1.rating && Objects.equals(title, playlist1.title) && Objects.equals(playlist, playlist1.playlist);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, playlist, rating);
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "title='" + title + '\'' +
                ", playlist=" + playlist +
                ", rating=" + rating +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Queue<Audio> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(Queue<Audio> playlist) {
        this.playlist = playlist;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public void play() {
        // TODO
    }
}
