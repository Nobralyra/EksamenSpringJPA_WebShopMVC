package web_shop.exercise.Service;

import java.util.List;

public interface ICrudService <T, ID>
{
    void save(T entity);
    T findById(ID id);
    List<T> findAll();
    void deleteByID(ID id);
}
