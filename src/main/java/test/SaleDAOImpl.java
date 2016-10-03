package test;

import model.SalesEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Дамир on 26.09.2016.
 */
public class SaleDAOImpl implements SaleDAO {

    @PersistenceContext
    EntityManager entityManager;

    public List<SalesEntity> list() {
        TypedQuery<SalesEntity> query =
                entityManager.createQuery("SELECT c FROM SalesEntity c", SalesEntity.class);
        List<SalesEntity> results = query.getResultList();
        for (SalesEntity e : results) {
            System.out.println(e.getBranch() + " => " + e.getBranch().getAddress());
            System.out.println(e.getMedicine()+ " => "+ e.getMedicine().getMedicinename());
        }
        return results;
    }

    @Transactional
    public void add(SalesEntity sale) {
        try{
            entityManager.persist(sale);
            entityManager.flush();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {

    }
}
