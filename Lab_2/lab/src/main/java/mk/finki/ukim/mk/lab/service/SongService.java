package mk.finki.ukim.mk.lab.service;

import java.util.List;
import java.util.Optional;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
    Optional<Song> saveSong(String trackId, String title, String genre, int releaseYear, Album album);
    Optional<Song> editSong(Long id,String trackId, String title, String genre, int releaseYear, Album album);
    void deleteSong(Long id);
    Optional<List<Song>> findAllSongsByArtistId(Long id);
    Optional<Song> findById(Long id);

}