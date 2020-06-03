package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Domain.CompanyDescription;
import web_shop.exercise.Service.ICrudService;

import javax.validation.Valid;

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
        model.addAttribute("companyDescription", iCrudService.findAll());
        return ("/company_descriptions/index");
    }

    /**
     * use PathVariable to fetch id from list on web page
     * add product with id to the model view
     *
     * Of some reason I can update the description of CompanyDescription
     * Gotten some different exception but the one I get now is the products validation that kicks in
     * @param id
     * @param model
     * @return String
     */
    @GetMapping("/company_descriptions/update/{id}")
    public String Update(@PathVariable("id") long id, Model model)
    {
        model.addAttribute("companyDescription", iCrudService.findById(id));
        return "/company_descriptions/update";
    }

    /**
     *  update CompanyDescription
     */
    @PostMapping("/company_descriptions/update")
    public String Update(@ModelAttribute @Valid CompanyDescription companyDescription, BindingResult resultCompanyDescription, Model model)
    {
        if(!resultCompanyDescription.hasErrors())
        {
            iCrudService.save(companyDescription);
        }
        else
        {
            model.addAttribute("resultCompanyDescription", resultCompanyDescription);

            return "/company_descriptions/update";
        }

        return "redirect:/company_descriptions";
    }

    @GetMapping("/company_descriptions/delete/{id}")
    public String Delete(@PathVariable("id") long id)
    {
        iCrudService.deleteByID(id);

        return "redirect:/company_descriptions";
    }
}
