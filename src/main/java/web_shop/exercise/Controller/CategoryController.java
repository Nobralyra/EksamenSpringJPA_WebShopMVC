package web_shop.exercise.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web_shop.exercise.Model.Category;
import web_shop.exercise.Model.Product;
import web_shop.exercise.Service.ICrudService;

import javax.validation.Valid;


@Controller
public class CategoryController
{
    private final ICrudService<Category, Long> iCategoryCrudService;
    private final ICrudService<Product, Long> iProductCrudService;

    public CategoryController(ICrudService<Category, Long> iCategoryCrudService, ICrudService<Product, Long> iProductCrudService)
    {
        this.iCategoryCrudService = iCategoryCrudService;
        this.iProductCrudService = iProductCrudService;
    }

    @GetMapping({"/categories"})
    public String CategoryPage(Model model)
    {
        model.addAttribute("category", iCategoryCrudService.FindAll());

        return ("/categories/index");
    }

    @GetMapping("/categories/create")
    public String Create(Category category, Model model)
    {
        model.addAttribute("category", category);
        return "/categories/create";
    }

    @PostMapping("/categories/create")
    public String CreateCompany(@ModelAttribute @Valid Category category, BindingResult resultCategory, Model model)
    {
        if(!resultCategory.hasErrors())
        {
            iCategoryCrudService.Save(category);
        }
        else
        {
            model.addAttribute("resultCategory", resultCategory);
            return "/categories/create";
        }

        return "redirect:/categories";
    }

    @GetMapping({"/categories/details/{id}"})
    public String Detail(@PathVariable("id") long id, Model model)
    {
        //add all products to view model from ICrudService
        model.addAttribute("category", iCategoryCrudService.FindById(id));
        model.addAttribute("product", iProductCrudService.FindAll());
        return ("/categories/details");
    }

    //use PathVariable to fetch id from list on web page
    @GetMapping("/categories/update/{id}")
    public String Update(@PathVariable("id") long id, Model model)
    {
        //add product with id to the model view
        model.addAttribute("category", iCategoryCrudService.FindById(id));
        model.addAttribute("product", iProductCrudService.FindAll());
        return "/categories/update";
    }

    //update product
    @PostMapping("/categories/update")
    public String Update(@ModelAttribute @Valid Category category, BindingResult resultCategory, Model model)
    {
        if(!resultCategory.hasErrors())
        {
            iCategoryCrudService.Save(category);
        }
        else
        {
            model.addAttribute("resultCategory", resultCategory);
            return "/categories/update";
        }

        return "redirect:/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String delete(@PathVariable("id") long id){
        iCategoryCrudService.DeleteByID(id);
        return "redirect:/categories";
    }

}
