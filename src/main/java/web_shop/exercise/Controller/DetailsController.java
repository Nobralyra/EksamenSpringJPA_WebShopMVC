package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DetailsController
{
    /*
    Skal der laves interfaces til de andre service lag???
     */

    @GetMapping({"/details/{id}"})
    public String IndexPage(@PathVariable("id") long id, Model model)
    {
        //model.addAttribute("companyDetails", iProductService.GetProducts());
        return ("/details");
    }

}
