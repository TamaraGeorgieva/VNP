package mk.finki.ukim.mk.lab.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
public class Song {
    @Getter
    private String trackId;
    @Getter
    private String title;
    @Getter
    private String genre;
    @Getter
    private int releaseYear;
    List<Artist> performers;

    public Song() {
    }

    public Song(String trackId, String title, String genre, int releaseYear) {
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;

        performers = new ArrayList<>();
    }

    public void addPerformer(Artist performer) {
        performers.add(performer);
    }
}