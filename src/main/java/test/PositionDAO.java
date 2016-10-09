package test;

import model.PositionEntity;

import java.util.List;

/**
 * Created by Дамир on 23.09.2016.
 */
public interface PositionDAO {
    List<PositionEntity> list();
    void add(PositionEntity position);
    void delete(int id);
    void save(PositionEntity position);
    PositionEntity getPositionById(int id);
}
