package web_shop.exercise.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Model.Product;
import web_shop.exercise.Service.ProductService;

@Controller
public class IndexController
{
    @Autowired
    ProductService productService;

    @GetMapping({"", "/"})
    public String IndexPage(Model model)
    {
        //add all animals to view model from animalService
        model.addAttribute("products", productService.ReadAll());
        return ("/index");
    }

    @GetMapping("/create")
    public String Create(Product product, Model model)
    {
        model.addAttribute("products", product);
        return "/create";
    }

    @PostMapping("/create")
    public String CreateProduct(@ModelAttribute Product product)
    {
        productService.Create(product);
        return "redirect:/";
    }

    //use PathVariable to fetch id from list on web page
    @GetMapping("/update/{id}")
    public String Update(@PathVariable("id") long id, Model model)
    {
        //add product with id to the model view
        model.addAttribute("products", productService.Read(id));
        return "/update";
    }

    //update product
    @PostMapping("/update")
    public String Update(@ModelAttribute Product product)
    {
        productService.Update(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String slet(@PathVariable("id") long id, Model model)
    {

        //Should return the boolean value and send it to index

        try
        {
            model.addAttribute("test", productService.Delete(id));
            //Can not get this to index.html
            model.addAttribute("status", "Element " + id + " slettet");
        }
        catch (Exception e)
        {
            //Can not use redirect because I then loose the message
            model.addAttribute("status", "Element " + id + " kunne ikke slettes!");
            return "/index";
        }

        return "redirect:/";
    }


}
