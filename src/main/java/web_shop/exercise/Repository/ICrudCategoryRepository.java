package web_shop.exercise.Repository;

import org.springframework.data.repository.CrudRepository;
import web_shop.exercise.Model.Category;

public interface ICrudCategoryRepository extends CrudRepository<Category, Long>
{

}
