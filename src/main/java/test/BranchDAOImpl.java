package test;

import model.BranchEntity;
import model.BranchProviderEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Дамир on 11.09.2016.
 */
public class BranchDAOImpl implements BranchDAO{

    //@PersistenceContext(unitName = "persistenceUnit", type = PersistenceContextType.EXTENDED)

    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


//    @Override
    public List<BranchEntity>list() {
        BranchEntity b = new BranchEntity();
        Query q = entityManager.createQuery("SELECT b FROM BranchEntity b");
        return (List<BranchEntity>) q.getResultList();
    }

    @Transactional
    public void add(BranchEntity branch) {
        try{
            //EntityManager em = getEntityManager();
            //em.getTransaction().begin();
            entityManager.persist(branch);
            entityManager.flush();
            //em.getTransaction().commit();
        } catch (Exception ex) {
            entityManager.getTransaction().rollback();
            ex.printStackTrace();
        }
    }
    @Transactional
    public void save(BranchEntity branch){
        try {
            BranchEntity old= getBranchById(branch.getIdBranch());
            old.setAddress(branch.getAddress());
            old.setPhone(branch.getPhone());
            entityManager.merge(old);
            entityManager.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void delete(int id) {
        try{
            BranchEntity forDelete = getBranchById(id);
            entityManager.remove(forDelete);
            entityManager.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public BranchEntity getBranchById(int id){
        Query q = entityManager.createQuery("SELECT b FROM BranchEntity b WHERE b.idBranch = :id");
        q.setParameter("id", id);
        BranchEntity branch = (BranchEntity)q.getSingleResult();
        return branch;
    }
}
