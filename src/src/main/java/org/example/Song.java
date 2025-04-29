package org.example;

public class Song extends Audio  implements Playable{

    public Song(String title, String creator, int duration) {
        super(title, creator, duration);
    }

    @Override
    public void play() {
        // TODO
    }
}
