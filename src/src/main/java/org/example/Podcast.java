package org.example;

public class Podcast extends Audio  implements Playable{

    public Podcast(String title, String creator, int duration) {
        super(title, creator, duration);
    }

    @Override
    public void play() {
        // TODO
    }
}
