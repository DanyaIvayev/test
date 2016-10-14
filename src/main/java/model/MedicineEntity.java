package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Дамир on 15.09.2016.
 */
@Entity
@Table(name = "medicine", schema = "public", catalog = "pharmacy")
public class MedicineEntity {
    private int idMedicine;
    private String medicinename;
    private Double price;
    private String country;

    public MedicineEntity() {
    }

    public MedicineEntity(int idMedicine, String medicinename, Double price, String country, TypeofmedicineEntity type) {
        this.idMedicine = idMedicine;
        this.medicinename = medicinename;
        this.price = price;
        this.country = country;
        this.type = type;
    }

    public MedicineEntity(String medicinename, Double price, String country, TypeofmedicineEntity type) {
        this.medicinename = medicinename;
        this.price = price;
        this.country = country;
        this.type = type;
    }

    private TypeofmedicineEntity type;

    @ManyToOne
    @PrimaryKeyJoinColumn(name="type_id", referencedColumnName = "id_type")
    public TypeofmedicineEntity getType() {
        return type;
    }

    public void setType(TypeofmedicineEntity type) {
        this.type = type;
    }

    private List<SalesEntity> sales;

    @OneToMany(mappedBy="medicine")
    public List<SalesEntity> getSales() {
        return sales;
    }

    public void setSales(List<SalesEntity> medicines) {
        this.sales = medicines;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_medicine")
    public int getIdMedicine() {
        return idMedicine;
    }

    public void setIdMedicine(int idMedicine) {
        this.idMedicine = idMedicine;
    }

    @Basic
    @Column(name = "medicinename")
    public String getMedicinename() {
        return medicinename;
    }

    public void setMedicinename(String medicinename) {
        this.medicinename = medicinename;
    }

    @Basic
    @Column(name = "price")
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicineEntity that = (MedicineEntity) o;

        if (idMedicine != that.idMedicine) return false;
        if (medicinename != null ? !medicinename.equals(that.medicinename) : that.medicinename != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMedicine;
        result = 31 * result + (medicinename != null ? medicinename.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
