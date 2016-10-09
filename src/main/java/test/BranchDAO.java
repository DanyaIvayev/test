package test;

import model.BranchEntity;

import java.util.List;

/**
 * Created by Дамир on 11.09.2016.
 */
public interface BranchDAO {
    List<BranchEntity> list();
    void add(BranchEntity branch);
    BranchEntity getBranchById(int id);
    void save(BranchEntity branch);
    void delete(int id);
}
