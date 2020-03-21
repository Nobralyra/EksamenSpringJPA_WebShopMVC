package web_shop.exercise.Model;

public class CompanyDescription
{
    private long id;
    private String description;

    public CompanyDescription()
    {
    }

    public CompanyDescription(long id, String description)
    {
        this.id = id;
        this.description = description;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
