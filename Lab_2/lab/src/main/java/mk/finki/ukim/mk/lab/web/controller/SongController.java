package mk.finki.ukim.mk.lab.web.controller;


import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import mk.finki.ukim.mk.lab.model.Song;
import java.util.List;


@Controller
@RequestMapping("/songs")
public class SongController {
    public final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }
    @GetMapping()
    public String getSongsPage(@RequestParam(required = false) String error, Model model)
    {
        List<Song> songs = this.songService.listSongs();
        model.addAttribute("songs", songs);
        return "listSongs";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam String trackId, @RequestParam String title, @RequestParam String genre, @RequestParam int releaseYear, @RequestParam Album album, Model model)
    {

            this.songService.saveSong(trackId, title, genre, releaseYear, album);
            return "redirect:/songs";


    }
    @PostMapping("/edit/{id}")
    public String editSong(@PathVariable Long id, @RequestParam String trackId, @RequestParam String title, @RequestParam String genre, @RequestParam int releaseYear, @RequestParam Album album, Model model)
    {
        this.songService.editSong(id,trackId, title, genre, releaseYear, album);
        return "redirect:/songs";
    }

    @DeleteMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        this.songService.deleteSong(id);
        return "redirect:/songs";
    }

    @GetMapping("/songs/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model) {
        if (this.songService.findById(id).isPresent()) {
            Song song = this.songService.findById(id).get();
            List<Artist> artists = song.getPerformers();
            model.addAttribute("songs", song);
            model.addAttribute("artists", artists);
            return "add-song.html";
        }
        else{
            return "redirect:/songs";
        }
    }
}

