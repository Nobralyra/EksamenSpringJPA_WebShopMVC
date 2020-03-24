package web_shop.exercise.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String companyName;

    //mappedby is the tablename
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    protected List<Product> products;

    public Company()
    {
    }

    public Company(String companyName)
    {
        this.companyName = companyName;
    }

    public Company(long id, String companyName)
    {
        this.id = id;
        this.companyName = companyName;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String name)
    {
        this.companyName = name;
    }

    public List<Product> getProducts()
    {
        return products;
    }

    public void setProducts(List<Product> products)
    {
        this.products = products;
    }
}
