package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping()
    public String getArtistsPage(Model model) {
        List<Artist> artists = this.artistService.listArtists();
        model.addAttribute("artists", artists);
        return "listArtists";
       /* HTML
        th:each artist : ${artists} {
              <tr>
                <td>${artist.artistId}</td>
                <td>${artist.name}</td>
                <td>${artist.surname}</td>
                <td>${artist.artistType}</td>
                <td>${artist.country}</td>
                <td>${artist.bandName}</td>
                <td>${artist.dateOfBirth}</td>
                <td>${artist.dateOfDeath}</td>
              </tr>
        }
        */
    }

    @GetMapping("/artist/{id}")
    public String getArtistSongsPage(@PathVariable Long id, Model model) {
        Optional<List<Song>> artistSongs = this.songService.findAllSongsByArtistId(id);
        model.addAttribute("songs", artistSongs);
        return "listSongs";
    }

}


