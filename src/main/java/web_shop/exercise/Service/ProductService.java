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

    public List<Product> ReadAll()
    {
        List<Product> productList = new ArrayList<>();

        for (Product product: productRepository.ReadAll())
        {
            productList.add(product);
        }
        return productList;
    }

    public void Create(Product product)
    {
        productRepository.Create(product);
    }
}
