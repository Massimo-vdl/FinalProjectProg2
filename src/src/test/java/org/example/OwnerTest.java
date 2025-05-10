package org.example;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OwnerTest {
    private Owner owner;
    private Playlist playlist;
    private final String testExportPath = "src/src/main/resources/Playlist.txt";

    public void setUp() throws IOException {
        playlist = new Playlist();
        owner = new Owner("Massimo", "12345abcde", new ArrayList<>());

        // Write a test file for import
        try (FileWriter writer = new FileWriter(playlist.getFilenameAudio())) {
            writer.write("Song,Artist1,Test Song,180\n");
            writer.write("Podcast,Speaker1,Test Podcast,360\n");
        }
    }

    public void tearDown() {
        // Clean up test files
        new File(playlist.getFilenameAudio()).delete();
        new File(testExportPath).delete();
    }

    //Kept getting fileNotFound despite it working in the main method
    @Test
    public void importAudioTest() throws IOException {
        setUp();
        assertEquals(0, playlist.getPlaylist().size());
        owner.importAudio();

        Queue<Audio> audios1 = playlist.getPlaylist();
        List<Audio> audios = audios1.stream().toList();
        assertEquals(2, audios.size());
        assertTrue(audios.get(0) instanceof Song);
        assertTrue(audios.get(1) instanceof Podcast);
        assertEquals("Test Song", audios.get(0).getTitle());
        assertEquals("Test Podcast", audios.get(1).getTitle());

        tearDown();
    }

    //Kept getting fileNotFound despite it working in the main method
     @Test
    public void exportPlaylistTest() throws IOException {
        setUp();
         playlist.addAudio(new Song("Song1", "Creator1", 200));
         playlist.addAudio(new Podcast("Podcast1", "Speaker1", 300));

         owner.exportPlaylist(playlist);

         File file = new File(testExportPath);
         assertTrue(file.exists());

        tearDown();
    }

}
