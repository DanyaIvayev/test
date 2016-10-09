package test;

import model.PositionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Дамир on 23.09.2016.
 */
public class PositionDAOImpl implements PositionDAO {

    @PersistenceContext
    private EntityManager entityManager;


    public List<PositionEntity> list() {
        Query q = entityManager.createQuery("SELECT b from PositionEntity b");
        return (List<PositionEntity>) q.getResultList();
    }

    @Transactional
    public void add(PositionEntity position) {
        try{
            entityManager.persist(position);
            entityManager.flush();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void save(PositionEntity position) {
        try{
            PositionEntity old = getPositionById(position.getIdPosition());
            old.setPositionname(position.getPositionname());
            old.setSalary(position.getSalary());
            entityManager.merge(old);
            entityManager.flush();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void delete(int id) {

    }

    public PositionEntity getPositionById(int id){
        Query q = entityManager.createQuery("SELECT b from PositionEntity b WHERE b.idPosition=:id");
        q.setParameter("id", id);
        PositionEntity position = (PositionEntity) q.getSingleResult();
        return position;
    }
}
