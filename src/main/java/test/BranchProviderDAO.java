package test;

import model.BranchProviderEntity;

import java.util.List;

/**
 * Created by Дамир on 26.09.2016.
 */
public interface BranchProviderDAO {
    List<BranchProviderEntity> list();
    void add(BranchProviderEntity branchProvider);
    void delete(int id);
}
