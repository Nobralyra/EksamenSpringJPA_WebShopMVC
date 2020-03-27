package web_shop.exercise.Repository;

import org.springframework.data.repository.CrudRepository;
import web_shop.exercise.Model.Category;
import web_shop.exercise.Model.Company;

import java.util.Optional;

public interface ICrudCompanyRepository extends CrudRepository<Company, Long>
{

}
