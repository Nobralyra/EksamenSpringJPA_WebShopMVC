package web_shop.exercise.Repository;

import org.springframework.data.repository.CrudRepository;
import web_shop.exercise.Model.CompanyDescription;

public interface ICrudCompanyDescriptionRepository extends CrudRepository<CompanyDescription, Long>
{

}
