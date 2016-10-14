package test;

import model.TypeofmedicineEntity;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Дамир on 28.09.2016.
 */
public class TypeDAOImpl implements TypeDAO {
    @PersistenceContext
    EntityManager entityManager;
    public List<TypeofmedicineEntity> list() {
        Query q = entityManager.createQuery("SELECT b FROM TypeofmedicineEntity B");
        return (List<TypeofmedicineEntity>) q.getResultList();
    }

    @Transactional
    public void add(TypeofmedicineEntity type) {
        try{
            entityManager.persist(type);
            entityManager.flush();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Transactional
    public void save(TypeofmedicineEntity type){
        try {
            TypeofmedicineEntity old= getTypeById(type.getIdType());
            old.setTypename(type.getTypename());
            entityManager.merge(old);
            entityManager.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Transactional
    public void delete(int id) {
        try{
            TypeofmedicineEntity forDelete = getTypeById(id);
            entityManager.remove(forDelete);
            entityManager.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public TypeofmedicineEntity getTypeById(int id) {
        Query q = entityManager.createQuery("SELECT b FROM TypeofmedicineEntity b WHERE b.idType = :id");
        q.setParameter("id", id);
        TypeofmedicineEntity type = (TypeofmedicineEntity)q.getSingleResult();
        return type;
    }
}
