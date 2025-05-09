package org.example;

import java.util.Objects;

public abstract class Audio implements Playable, Comparable<Audio> {
    protected String title;
    protected String creator;
    protected int duration;

    public Audio(String title, String creator, int duration) {
        this.title = title;
        this.creator = creator;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audio audio = (Audio) o;
        return duration == audio.duration && Objects.equals(title, audio.title) && Objects.equals(creator, audio.creator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, creator, duration);
    }

    @Override
    public String toString() {
        return "Audio{" +
                "title='" + title + '\'' +
                ", creator='" + creator + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public void play() {
    }

    /**
     * compares Audios based on duration then title
     * @param o the object to be compared.
     * @return 0 if equal 1 if user1 comes second -1 if user1 comes first
     */
    @Override
    public int compareTo(Audio o) {
        int durationCompare = Integer.compare(this.duration, o.duration);
        if (durationCompare != 0) {
            return durationCompare;
        }
        return this.title.compareToIgnoreCase(o.title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
