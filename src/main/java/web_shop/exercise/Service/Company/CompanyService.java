package web_shop.exercise.Service.Company;

import web_shop.exercise.Model.Company;
import web_shop.exercise.Repository.ICrudCompanyRepository;
import web_shop.exercise.Service.ICrudService;

import java.util.Optional;

public class CompanyService implements ICrudService<Company, Long>
{
    private final ICrudCompanyRepository iCrudCompanyRepository;

    public CompanyService(ICrudCompanyRepository iCrudCompanyRepository)
    {
        this.iCrudCompanyRepository = iCrudCompanyRepository;
    }

    @Override
    public Company FindById(Long id)
    {
        Optional<Company> companyOptional = iCrudCompanyRepository.findById(id);
        return companyOptional.orElseThrow(IllegalStateException::new);
    }

    public void Create(Company company)
    {
        iCrudCompanyRepository.save(company);
    }
}
