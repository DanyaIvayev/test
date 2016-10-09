package test;

import model.EmployerEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * Created by Дамир on 24.09.2016.
 */
public class EmployerDAOImpl implements EmployerDAO{

    @PersistenceContext
    private EntityManager entityManager;

    public List<EmployerEntity> list() {
        TypedQuery<EmployerEntity> query =
                entityManager.createQuery("SELECT c FROM EmployerEntity c", EmployerEntity.class);
        List<EmployerEntity> results = query.getResultList();
        for (EmployerEntity e : results) {
            System.out.println(e.getBranch() + " => " + e.getBranch().getAddress());
            System.out.println(e.getPosition()+ " => "+ e.getPosition().getPositionname());
        }
        return results;
    }

    @Transactional
    public void add(EmployerEntity employer) {
        try{
            entityManager.persist(employer);
            entityManager.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //@Transactional
   // public void save()

    public void delete(int id) {

    }
}
