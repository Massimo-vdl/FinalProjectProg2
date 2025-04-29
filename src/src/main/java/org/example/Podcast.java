package org.example;

public class Podcast extends Audio  implements Playable{

    public Podcast(String title, String creator, int duration) {
        super(title, creator, duration);
    }

    @Override
    public String toString() {
        return "Podcast: " + title + " "+ duration/60 + " min" +
                "\n By: " + creator;
    }

    @Override
    public void play() {
        System.out.println("\uD83C\uDFA4 Now playing: '" + getTitle() +
                "' by " + getCreator() + " [" + getDuration()/60 + " min]");
    }
}
