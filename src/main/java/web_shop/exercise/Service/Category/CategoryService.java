package web_shop.exercise.Service.Category;

import web_shop.exercise.Model.Category;
import web_shop.exercise.Repository.ICrudCategoryRepository;
import web_shop.exercise.Service.ICrudService;

import java.util.Optional;

public class CategoryService implements ICrudService<Category, Long>
{
    private final ICrudCategoryRepository iCrudCategoryRepository;

    public CategoryService(ICrudCategoryRepository iCrudCategoryRepository)
    {
        this.iCrudCategoryRepository = iCrudCategoryRepository;
    }

    @Override
    public Category FindById(Long id)
    {
        Optional<Category> categoryOptional = iCrudCategoryRepository.findById(id);
        return categoryOptional.orElse(null);
    }
}
