package web_shop.exercise.Repository;

import org.springframework.data.repository.CrudRepository;
import web_shop.exercise.Domain.Company;

public interface ICrudCompanyRepository extends CrudRepository<Company, Long>
{

}
