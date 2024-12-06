package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String showHomepage() {
        return "index";  // The template name for rendering index.html via Thymeleaf
    }
}
