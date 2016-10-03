package model;

import javax.persistence.*;

/**
 * Created by Дамир on 15.09.2016.
 */
@Entity
@Table(name = "branch_provider", schema = "public", catalog = "pharmacy")
@IdClass(BranchProviderEntityPK.class)
public class BranchProviderEntity {
    private int idBranch;
    private int idProvider;
    private String dayOfBilevery;

    private BranchEntity branch;
    private ProviderEntity provider;

    public BranchProviderEntity() {
    }

    public BranchProviderEntity(String dayOfBilevery, BranchEntity branch, ProviderEntity provider) {
        this.dayOfBilevery = dayOfBilevery;
        this.branch = branch;
        this.provider = provider;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_branch", referencedColumnName="id_branch")
    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }
    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_provider", referencedColumnName="id_provider")
    public ProviderEntity getProvider() {
        return provider;
    }

    public void setProvider(ProviderEntity provider) {
        this.provider = provider;
    }

    @Id
    @Column(name = "id_branch")
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    @Id
    @Column(name = "id_provider")
    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    @Basic
    @Column(name = "dayOfBilevery")
    public String getDayOfBilevery() {
        return dayOfBilevery;
    }

    public void setDayOfBilevery(String dayOfBilevery) {
        this.dayOfBilevery = dayOfBilevery;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchProviderEntity that = (BranchProviderEntity) o;

        if (idBranch != that.idBranch) return false;
        if (idProvider != that.idProvider) return false;
        if (dayOfBilevery != null ? !dayOfBilevery.equals(that.dayOfBilevery) : that.dayOfBilevery != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBranch;
        result = 31 * result + idProvider;
        result = 31 * result + (dayOfBilevery != null ? dayOfBilevery.hashCode() : 0);
        return result;
    }
}
