package web_shop.exercise.Service.Product;

import org.springframework.stereotype.Service;
import web_shop.exercise.Model.CompanyDescription;
import web_shop.exercise.Model.Product;

import web_shop.exercise.Repository.ICrudProductRepository;
import web_shop.exercise.Service.ICrudService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements ICrudService<Product, Long>
{
    private final ICrudProductRepository iCrudProductRepository;

    public ProductService(ICrudProductRepository iCrudProductRepository)
    {
        this.iCrudProductRepository = iCrudProductRepository;
    }


    @Override
    public void Save(Product product)
    {
        iCrudProductRepository.save(product);
    }

    @Override
    public Product FindById(Long id)
    {
        Optional<Product> productOptional = iCrudProductRepository.findById(id);
        return productOptional.orElse(null);
    }


    @Override
    public List<Product> FindAll()
    {
        List<Product> productList = new ArrayList<>();

        /*
        for (Product product: iCrudProductRepository.findAll())
        {
            productList.add(product);
        }
         */
        //Instead you can do
        iCrudProductRepository.findAll().forEach(productList::add);

        return productList;
    }


    @Override
    public void DeleteByID(Long id)
    {
        iCrudProductRepository.deleteById(id);
    }

}
