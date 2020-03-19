package web_shop.exercise.Repository;

import org.springframework.stereotype.Repository;
import web_shop.exercise.Model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository
{
    //Collection for handling test data
    private List<Product> listOfProducts = new ArrayList<>();

    public ProductRepository()
    {
        //Fill in dummy data
        this.listOfProducts.add(new Product(1, "Kaffe", 45.0,"Lækker kaffe"));
        this.listOfProducts.add(new Product(2, "Te", 30,"Super te fra Kina"));
        this.listOfProducts.add(new Product(3, "Is", 22.0,"Kølig Magnum"));
        this.listOfProducts.add(new Product(4, "Lakridspipe", 5.0,"Skippers lakridspipe"));
        this.listOfProducts.add(new Product(5, "Bolcherne", 47.5,"Lækre bolcher fra Køge Nord"));
        this.listOfProducts.add(new Product(6, "Pepsi Max", 5.0,"Nul kaloier og god smag"));
    }

    public List<Product> ReadAll()
    {
        return listOfProducts;
    }

    //add new product to Product Collection
    public void Create(Product product)
    {
        listOfProducts.add(product);
    }
}
