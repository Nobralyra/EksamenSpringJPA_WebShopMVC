package web_shop.exercise.Service.Category;

import org.springframework.stereotype.Service;
import web_shop.exercise.Domain.Category;
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
    public void save(Category category)
    {
        iCrudCategoryRepository.save(category);
    }

    /**
     * Why the if else look like this
     * https://dzone.com/articles/application-monitoring-with-spring-boot
     * @param id
     * @return Category
     */
    @Override
    public Category findById(Long id)
    {
        Optional<Category> categoryOptional = iCrudCategoryRepository.findById(id);
        return categoryOptional.orElse(null);
    }

    /**
     * For each that add all the elements from the database to a list
     * @return List<Category>
     */
    @Override
    public List<Category> findAll()
    {
        List<Category> categoryList = new ArrayList<>();
        iCrudCategoryRepository.findAll().forEach(categoryList::add);

        return categoryList;
    }

    @Override
    public void deleteByID(Long id)
    {
        iCrudCategoryRepository.deleteById(id);
    }

}
