package test;

import model.ProviderEntity;

import java.util.List;

/**
 * Created by Дамир on 22.09.2016.
 */
public interface ProviderDAO {
    List<ProviderEntity> list();
    void add(ProviderEntity provider);
    void delete(int id);
    ProviderEntity getProviderById(int id);
    void save (ProviderEntity provider);
}
