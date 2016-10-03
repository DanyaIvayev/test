package test;

import model.BranchEntity;
import model.BranchProviderEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Дамир on 26.09.2016.
 */
public class BranchProviderDAOImpl implements BranchProviderDAO {

    @PersistenceContext
    EntityManager entityManager;

    public List<BranchProviderEntity> list() {
        TypedQuery<BranchProviderEntity> query = entityManager.createQuery("SELECT c FROM BranchProviderEntity c", BranchProviderEntity.class);
        List<BranchProviderEntity> results = query.getResultList();
        for(BranchProviderEntity e : results){
            System.out.println(e.getBranch() + " => " + e.getBranch().getAddress());
            System.out.println(e.getProvider()+ " => "+ e.getProvider().getProvidername());
        }
        return results;
    }

    @Transactional
    public void add(BranchProviderEntity branchProvider) {
        try{
            entityManager.persist(branchProvider);
            entityManager.flush();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void delete(int id) {

    }
}
