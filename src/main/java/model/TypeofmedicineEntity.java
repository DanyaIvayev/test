package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Дамир on 28.09.2016.
 */
@Entity
@Table(name = "typeofmedicine", schema = "public", catalog = "pharmacy")
public class TypeofmedicineEntity {
    private int idType;
    private String typename;

    public TypeofmedicineEntity() {
    }

    public TypeofmedicineEntity(int idType, String typename) {
        this.idType = idType;
        this.typename = typename;
    }

    public TypeofmedicineEntity(String typename) {
        this.typename = typename;
    }

    List<MedicineEntity> medcines;

    @OneToMany(mappedBy = "type")
    public List<MedicineEntity> getMedcines() {
        return medcines;
    }

    public void setMedcines(List<MedicineEntity> medcines) {
        this.medcines = medcines;
    }

    @Id
    @Column(name = "id_type")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "typename")
    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeofmedicineEntity that = (TypeofmedicineEntity) o;

        if (idType != that.idType) return false;
        if (typename != null ? !typename.equals(that.typename) : that.typename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idType;
        result = 31 * result + (typename != null ? typename.hashCode() : 0);
        return result;
    }
}
