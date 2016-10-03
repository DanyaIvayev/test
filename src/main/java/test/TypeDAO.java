package test;

import model.TypeofmedicineEntity;

import java.util.List;

/**
 * Created by Дамир on 28.09.2016.
 */
public interface TypeDAO {
    List<TypeofmedicineEntity> list();
    void add(TypeofmedicineEntity type);
    void delete(int id);
    TypeofmedicineEntity getTypeById(int id);
}
