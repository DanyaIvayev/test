package test;

import model.BranchEntity;
import model.EmployerEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public EmployerEntity getEmployerById(int id) {
        Query q = entityManager.createQuery("SELECT b FROM EmployerEntity b WHERE b.idEmployer = :id");
        q.setParameter("id", id);
        EmployerEntity employer = (EmployerEntity)q.getSingleResult();
        return employer;
    }

    @Transactional
    public void save(EmployerEntity employer){
        try{
            EmployerEntity old = getEmployerById(employer.getIdEmployer());
            old.setFirstname(employer.getFirstname());
            old.setSecondname(employer.getSecondname());
            old.setPatronymic(employer.getPatronymic());
            old.setInn(employer.getInn());
            old.setSerialofpassport(employer.getSerialofpassport());
            old.setNumberofpassport(employer.getNumberofpassport());
            old.setPosition(employer.getPosition());
            old.setBranch(employer.getBranch());
            entityManager.merge(old);
            entityManager.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Transactional
    public void delete(int id) {
        try{
            EmployerEntity forDelete = getEmployerById(id);
            entityManager.remove(forDelete);
            entityManager.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
