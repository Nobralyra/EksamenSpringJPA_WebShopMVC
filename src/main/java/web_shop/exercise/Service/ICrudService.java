package web_shop.exercise.Service;

import web_shop.exercise.Model.Product;

import java.util.List;

public interface ICrudService <T, ID>
{
    void Save(T entity);
    T FindById(ID id);
    List<T> FindAll();
    void DeleteByID(ID id);

}
