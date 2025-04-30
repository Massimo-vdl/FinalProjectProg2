package org.example;

import java.util.ArrayList;
import java.util.List;

public class Owner extends User{
    private List<Playlist> playlists;

    public Owner(String username, String password, User.status status, User.status owner, List<Playlist> playlists) {
        super(username, password, status);
        this.playlists = new ArrayList<Playlist>();
        this.status = User.status.OWNER;
    }

    /**
     * imports any type of audio from an outside txt file and adds it to a playlist
     * @param filepath the filepath of the txt file
     * @param playlist the playlist the audios are being added to
     */
    public void importAudio(String filepath, Playlist playlist) {
        // TODO
    }

    /**
     * exports a playlist to a txt file
     * @param playlist the playlist that will be exported
     * @param filepath the filepath of the txt file to be altered
     */
    public void exportPlaylist(Playlist playlist, String filepath) {
        // TODO
    }
}

