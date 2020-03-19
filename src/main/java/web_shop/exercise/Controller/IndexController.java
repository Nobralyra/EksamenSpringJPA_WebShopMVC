package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController
{
    @GetMapping({"", "/", "/index/"})
    public String IndexPage(Model model)
    {
        return ("/index");
    }
}

