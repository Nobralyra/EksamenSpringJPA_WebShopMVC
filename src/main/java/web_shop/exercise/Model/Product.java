package web_shop.exercise.Model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    @NotBlank(message = "Please insert name of product")
    private String productName;

    @NotNull
    @Min(0)
    private double price;


    @NotBlank(message = "Please insert description of product")
    @Length(max=1000)
    private String productDescription;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "product_category", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    protected List<Category> categories = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, optional=false)
    @JoinColumn(name="company_id", nullable = false)
    protected Company company;

    //Product is the owner of CompanyDescription
    //If we delete a Product that is going to persist down and delete CompanyDescription.
    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "product")
    protected CompanyDescription companyDescription;

    public Product()
    {}

    public Product(long productId, String productName, double price, String productDescription, List<Category> categories, Company company, CompanyDescription companyDescription)
    {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.productDescription = productDescription;
        this.categories = categories;
        this.company = company;
        this.companyDescription = companyDescription;
    }

    public long getProductId()
    {
        return productId;
    }

    public void setProductId(long productId)
    {
        this.productId = productId;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String name)
    {
        this.productName = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getProductDescription()
    {
        return productDescription;
    }

    public void setProductDescription(String description)
    {
        this.productDescription = description;
    }

    public List<Category> getCategories()
    {
        return categories;
    }

    public void setCategories(List<Category> categories)
    {
        this.categories = categories;
    }

    public Company getCompany()
    {
        return company;
    }

    public void setCompany(Company company)
    {
        this.company = company;
    }

    public CompanyDescription getCompanyDescription()
    {
        return companyDescription;
    }

    public void setCompanyDescription(CompanyDescription companyDescription)
    {
        this.companyDescription = companyDescription;
        this.companyDescription.setProduct(this);
    }

    @Override
    public String toString()
    {
        return productName;
    }
}
