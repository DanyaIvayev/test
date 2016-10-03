package test;

import model.MedicineEntity;

import java.util.List;

/**
 * Created by Дамир on 25.09.2016.
 */
public interface MedicineDAO {
    List<MedicineEntity> list();
    void add(MedicineEntity medicine);
    void delete(int id);
    MedicineEntity getMedicineById(int id);
}
