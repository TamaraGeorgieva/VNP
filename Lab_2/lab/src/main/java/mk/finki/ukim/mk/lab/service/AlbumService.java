package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import java.util.List;

public interface AlbumService {
    List<Album> listAlbums();
    Album findById(Long id);
}