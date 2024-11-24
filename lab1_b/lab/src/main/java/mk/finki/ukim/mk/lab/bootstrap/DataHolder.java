package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artistList = new ArrayList<>();
    public static List<Song> songList = new ArrayList<>();

    @PostConstruct
    public void init() {
        artistList.add(new Artist(1L, "Kristijan", "Kamishev", "Majstor"));
        artistList.add(new Artist(2L, "Riste", "Ristevski", "Ne go biva"));
        artistList.add(new Artist(3L, "Vlado", "Vladov", "Legenda"));
        artistList.add(new Artist(4L, "Petar", "Petarski", "Uspan"));
        artistList.add(new Artist(5L, "Marko", "Markovski", "Marcheta"));

        songList.add(new Song("ABC", "Highway to Hell", "Rock", 2024));
        songList.add(new Song("DEF", "Idk", "Turbofolk", 2000));
        songList.add(new Song("GHI", "TestTitle", "Metal", 1990));
        songList.add(new Song("JKL", "Test123", "Techno", 2010));
        songList.add(new Song("MNO", "Deep house", "DeepHouse", 2015));
    }
}