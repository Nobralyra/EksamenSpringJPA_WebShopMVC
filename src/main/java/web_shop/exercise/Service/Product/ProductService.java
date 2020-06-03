package web_shop.exercise.Service.Product;

import org.springframework.stereotype.Service;
import web_shop.exercise.Domain.Product;

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

    @Override
    public Product findById(Long id)
    {
        Optional<Product> productOptional = iCrudProductRepository.findById(id);

        if (!productOptional.isPresent())
        {
            throw new RuntimeException("Product not found!");
        }

        return productOptional.get();
    }

    @Override
    public List<Product> findAll()
    {
        List<Product> productList = new ArrayList<>();

        for (Product products: iCrudProductRepository.findAll())
        {
            productList.add(products);
        }
        return productList;
    }

    @Override
    public void deleteByID(Long id)
    {
        iCrudProductRepository.deleteById(id);
    }
}
