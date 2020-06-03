package web_shop.exercise.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @NotBlank(message = "Please insert category name")
    @Size(min = 1, max = 35)
    private String categoryName;

    /**
     * On the joined table
     * If you try to delete a category and it has relation with one or more products, it will cause an exception
     * Cannot delete or update a parent row: a foreign key constraint fails (`database_web_shop`.`product_category`,
     * CONSTRAINT `FKkud35ls1d40wpjb5htpp14q4e` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`))
     */
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    private List<Product> products = new ArrayList<>();

    public Category()
    {
    }

    public Category(long categoryId, String categoryName, List<Product> products)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.products = products;
    }

    public long getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(long id)
    {
        this.categoryId = id;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String name)
    {
        this.categoryName = name;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }

    @Override
    public String toString()
    {
        return categoryName;
    }
}
