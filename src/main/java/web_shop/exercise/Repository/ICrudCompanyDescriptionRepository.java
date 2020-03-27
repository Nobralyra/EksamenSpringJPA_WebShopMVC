package web_shop.exercise.Repository;

import org.springframework.data.repository.CrudRepository;
import web_shop.exercise.Model.Category;
import web_shop.exercise.Model.Company;
import web_shop.exercise.Model.CompanyDescription;

import java.util.Optional;

public interface ICrudCompanyDescriptionRepository extends CrudRepository<CompanyDescription, Long>
{

}
