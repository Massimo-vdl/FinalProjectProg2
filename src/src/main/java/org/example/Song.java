package org.example;

public class Song extends Audio  implements Playable{

    public Song(String title, String creator, int duration) {
        super(title, creator, duration);
    }

    @Override
    public String toString() {
        return "Song: " + title + " "+ duration + " sec" +
                "\n By: " + creator;
    }

    @Override
    public void play() {
        System.out.println("🎵 Now playing: '" + getTitle() +
                "' by " + getCreator() + " [" + getDuration() + " sec]");
    }
}
