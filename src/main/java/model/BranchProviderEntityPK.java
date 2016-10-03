package model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Дамир on 15.09.2016.
 */
public class BranchProviderEntityPK implements Serializable {
    private int idBranch;
    private int idProvider;

    @Column(name = "id_branch")
    @Id
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    @Column(name = "id_provider")
    @Id
    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchProviderEntityPK that = (BranchProviderEntityPK) o;

        if (idBranch != that.idBranch) return false;
        if (idProvider != that.idProvider) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBranch;
        result = 31 * result + idProvider;
        return result;
    }
}
