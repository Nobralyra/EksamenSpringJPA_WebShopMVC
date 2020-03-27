package web_shop.exercise.Model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class CompanyDescription
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long companyDescriptionId;

    @NotBlank(message = "Please insert description from company")
    private String descriptionCompany;

    //If we delete the Product object, the CompanyDescription will remain inside the database.
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    private Product product;

    public CompanyDescription()
    {
    }

    public CompanyDescription(long companyDescriptionId, String descriptionCompany, Product product)
    {
        this.companyDescriptionId = companyDescriptionId;
        this.descriptionCompany = descriptionCompany;
        this.product = product;

    }

    public long getCompanyDescriptionId()
    {
        return companyDescriptionId;
    }

    public void setCompanyDescriptionId(long companyDescriptionId)
    {
        this.companyDescriptionId = companyDescriptionId;
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
