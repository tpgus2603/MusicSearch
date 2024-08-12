package hello.musicsearch.controller;

import hello.musicsearch.dto.FavoriteDto;
import hello.musicsearch.dto.MusicList;
import hello.musicsearch.entity.FavoriteMusic;
import hello.musicsearch.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    MusicService service;

    // 홈 화면 표시
    @GetMapping
    public String showHomePage() {
        return "home";  // home.html 뷰를 반환
    }

    // 검색 기능 처리
    @GetMapping("/search")
    public String musicSearchByParam(@RequestParam(value="term", required=false) String name, Model model) {
        if (StringUtils.hasText(name)) {
            MusicList musicList = service.searchMusic(name);
            model.addAttribute("musicList", musicList);
            return "musics";  // 검색 결과를 musics.html에 표시
        }
        return "redirect:/home";  // 검색어가 없으면 홈 화면으로 리다이렉트
    }

    @GetMapping("/likes")
    public List<FavoriteMusic> getLikes() {
        return service.getLikes();
    }

    @PostMapping("/likes")
    public String postLikes(@ModelAttribute FavoriteDto favorite) {
        service.saveFavorite(favorite);
        return "redirect:/home";
    }

    @DeleteMapping("/likes/{id}")
    public void deleteid(@PathVariable String id) {
        service.deleteFavorite(id);
    }
}
