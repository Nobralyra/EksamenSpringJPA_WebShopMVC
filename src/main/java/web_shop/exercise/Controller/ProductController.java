package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Domain.Category;
import web_shop.exercise.Domain.Company;
import web_shop.exercise.Domain.CompanyDescription;
import web_shop.exercise.Domain.Product;
import web_shop.exercise.Service.ICrudService;

import javax.validation.Valid;

@Controller
public class ProductController
{
    private final ICrudService<Product, Long> iProductCrudService;
    private final ICrudService<Company, Long> iCompanyCrudService;
    private final ICrudService<CompanyDescription, Long> iCompanyDescriptionCrudService;
    private final ICrudService<Category, Long> iCategoryCrudService;
    
    
    public ProductController(ICrudService<Product, Long> iProductCrudService, ICrudService<Company, Long> iCompanyCrudService, ICrudService<CompanyDescription, Long> iCompanyDescriptionCrudService, ICrudService<Category, Long> iCategoryCrudService)
    {
        this.iProductCrudService = iProductCrudService;
        this.iCompanyCrudService = iCompanyCrudService;
        this.iCompanyDescriptionCrudService = iCompanyDescriptionCrudService;
        this.iCategoryCrudService = iCategoryCrudService;
    }

    @GetMapping({"", "/"})
    public String indexPage(Model model)
    {
        //add all products to model from ICrudService
        model.addAttribute("product", iProductCrudService.findAll());

        if(iCompanyCrudService.findAll().size() == 0)
        {
            return ("/companies/index");
        }
        return ("/products/index");
    }

    @GetMapping("/products/create")
    public String create(Product product, CompanyDescription companyDescription, Model model)
    {
        model.addAttribute("category", iCategoryCrudService.findAll());
        model.addAttribute("company", iCompanyCrudService.findAll());
        model.addAttribute("product", product);

        return "/products/create";
    }

    /**
     * For some reason I can validate on descriptionCompany.
     * Even when I try to do it after the Product is saved in the database.
     * It says the field is null and I also sometimes get an exception that tells it can convert a Long to a String
     * I do not get that...
     * @param product
     * @param resultProduct
     * @param companyDescription
     * @param resultCompanyDescription
     * @param model
     * @return String
     */
    @PostMapping("/products/create")
    public String createProduct(@Valid @ModelAttribute ("product") Product product, BindingResult resultProduct,
                                @Valid @ModelAttribute ("companyDescription") CompanyDescription companyDescription,
                                BindingResult resultCompanyDescription,
                                Model model)
    {
        if(!resultProduct.hasErrors())
        {
            iProductCrudService.save(product);
        }
        else
        {
            model.addAttribute("resultProduct", resultProduct);
            model.addAttribute("resultCompanyDescription", resultCompanyDescription);
            model.addAttribute("product", product);
            model.addAttribute("companyDescription", companyDescription);
            model.addAttribute("category", iCategoryCrudService.findAll());
            model.addAttribute("company", iCompanyCrudService.findAll());

            return "/products/create";
        }
        return "redirect:/";
    }

    @GetMapping({"/products/details/{id}"})
    public String detail(@PathVariable("id") long id, Model model)
    {
        //add all products to view model from ICrudService
        model.addAttribute("product", iProductCrudService.findById(id));
        model.addAttribute("category", iCategoryCrudService.findAll());

        return ("/products/details");
    }

    //use PathVariable to fetch id from list on web page
    @GetMapping("/products/update/{id}")
    public String update(@PathVariable("id") long id, Model model)
    {
        //add product with id to the model view
        model.addAttribute("product", iProductCrudService.findById(id));
        model.addAttribute("company", iCompanyCrudService.findById(id));
        model.addAttribute("category", iCategoryCrudService.findAll());

        return "/products/update";
    }

    //update product
    @PostMapping("/products/update")
    public String updateProduct(@ModelAttribute @Valid Product product, BindingResult resultProduct, Model model)
    {
        if(!resultProduct.hasErrors())
        {
            iProductCrudService.save(product);
        }
        else
        {
            model.addAttribute("resultProduct", resultProduct);
            model.addAttribute("category", iCategoryCrudService.findAll());

            return "/products/update";
        }
        return "redirect:/";
    }

    @GetMapping("/products/delete/{id}")
    public String delete(@PathVariable("id") long id)
    {
        iProductCrudService.deleteByID(id);

        return "redirect:/";
    }
}
