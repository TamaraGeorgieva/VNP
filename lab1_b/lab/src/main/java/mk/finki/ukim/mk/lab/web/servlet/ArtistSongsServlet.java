package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.Impl.ArtistServiceImpl;
import mk.finki.ukim.mk.lab.service.Impl.SongServiceImpl;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ArtistSongs", urlPatterns = {"/artistSongs", "/artistSongs/*"})
public class ArtistSongsServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final SongServiceImpl songService;
    private final ArtistServiceImpl artistService;

    public ArtistSongsServlet(SpringTemplateEngine templateEngine, SongServiceImpl songService, ArtistServiceImpl artistService) {
        this.templateEngine = templateEngine;
        this.songService = songService;
        this.artistService = artistService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistId = req.getPathInfo();
        artistId = artistId.split("/")[1];
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        if(artistId != null){
            Artist artist = artistService.findById(Long.valueOf(artistId));
            context.setVariable("artist", artist);

            // Taking Songs for Artist
            List<Song> artistSongs = songService.listSongs().stream()
                    .filter(s -> s.getPerformers().contains(artist))
                    .toList();
            context.setVariable("artistSongs", artistSongs);
        }

        templateEngine.process("artistSongs.html", context, resp.getWriter());
    }
}
