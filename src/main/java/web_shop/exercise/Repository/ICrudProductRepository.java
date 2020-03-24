package web_shop.exercise.Repository;

import org.springframework.data.repository.CrudRepository;
import web_shop.exercise.Model.Product;

public interface ICrudProductRepository extends CrudRepository<Product, Long>
{

}
