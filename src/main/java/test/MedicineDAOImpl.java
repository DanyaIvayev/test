package test;

import model.MedicineEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Дамир on 25.09.2016.
 */
public class MedicineDAOImpl implements MedicineDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public List<MedicineEntity> list() {
        TypedQuery<MedicineEntity> query = entityManager.createQuery("SELECT b from MedicineEntity b", MedicineEntity.class);
        List<MedicineEntity> results = query.getResultList();
        for (MedicineEntity e : results) {
            System.out.println(e.getType() + " => " + e.getType().getTypename());
        }
        return results;
    }

    @Transactional
    public void add(MedicineEntity medicine) {
        try{
            entityManager.persist(medicine);
            entityManager.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Transactional
    public void save(MedicineEntity medicine) {
        try{
            MedicineEntity old = getMedicineById(medicine.getIdMedicine());
            old.setCountry(medicine.getCountry());
            old.setMedicinename(medicine.getMedicinename());
            old.setPrice(medicine.getPrice());
            old.setType(medicine.getType());
            entityManager.merge(old);
            entityManager.flush();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }



    @Transactional
    public void delete(int id) {
        try{
           MedicineEntity forDelete = getMedicineById(id);
            entityManager.remove(forDelete);
            entityManager.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public MedicineEntity getMedicineById(int id) {
        Query q = entityManager.createQuery("SELECT b FROM MedicineEntity b WHERE b.idMedicine = :id");
        q.setParameter("id", id);
        MedicineEntity medicine = (MedicineEntity)q.getSingleResult();
        return medicine;
    }


}
