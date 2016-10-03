package test;

import model.EmployerEntity;

import java.util.List;

/**
 * Created by Дамир on 24.09.2016.
 */
public interface EmployerDAO {
    List<EmployerEntity> list();
    void add(EmployerEntity employer);
    void delete(int id);
}
