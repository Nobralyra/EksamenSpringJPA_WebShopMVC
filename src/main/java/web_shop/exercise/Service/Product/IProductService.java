package web_shop.exercise.Service.Product;

import web_shop.exercise.Model.Product;
import web_shop.exercise.Service.ICrudService;

import java.util.List;

public interface IProductService extends ICrudService<Product, Long>
{

    void Save(Product product);
    Product FindById(Long id);
    List<Product> GetProducts();
    void DeleteByID(Long id);

    /*
    void Save(T object);

    T FindById(ID id);

    List<T> GetProducts();

    void DeleteByID(ID id);

     */
}
