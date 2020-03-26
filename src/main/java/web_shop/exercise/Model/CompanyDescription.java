package web_shop.exercise.Model;

import javax.persistence.*;

@Entity
public class CompanyDescription
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String descriptionCompany;

    //If we delete the Product object, the CompanyDescription will remain inside the database.
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public CompanyDescription()
    {
    }

    public CompanyDescription(long id, String descriptionCompany)
    {
        this.id = id;
        this.descriptionCompany = descriptionCompany;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescriptionCompany()
    {
        return descriptionCompany;
    }

    public void setDescriptionCompany(String description)
    {
        this.descriptionCompany = description;
    }

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }
}
