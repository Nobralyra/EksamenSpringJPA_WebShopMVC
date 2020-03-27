package web_shop.exercise.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyId;

    private String companyName;

    //mappedby is the tablename
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    protected List<Product> products;

    public Company()
    {
    }

    public Company(long companyId, String companyName, List<Product> products)
    {
        this.companyId = companyId;
        this.companyName = companyName;
        this.products = products;
    }

    public long getCompanyId()
    {
        return companyId;
    }

    public void setCompanyId(long companyId)
    {
        this.companyId = companyId;
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
