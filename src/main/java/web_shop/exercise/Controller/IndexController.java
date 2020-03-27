package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Model.Category;
import web_shop.exercise.Model.Company;
import web_shop.exercise.Model.CompanyDescription;
import web_shop.exercise.Model.Product;
import web_shop.exercise.Service.ICrudService;

import javax.validation.Valid;

@Controller
public class IndexController
{
    private final ICrudService<Product, Long> iProductCrudService;
    private final ICrudService<Company, Long> iCompanyCrudService;
    private final ICrudService<CompanyDescription, Long> iCompanyDescriptionCrudService;
    private final ICrudService<Category, Long> iCategoryCrudService;
    
    
    public IndexController(ICrudService<Product, Long> iProductCrudService, ICrudService<Company, Long> iCompanyCrudService, ICrudService<CompanyDescription, Long> iCompanyDescriptionCrudService, ICrudService<Category, Long> iCategoryCrudService)
    {
        this.iProductCrudService = iProductCrudService;
        this.iCompanyCrudService = iCompanyCrudService;
        this.iCompanyDescriptionCrudService = iCompanyDescriptionCrudService;
        this.iCategoryCrudService = iCategoryCrudService;
    }

    @GetMapping({"", "/"})
    public String IndexPage(Model model)
    {
        //add all products to view model from ICrudService
        model.addAttribute("product", iProductCrudService.FindAll());

        if(iCompanyCrudService.FindAll().size() == 0)
        {
            return ("/companies/index");
        }

        return ("/products/index");
    }

    @GetMapping("/products/create")
    public String Create(Product product, CompanyDescription companyDescription, Model model)
    {
        model.addAttribute("category", iCategoryCrudService.FindAll());
        model.addAttribute("company", iCompanyCrudService.FindAll());
        model.addAttribute("product", product);

        return "/products/create";
    }

    @PostMapping("/products/create")
    public String CreateProduct(@ModelAttribute @Valid Product product, BindingResult resultProduct,
                                @ModelAttribute @Valid CompanyDescription companyDescription,
                                BindingResult resultCompanyDescription,
                                Model model)
    {
        if(!resultProduct.hasErrors())
        {
            iProductCrudService.Save(product);
        }
        else
        {
            model.addAttribute("resultProduct", resultProduct);
            model.addAttribute("resultCompanyDescription", resultCompanyDescription);


            model.addAttribute("category", iCategoryCrudService.FindAll());
            model.addAttribute("company", iCompanyCrudService.FindAll());

            return "/products/create";
        }


        return "redirect:/";
    }

    @GetMapping({"/products/details/{id}"})
    public String Detail(@PathVariable("id") long id, Model model)
    {
        //add all products to view model from ICrudService
        model.addAttribute("product", iProductCrudService.FindById(id));
        model.addAttribute("category", iCategoryCrudService.FindAll());

        return ("/products/details");
    }

    //use PathVariable to fetch id from list on web page
    @GetMapping("/products/update/{id}")
    public String Update(@PathVariable("id") long id, Model model)
    {
        //add product with id to the model view
        model.addAttribute("product", iProductCrudService.FindById(id));
        model.addAttribute("company", iCompanyCrudService.FindById(id));
        model.addAttribute("category", iCategoryCrudService.FindAll());

        return "/products/update";
    }

    //update product
    @PostMapping("/products/update")
    public String Update(@ModelAttribute @Valid Product product, BindingResult resultProduct, Model model)
    {
        if(!resultProduct.hasErrors())
        {
            iProductCrudService.Save(product);
        }
        else
        {
            model.addAttribute("resultProduct", resultProduct);

            model.addAttribute("category", iCategoryCrudService.FindAll());

            return "/products/update";
        }

        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String Delete(@PathVariable("id") long id)
    {
        iProductCrudService.DeleteByID(id);

        return "redirect:/";
    }
}
