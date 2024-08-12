package hello.musicsearch.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @RequestMapping("/")
    public String home() {
        return "redirect:/home";
    }
}
