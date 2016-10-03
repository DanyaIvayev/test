package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Дамир on 15.09.2016.
 */
@Entity(name = "BranchEntity")
@Table(name = "branch", schema = "public", catalog = "pharmacy")
public class BranchEntity {
    private int idBranch;
    private String address;
    private Integer phone;


    private List<SalesEntity> sales;
    private List<EmployerEntity> employers;
    private List<BranchProviderEntity> providers;
    private List<MedicineEntity> medicines;
    public BranchEntity() {
    }

    public BranchEntity(String address, Integer phone) {
        this.address = address;
        this.phone = phone;
    }

    @OneToMany(mappedBy="branch")
    public List<SalesEntity> getSales() {
        return sales;
    }

    public void setSales(List<SalesEntity> sales) {
        this.sales = sales;
    }

    @OneToMany (mappedBy="branch")
    public List<EmployerEntity> getEmployers() {
        return employers;
    }

    public void setEmployers(List<EmployerEntity> employers) {
        this.employers = employers;
    }

    @OneToMany (mappedBy="branch")
    public List<BranchProviderEntity> getProviders() {
        return providers;
    }

    public void setProviders(List<BranchProviderEntity> providers) {
        this.providers = providers;
    }


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_branch")
    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone")
    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

}
