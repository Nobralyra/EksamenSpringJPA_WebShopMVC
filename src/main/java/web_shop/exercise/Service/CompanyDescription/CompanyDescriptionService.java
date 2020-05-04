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
    public void save(CompanyDescription companyDescription)
    {
        iCrudCompanyDescriptionRepository.save(companyDescription);
    }

    /**
     * Why the if else look like this
     * https://dzone.com/articles/application-monitoring-with-spring-boot
     * @param id
     * @return CompanyDescription
     */
    @Override
    public CompanyDescription findById(Long id)
    {
        Optional<CompanyDescription> companyDescriptionOptional = iCrudCompanyDescriptionRepository.findById(id);
        return companyDescriptionOptional.orElse(null);
    }

    /**
     * For each that add all the elements from the database to a list
     * @return List<CompanyDescription>
     */
    @Override
    public List<CompanyDescription> findAll()
    {
        List<CompanyDescription> companyDescriptionList = new ArrayList<>();
        iCrudCompanyDescriptionRepository.findAll().forEach(companyDescriptionList::add);

        return companyDescriptionList;
    }

    @Override
    public void deleteByID(Long id)
    {
        iCrudCompanyDescriptionRepository.deleteById(id);
    }
}
