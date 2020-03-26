package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Model.CompanyDescription;
import web_shop.exercise.Service.ICrudService;

@Controller
public class CompanyDescriptionController
{
    private final ICrudService<CompanyDescription, Long> iCrudService;

    public CompanyDescriptionController(ICrudService<CompanyDescription, Long> iCrudService)
    {
        this.iCrudService = iCrudService;
    }

    @GetMapping({"/company_descriptions"})
    public String CompanyDescriptionPage(Model model)
    {
        model.addAttribute("companyDescription", iCrudService.FindAll());
        return ("/company_descriptions/index");
    }

    @GetMapping("/company_descriptions/create")
    public String Create(CompanyDescription companyDescription, Model model)
    {
        model.addAttribute("companyDescription", companyDescription);
        return "/company_descriptions/create";
    }

    @PostMapping("/company_descriptions/create")
    public String CreateCompanyDescription(@ModelAttribute CompanyDescription companyDescription, Model model)
    {
        iCrudService.Save(companyDescription);
        return "redirect:/company_descriptions";
    }

    //use PathVariable to fetch id from list on web page
    @GetMapping("/company_descriptions/update/{id}")
    public String Update(@PathVariable("id") long id, Model model)
    {
        //add product with id to the model view
        model.addAttribute("companyDescription", iCrudService.FindById(id));
        return "/company_descriptions/update";
    }

    //update product
    @PostMapping("/company_descriptions/update")
    public String Update(@ModelAttribute CompanyDescription companyDescription)
    {
        iCrudService.Save(companyDescription);
        return "redirect:/company_descriptions";
    }

    @GetMapping("/company_descriptions/delete/{id}")
    public String Delete(@PathVariable("id") long id)
    {
        iCrudService.DeleteByID(id);

        return "redirect:/company_descriptions";
    }
}
