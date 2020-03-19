package web_shop.exercise.Repository;

import java.util.List;

public interface ICrudRepository <T>
{
    void Create(T t);
    T Read(long id);
    List<T> ReadAll();
    boolean Update(T t);
    boolean Delete(long id);
}
