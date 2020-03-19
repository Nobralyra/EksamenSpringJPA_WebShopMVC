package web_shop.exercise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web_shop.exercise.Service.ProductService;

@Controller
public class IndexController
{
    @Autowired
    ProductService productService;

    @GetMapping({"", "/", "/index/"})
    public String IndexPage(Model model)
    {
        //add all animals to view model from animalService
        model.addAttribute("products", productService.readAll());
        return ("/index");
    }
}

