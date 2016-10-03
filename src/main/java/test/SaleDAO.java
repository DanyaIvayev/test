package test;

import model.SalesEntity;

import java.util.List;

/**
 * Created by Дамир on 26.09.2016.
 */
public interface SaleDAO {
    List<SalesEntity> list();
    void add(SalesEntity sale);
    void delete(int id);
}
