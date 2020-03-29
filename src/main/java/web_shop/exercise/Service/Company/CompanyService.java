package web_shop.exercise.Service.Company;

import org.springframework.stereotype.Service;
import web_shop.exercise.Model.Company;
import web_shop.exercise.Repository.ICrudCompanyRepository;
import web_shop.exercise.Service.ICrudService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICrudService<Company, Long>
{
    private final ICrudCompanyRepository iCrudCompanyRepository;

    public CompanyService(ICrudCompanyRepository iCrudCompanyRepository)
    {
        this.iCrudCompanyRepository = iCrudCompanyRepository;
    }

    @Override
    public void Save(Company company)
    {
        iCrudCompanyRepository.save(company);
    }

    /**
     * Why the if else look like this
     * https://dzone.com/articles/application-monitoring-with-spring-boot
     * @param id
     * @return Company
     */
    @Override
    public Company FindById(Long id)
    {
        Optional<Company> companyOptional = iCrudCompanyRepository.findById(id);
        return companyOptional.orElse(null);
    }

    /**
     * For each that add all the elements from the database to a list
     * @return List<Company>
     */
    @Override
    public List<Company> FindAll()
    {
        List<Company> companyList = new ArrayList<>();
        iCrudCompanyRepository.findAll().forEach(companyList::add);

        return companyList;
    }


    @Override
    public void DeleteByID(Long id)
    {
        iCrudCompanyRepository.deleteById(id);

    }

}
