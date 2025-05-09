package org.example;

import java.util.*;

public class Playlist implements Playable{
    private String title;
    private Queue<Audio> playlist;
    private int rating;

    public Playlist() {
        this.title = "";
        this.playlist = new LinkedList<>();
    }

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
     * adds an audio at the end of the playlist Queue
     * @param audio the audio that will be added
     */
    public void addAudio(Audio audio) {
        playlist.offer(audio);
    }

    /**
     * displays all the songs in a playlist in the order they were queued
     */
    @Override
    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("✅ Finished playing all audios in the playlist.");
            return;
        }

        Audio current = playlist.poll();
        if (current != null) {
            current.play();
            try {
                Thread.sleep(500); // 0.5 second delay (500 milliseconds)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Playback interrupted.");
            }
        }

        play();
    }

    /**
     * suffles a playlist by playing the audios queued in a random order
     * @return the playlist in random order
     */
    public void shuffle () {
        List<Audio> audioList = new ArrayList<>(playlist);  // Convert Queue to List
        Collections.shuffle(audioList);  // Shuffle the List

        System.out.println("🎵 Shuffling and playing the playlist in random order:");

        // Play the shuffled audio
        for (Audio audio : audioList) {
            audio.play();
            try {
                Thread.sleep(250);  // Delay of 0.25 seconds between each play
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Playback interrupted.");
            }
        }

        System.out.println("✅ Finished playing the shuffled playlist.");
    }

    /**
     * sorts a playlist into the two audio types Podcast and Song
     * @return a map where the audio type is the key and the
     * resulting playlist of just that audio type is the value
     */
    public Map<String, Playlist> sortByType() {
        Playlist songPlaylist = new Playlist();
        Playlist podcastPlaylist = new Playlist();

        // Iterate through the original playlist and sort by type
        for (Audio audio : playlist) {
            if (audio instanceof Song) {
                songPlaylist.addAudio(audio);  // Add Song to songPlaylist
            } else if (audio instanceof Podcast) {
                podcastPlaylist.addAudio(audio);
            }// Add Podcast to podcastPlaylist
        }
        Map<String, Playlist> typeMap = new HashMap<>();
        typeMap.put("Song", songPlaylist);
        typeMap.put("Podcast", podcastPlaylist);

        return typeMap;
    }

    /**
     * sorts a playlist by creator grouping all audios by a creator in groups
     * @return a map where the creator is the key and the
     * resulting list of audios made by that creator are the value
     */
    public Map<String, List<Audio>> sortByCreator() {
        Map<String, List<Audio>> creatorMap = new HashMap<>();

        for (Audio audio : playlist) {
            String creator = audio instanceof Song ? ((Song) audio).getCreator()
                    : audio instanceof Podcast ? ((Podcast) audio).getCreator()
                    : "Unknown";

            creatorMap.putIfAbsent(creator, new ArrayList<>());
            creatorMap.get(creator).add(audio);
        }

        return creatorMap;
    }

    /**
     * creates a new list were all audios are sorted by time from shortest to longest
     * @return a list of audio sorted by duration form shortest to longest
     */
    public LinkedList<Audio> orderByTime() {
        List<Audio> sorted = new ArrayList<>(playlist);
        sorted.sort(Comparator.comparingInt(Audio::getDuration));
        return new LinkedList<>(sorted);
    }

    /**
     * creates a list of audio based on the keyword entered
     * @param keyword the input keyword
     * @return a list of audios that include the keyword
     */
    public List<Audio> searchByKeyword(String keyword) {
        List<Audio> result = new ArrayList<>();
        for (Audio audio : playlist) {
            if (audio.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(audio);
            }
        }
        return result;
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
