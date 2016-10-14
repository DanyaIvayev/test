package model;

import javax.persistence.*;

/**
 * Created by Дамир on 15.09.2016.
 */
@Entity
@Table(name = "sales", schema = "public", catalog = "pharmacy")
@IdClass(SalesEntityPK.class)
public class SalesEntity {
    private int idBranch;
    private int idMedicine;
    private int instock;
    private int sold;

    private BranchEntity branch;


    private MedicineEntity medicine;

    public SalesEntity() {
    }

    public SalesEntity(int instock, int sold, BranchEntity branch, MedicineEntity medicine) {
        this.instock = instock;
        this.sold = sold;
        this.branch = branch;
        this.medicine = medicine;
    }

    public SalesEntity(int idBranch, int idMedicine, int instock, int sold) {
        this.idBranch = idBranch;
        this.idMedicine = idMedicine;
        this.instock = instock;
        this.sold = sold;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_branch", referencedColumnName="id_branch")
  /* if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(name = "employeeId", updatable = false, insertable = false)
  * or @JoinColumn(name = "employeeId", updatable = false, insertable = false, referencedColumnName = "id")
  */
    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }
    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_medicine", referencedColumnName="id_medicine")
  /* the same goes here:
  *  if this JPA model doesn't create a table for the "PROJ_EMP" entity,
  *  please comment out the @PrimaryKeyJoinColumn, and use the ff:
  *  @JoinColumn(name = "projectId", updatable = false, insertable = false)
  * or @JoinColumn(name = "projectId", updatable = false, insertable = false, referencedColumnName = "id")
  */
    public MedicineEntity getMedicine() {
        return medicine;
    }

    public void setMedicine(MedicineEntity medicine) {
        this.medicine = medicine;
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
    @Column(name = "id_medicine")
    public int getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
    }

    @Basic
    @Column(name = "instock")
    public int getInstock() {
        return instock;
    }

    public void setInstock(int instock) {
        this.instock = instock;
    }

    @Basic
    @Column(name = "sold")
    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

   /* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesEntity that = (SalesEntity) o;

        if (idBranch != that.idBranch) return false;
        if (idMedicine != that.idMedicine) return false;
        if (instock != that.instock) return false;
        if (sold != that.sold) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBranch;
        result = 31 * result + idMedicine;
        result = 31 * result + instock;
        result = 31 * result + sold;
        return result;
    }*/
}
