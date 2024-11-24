package mk.finki.ukim.mk.lab.repostiroy;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {

    public List<Song> findAll() {
        return DataHolder.songList;
    }

    public Song findByTrackId(String trackId) {
        return DataHolder.songList.stream().filter(s -> s.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public static Song findById(Long id) {
        return DataHolder.songList.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    public Artist addArtistToSong(Song song, Artist artist) {
        for (Song s : DataHolder.songList) {
            if (s.getTrackId().equals(song.getTrackId())) {
                s.addPerformer(artist);
                return artist;
            }
        }
        return null;
    }

    public Song save(Song song) {
        DataHolder.songList.add(song);
        return song;
    }

    public Optional<Song> editSong(Long id, String trackId, String title, String genre, int releaseYear, Album album) {
        Song song = this.findById(id);
        Song song2 = new Song(trackId, title, genre, releaseYear, album);
        song = song2;
        return Optional.of(this.save(song));
    }

    public Song delete(Long id){
        Song song = this.findById(id);
        DataHolder.songList.remove(song);
        return song;
    }

    public List<Song> findPerformers(Long id) {
        List<Song> songs = new ArrayList<>();
        for (Song s : DataHolder.songList) {
            if (s.getPerformers().equals(id)) {
                songs.add(s);
            }
        }
        return songs;
    }
}