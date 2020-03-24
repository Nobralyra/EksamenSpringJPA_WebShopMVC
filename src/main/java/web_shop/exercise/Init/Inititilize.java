package web_shop.exercise.Init;

import web_shop.exercise.Model.*;
import web_shop.exercise.Repository.ICrudCategoryRepository;
import web_shop.exercise.Repository.ICrudCompanyDescriptionRepository;
import web_shop.exercise.Repository.ICrudCompanyRepository;
import web_shop.exercise.Repository.ICrudProductRepository;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class Inititilize implements ApplicationListener<ContextRefreshedEvent>
{
    private final ICrudCategoryRepository iCrudCategoryRepository;
    private final ICrudProductRepository iCrudProductRepository;
    private final ICrudCompanyRepository iCrudCompanyRepository;
    private final ICrudCompanyDescriptionRepository iCrudCompanyDescriptionRepository;

    public Inititilize(ICrudCategoryRepository iCrudCategoryRepository, ICrudProductRepository iCrudProductRepository,
                       ICrudCompanyRepository iCrudCompanyRepository,
                       ICrudCompanyDescriptionRepository iCrudCompanyDescriptionRepository)
    {
        this.iCrudCategoryRepository = iCrudCategoryRepository;
        this.iCrudProductRepository = iCrudProductRepository;
        this.iCrudCompanyRepository = iCrudCompanyRepository;
        this.iCrudCompanyDescriptionRepository = iCrudCompanyDescriptionRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
    {
        iCrudProductRepository.saveAll(getProduct());
    }

    private List<Product> getProduct()
    {
        List<Product> productList = new ArrayList<>();

        Optional<Category> fantasyCategoryOptional = iCrudCategoryRepository.findByCategoryName("Fantasy");


        Category fantasyCategory = fantasyCategoryOptional.orElse(null);


        Product bookProduct = new Product();
        bookProduct.setProductName("Elverne kommer");
        bookProduct.setPrice(1.5);
        bookProduct.setProductDescription("Bog om elvere fra skoven");

        bookProduct.getCategories().add(fantasyCategory);

        Company bookCompany = new Company();
        bookCompany.setCompanyName("Gyldendal");
        bookProduct.setCompany(bookCompany);

        CompanyDescription bookCompanyDescription = new CompanyDescription();
        bookCompanyDescription.setDescriptionCompany("Eventyrlige fortaellinger");
        bookProduct.setCompanyDescription(bookCompanyDescription);

        productList.add(bookProduct);
        return productList;
    }
}
