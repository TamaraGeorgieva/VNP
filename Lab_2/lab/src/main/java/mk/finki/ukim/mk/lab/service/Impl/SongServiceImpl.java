package mk.finki.ukim.mk.lab.service.Impl;

import java.util.List;
import java.util.Optional;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repostiroy.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(song, artist);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public Optional<Song> saveSong(String trackId, String title, String genre, int releaseYear, Album album) {
       Song song = new Song(trackId, title, genre, releaseYear, album);
         return Optional.of(songRepository.save(song));
    }

    @Override
    public Optional<Song> editSong(Long id, String trackId, String title, String genre, int releaseYear, Album album) {
        this.songRepository.editSong(id, trackId, title, genre, releaseYear, album);
        return Optional.of(this.songRepository.findById(id));
    }

    @Override
    public void deleteSong(Long id) {
        this.songRepository.delete(id);
    }

    @Override
    public Optional<List<Song>> findAllSongsByArtistId(Long id) {
        return Optional.of(this.songRepository.findPerformers(id));

    }

    @Override
    public Optional<Song> findById(Long id) {
        return Optional.of(SongRepository.findById(id));
    }


}