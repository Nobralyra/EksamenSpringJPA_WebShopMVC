package web_shop.exercise.Service.Product;

import org.springframework.stereotype.Service;
import web_shop.exercise.Model.Product;

import web_shop.exercise.Repository.ICrudProductRepository;
import web_shop.exercise.Service.ICrudService;

import java.util.ArrayList;
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
    public void save(Product product)
    {
        iCrudProductRepository.save(product);
    }

    /**
     * Why the if else look like this
     * https://dzone.com/articles/application-monitoring-with-spring-boot
     * @param id
     * @return Product
     */
    @Override
    public Product findById(Long id)
    {
        Optional<Product> productOptional = iCrudProductRepository.findById(id);
        return productOptional.orElse(null);
    }

    /**
     * For each that add all the elements from the database to a list
     * @return List<Product>
     */
    @Override
    public List<Product> findAll()
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
    public void deleteByID(Long id)
    {
        iCrudProductRepository.deleteById(id);
    }
}
