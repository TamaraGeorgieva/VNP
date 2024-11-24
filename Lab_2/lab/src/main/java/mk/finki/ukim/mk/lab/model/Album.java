package mk.finki.ukim.mk.lab.model;
import jakarta.persistence.*;


import lombok.Data;

import java.util.List;

@Data
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    @OneToMany
    private List<Song> songs;

    public Album(String name, String genre, String releaseYear, List<Song> songs) {
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.songs = songs;
    }

    public Album () {

    }
}
