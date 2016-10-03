package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Дамир on 15.09.2016.
 */
public class SalesEntityPK implements Serializable {
    private int idBranch;
    private int idMedicine;

    @Column(name = "id_branch")
    @Id
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    @Column(name = "id_medicine")
    @Id
    public int getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesEntityPK that = (SalesEntityPK) o;

        if (idBranch != that.idBranch) return false;
        if (idMedicine != that.idMedicine) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBranch;
        result = 31 * result + idMedicine;
        return result;
    }
}
