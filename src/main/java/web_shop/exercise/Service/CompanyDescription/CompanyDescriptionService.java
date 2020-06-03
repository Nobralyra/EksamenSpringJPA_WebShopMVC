package web_shop.exercise.Service.CompanyDescription;

import org.springframework.stereotype.Service;
import web_shop.exercise.Domain.CompanyDescription;
import web_shop.exercise.Repository.ICrudCompanyDescriptionRepository;
import web_shop.exercise.Service.ICrudService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyDescriptionService implements ICrudService<CompanyDescription, Long>
{
    private final ICrudCompanyDescriptionRepository iCrudCompanyDescriptionRepository;

    public CompanyDescriptionService(ICrudCompanyDescriptionRepository iCrudCompanyDescriptionRepository)
    {
        this.iCrudCompanyDescriptionRepository = iCrudCompanyDescriptionRepository;
    }

    @Override
    public void save(CompanyDescription companyDescription)
    {
        iCrudCompanyDescriptionRepository.save(companyDescription);
    }

    @Override
    public CompanyDescription findById(Long id)
    {
        Optional<CompanyDescription> companyDescriptionOptional = iCrudCompanyDescriptionRepository.findById(id);

        if (!companyDescriptionOptional.isPresent())
        {
            throw new RuntimeException("Product not found!");
        }

        return companyDescriptionOptional.get();
    }

    @Override
    public List<CompanyDescription> findAll()
    {
        List<CompanyDescription> companyDescriptionList = new ArrayList<>();
        for (CompanyDescription companyDescriptions: iCrudCompanyDescriptionRepository.findAll())
        {
            companyDescriptionList.add(companyDescriptions);
        }
        return companyDescriptionList;
    }

    @Override
    public void deleteByID(Long id)
    {
        iCrudCompanyDescriptionRepository.deleteById(id);
    }
}
