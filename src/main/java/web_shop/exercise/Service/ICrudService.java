package web_shop.exercise.Service;

public interface ICrudService <T, ID>
{
    T FindById(ID id);
}
