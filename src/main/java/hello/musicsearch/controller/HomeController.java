package hello.musicsearch.controller;

import hello.musicsearch.dto.FavoriteDto;
import hello.musicsearch.dto.MusicList;
import hello.musicsearch.entity.FavoriteMusic;
import hello.musicsearch.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/home")
@Controller
public class HomeController {

    @Autowired
    MusicService service;

    @GetMapping
    public String musicSearchByParam(@RequestParam(value="term") String name, Model model) {
        MusicList musicList = service.searchMusic(name);
        model.addAttribute("musicList",musicList);
        return "musics";
    }

    @GetMapping(value="/likes")  //Get Favorite Music list from Database
    public List<FavoriteMusic> getLikes() {
        return service.getLikes();
    }

    @PostMapping(value="/likes")
    public int postLikes(@RequestBody FavoriteDto favorite) {
        return service.saveFavorite(favorite);
    }
    @DeleteMapping(value = "/likes/{id}")
    public void deleteid(@PathVariable String id){
        service.deleteFavorite(id);
    }
}
