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

    @Override
    public Category findById(Long id)
    {
        Optional<Category> categoryOptional = iCrudCategoryRepository.findById(id);

        if (!categoryOptional.isPresent())
        {
            throw new RuntimeException("Product not found!");
        }

        return categoryOptional.get();
    }

    @Override
    public List<Category> findAll()
    {
        List<Category> categoryList = new ArrayList<>();

        for (Category categories: iCrudCategoryRepository.findAll())
        {
            categoryList.add(categories);
        }

        return categoryList;
    }

    @Override
    public void deleteByID(Long id)
    {
        iCrudCategoryRepository.deleteById(id);
    }
}
