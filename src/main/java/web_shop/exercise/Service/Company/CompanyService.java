package web_shop.exercise.Service.Company;

import org.springframework.stereotype.Service;
import web_shop.exercise.Domain.Company;
import web_shop.exercise.Domain.CompanyDescription;
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
    public void save(Company company)
    {
        iCrudCompanyRepository.save(company);
    }

    @Override
    public Company findById(Long id)
    {
        Optional<Company> companyOptional = iCrudCompanyRepository.findById(id);

        if (!companyOptional.isPresent())
        {
            throw new RuntimeException("Product not found!");
        }

        return companyOptional.get();
    }

    @Override
    public List<Company> findAll()
    {
        List<Company> companyList = new ArrayList<>();
        for (Company companies: iCrudCompanyRepository.findAll())
        {
            companyList.add(companies);
        }

        return companyList;
    }

    @Override
    public void deleteByID(Long id)
    {
        iCrudCompanyRepository.deleteById(id);
    }
}
