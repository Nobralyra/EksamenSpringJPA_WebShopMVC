package web_shop.exercise.Service.CompanyDescription;

import org.springframework.stereotype.Service;
import web_shop.exercise.Model.CompanyDescription;
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
    public void Save(CompanyDescription companyDescription)
    {
        iCrudCompanyDescriptionRepository.save(companyDescription);
    }

    @Override
    public CompanyDescription FindById(Long id)
    {
        Optional<CompanyDescription> companyDescriptionOptional = iCrudCompanyDescriptionRepository.findById(id);
        return companyDescriptionOptional.orElse(null);
    }

    @Override
    public List<CompanyDescription> FindAll()
    {
        List<CompanyDescription> companyDescriptionList = new ArrayList<>();
        iCrudCompanyDescriptionRepository.findAll().forEach(companyDescriptionList::add);

        return companyDescriptionList;
    }


    @Override
    public void DeleteByID(Long id)
    {
        iCrudCompanyDescriptionRepository.deleteById(id);
    }

}
