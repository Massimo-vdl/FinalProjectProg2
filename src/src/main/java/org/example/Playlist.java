package org.example;

import java.util.*;

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

    /**
     * displays all the songs in a playlist in the order they were queued
     */
    @Override
    public void play() {
        // TODO
    }

    /**
     * suffles a playlist by playing the audios queued in a random order
     * @return the playlist in random order
     */
    public LinkedList<Playlist> shuffle () {
        // TODO
    }

    /**
     * sorts a playlist into the two audio types Podcast and Song
     * @return a map where the audio type is the key and the
     * resulting playlist of just that audio type is the value
     */
    public Map<String, Playlist> sortByType() {
        // TODO
    }

    /**
     * sorts a playlist by creator grouping all audios by a creator in groups
     * @return a map where the creator is the key and the
     * resulting list of audios made by that creator are the value
     */
    public Map<String, List<Audio>> sortByCreator() {
        // TODO
    }

    /**
     * creates a new list were all audios are sorted by time from shortest to longest
     * @return a list of audio sorted by duration form shortest to longest
     */
    public LinkedList<Audio> orderByTime() {
        // TODO
    }

    /**
     * creates a list of audio based on the keyword entered
     * @param keyword the input keyword
     * @return a list of audios that include the keyword
     */
    public List<Audio> searchByKeyword(String keyword) {
        // TODO
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
}
