package web_shop.exercise.Service.Category;

import org.springframework.stereotype.Service;
import web_shop.exercise.Model.Category;
import web_shop.exercise.Repository.ICrudCategoryRepository;
import web_shop.exercise.Service.ICrudService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICrudService<Category, Long>
{
    private final ICrudCategoryRepository iCrudCategoryRepository;

    public CategoryService(ICrudCategoryRepository iCrudCategoryRepository)
    {
        this.iCrudCategoryRepository = iCrudCategoryRepository;
    }


    @Override
    public void Save(Category category)
    {
        iCrudCategoryRepository.save(category);
    }

    @Override
    public Category FindById(Long id)
    {
        Optional<Category> categoryOptional = iCrudCategoryRepository.findById(id);
        return categoryOptional.orElse(null);
    }

    @Override
    public List<Category> FindAll()
    {
        List<Category> categoryList = new ArrayList<>();
        iCrudCategoryRepository.findAll().forEach(categoryList::add);

        return categoryList;
    }

    @Override
    public void DeleteByID(Long id)
    {
        iCrudCategoryRepository.deleteById(id);

    }

}
