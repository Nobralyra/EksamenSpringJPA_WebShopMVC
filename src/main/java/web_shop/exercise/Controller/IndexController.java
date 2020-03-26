package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Model.Company;
import web_shop.exercise.Model.CompanyDescription;
import web_shop.exercise.Model.Product;
import web_shop.exercise.Service.ICrudService;

@Controller
public class IndexController
{
    private final ICrudService<Product, Long> iProductCrudService;
    private final ICrudService<Company, Long> iCompanyCrudService;
    private final ICrudService<CompanyDescription, Long> iCompanyDescriptionCrudService;
    
    
    public IndexController(ICrudService<Product, Long> iProductCrudService, ICrudService<Company, Long> iCompanyCrudService, ICrudService<CompanyDescription, Long> iCompanyDescriptionCrudService)
    {
        this.iProductCrudService = iProductCrudService;
        this.iCompanyCrudService = iCompanyCrudService;
        this.iCompanyDescriptionCrudService = iCompanyDescriptionCrudService;
    }

    @GetMapping({"", "/"})
    public String IndexPage(Model model)
    {
        //add all products to view model from ICrudService
        model.addAttribute("product", iProductCrudService.FindAll());
        return ("/products/index");
    }

    @GetMapping("/products/create")
    public String Create(Product product, Model model)
    {
        model.addAttribute("company", iCompanyCrudService.FindAll());
        model.addAttribute("product", product);
        return "/products/create";
    }

    @PostMapping("/products/create")
    public String CreateProduct(@ModelAttribute Product product)
    {
        iProductCrudService.Save(product);
        return "redirect:/";
    }

    @GetMapping({"/products/details/{id}"})
    public String Detail(@PathVariable("id") long id, Model model)
    {
        //add all products to view model from ICrudService
        model.addAttribute("product", iProductCrudService.FindById(id));
        return ("/products/details");
    }

    //use PathVariable to fetch id from list on web page
    @GetMapping("/products/update/{id}")
    public String Update(@PathVariable("id") long id, Model model)
    {
        //add product with id to the model view
        model.addAttribute("companyDescription", iCompanyDescriptionCrudService.FindAll());
        model.addAttribute("company", iCompanyCrudService.FindAll());
        model.addAttribute("product", iProductCrudService.FindById(id));
        return "/products/update";
    }

    //update product
    @PostMapping("/products/update")
    public String Update(@ModelAttribute Product product)
    {
        iProductCrudService.Save(product);
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String Delete(@PathVariable("id") long id)
    {
        iProductCrudService.DeleteByID(id);
                /*
        //Should return the boolean value and send it to index
        try
        {
            model.addAttribute("test", );
            //Can not get this to index.html
            model.addAttribute("status", "Element " + id + " slettet");
        }
        catch (Exception e)
        {
            //Can not use redirect because I then loose the message
            model.addAttribute("status", "Element " + id + " kunne ikke slettes!");
            return "/index";
        }

                 */

        return "redirect:/";
    }


}
