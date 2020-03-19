package web_shop.exercise.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web_shop.exercise.Model.Product;
import web_shop.exercise.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRepository productRepository;

    public void Create(Product product)
    {
        productRepository.Create(product);
    }

    public Product Read(long id)
    {
        return productRepository.Read(id);
    }

    public List<Product> ReadAll()
    {
        List<Product> productList = new ArrayList<>();

        for (Product product: productRepository.ReadAll())
        {
            productList.add(product);
        }
        return productList;
    }

    public boolean Update(Product product)
    {
        boolean updateOk = false;
        updateOk = productRepository.Update(product);
        return updateOk;
    }

    public boolean Delete(long id)
    {

        return productRepository.Delete(id);
    }
}
