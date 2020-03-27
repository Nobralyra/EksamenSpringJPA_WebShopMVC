package web_shop.exercise.Model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;
    private String categoryName;

    //On the joined table
    @ManyToMany(mappedBy = "categories")
    private Set<Product> products;

    public Category()
    {
    }

    public Category(long categoryId, String categoryName)
    {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
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

    public Set<Product> getProducts()
    {
        return products;
    }

    public void setProducts(Set<Product> products)
    {
        this.products = products;
    }
}
