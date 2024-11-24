package mk.finki.ukim.mk.lab.repostiroy;

import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Album;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class AlbumRepository {


    public List<Album> findAll() {
        return DataHolder.albumList;
    }

    public Optional<Album> findById(Long id) {
        return DataHolder.albumList.stream().filter(artist -> artist.getId().equals(id)).findFirst();
    }
}
