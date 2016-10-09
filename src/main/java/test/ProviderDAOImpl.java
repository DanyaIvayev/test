package test;

import model.ProviderEntity;
import org.springframework.transaction.annotation.Transactional;
import test.ProviderDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Дамир on 22.09.2016.
 */
public class ProviderDAOImpl implements ProviderDAO {

    private EntityManager entityManager;
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<ProviderEntity> list() {
        Query q= entityManager.createQuery("SELECT b from ProviderEntity b");
        return (List<ProviderEntity>) q.getResultList();
    }

    @Transactional
    public void add(ProviderEntity provider) {
        try{
            entityManager.persist(provider);
            entityManager.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Transactional
    public void save(ProviderEntity provider) {
        try{
            ProviderEntity old = getProviderById(provider.getIdProvider());
            old.setProvidername(provider.getProvidername());
            old.setProviderphone(provider.getProviderphone());
            entityManager.merge(old);
            entityManager.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void delete(int id) {

    }

    public ProviderEntity getProviderById(int id) {
        Query q = entityManager.createQuery("SELECT b FROM ProviderEntity b WHERE b.idProvider = :id");
        q.setParameter("id", id);
        ProviderEntity provider = (ProviderEntity)q.getSingleResult();
        return provider;
    }


}
