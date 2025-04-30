package org.example;

public class Listener extends User{

    public Listener(String username, String password, User.status status, User.status listener) {
        super(username, password, status);
        this.status = User.status.LISTENER;
    }

    /**
     * allows the listener to rate a playlist on a score from 1 to 10
     * @param playlist the playlist that the user is rating
     * @param rating the rating from 1 to 10
     */
    public void ratePlaylist(Playlist playlist, int rating) {
        if (rating >= 1 && rating <= 10) {
            playlist.setRating(rating);
            System.out.println("You rated the playlist \"" + playlist.getTitle() + "\" with a score of " + rating + "/10.");
        } else {
            System.out.println("Invalid rating. Please provide a value between 1 and 10.");
        }
    }
}
