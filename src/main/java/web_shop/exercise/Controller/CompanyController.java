package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Model.Company;
import web_shop.exercise.Service.ICrudService;

import javax.validation.Valid;

@Controller
public class CompanyController
{
    private final ICrudService<Company, Long> iCrudService;

    public CompanyController(ICrudService<Company, Long> iCrudService)
    {
        this.iCrudService = iCrudService;
    }

    @GetMapping({"/companies"})
    public String CompanyPage(Model model)
    {
        model.addAttribute("company", iCrudService.findAll());
        return ("/companies/index");
    }

    @GetMapping("/companies/create")
    public String Create(Company company, Model model)
    {
        model.addAttribute("company", company);
        return "/companies/create";
    }

    @PostMapping("/companies/create")
    public String CreateCompany(@ModelAttribute @Valid Company company, BindingResult resultCompany, Model model)
    {
        if(!resultCompany.hasErrors())
        {
            iCrudService.save(company);
        }
        else
        {
            model.addAttribute("resultCompany", resultCompany);
            return "/companies/create";
        }
        return "redirect:/companies";
    }

    //use PathVariable to fetch id from list on web page
    @GetMapping("/companies/update/{id}")
    public String Update(@PathVariable("id") long id, Model model)
    {
        //add product with id to the model view
        model.addAttribute("company", iCrudService.findById(id));
        return "/companies/update";
    }

    //update product
    @PostMapping("/companies/update")
    public String Update(@ModelAttribute @Valid Company company, BindingResult resultCompany, Model model)
    {
        if(!resultCompany.hasErrors())
        {
            iCrudService.save(company);
        }
        else
        {
            model.addAttribute("resultCompany", resultCompany);
            return "/companies/update";
        }
        return "redirect:/companies";
    }

    @GetMapping("/companies/delete/{id}")
    public String Delete(@PathVariable("id") long id)
    {
        iCrudService.deleteByID(id);

        return "redirect:/companies";
    }
}
