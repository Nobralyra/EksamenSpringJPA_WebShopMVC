package web_shop.exercise.Service.CompanyDescription;

import web_shop.exercise.Model.CompanyDescription;
import web_shop.exercise.Repository.ICrudCompanyDescriptionRepository;
import web_shop.exercise.Service.ICrudService;

import java.util.Optional;

public class CompanyDescriptionService implements ICrudService<CompanyDescription, Long>
{
    private final ICrudCompanyDescriptionRepository iCrudCompanyDescriptionRepository;

    public CompanyDescriptionService(ICrudCompanyDescriptionRepository iCrudCompanyDescriptionRepository)
    {
        this.iCrudCompanyDescriptionRepository = iCrudCompanyDescriptionRepository;
    }


    @Override
    public CompanyDescription FindById(Long id)
    {
        Optional<CompanyDescription> companyDescriptionOptional = iCrudCompanyDescriptionRepository.findById(id);
        return companyDescriptionOptional.orElse(null);
    }

}
