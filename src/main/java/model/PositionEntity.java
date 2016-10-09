package model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Дамир on 15.09.2016.
 */
@Entity
@Table(name = "position", schema = "public", catalog = "pharmacy")
public class PositionEntity {
    private int idPosition;
    private String positionname;
    private int salary;
    private List<EmployerEntity> employers;


    public PositionEntity() {
    }

    public PositionEntity(String positionname, int salary) {
        this.positionname = positionname;
        this.salary = salary;
    }

    public PositionEntity(int idPosition, String positionname, int salary) {
        this.idPosition = idPosition;
        this.positionname = positionname;
        this.salary = salary;
    }

    @OneToMany(mappedBy = "position")
    public List<EmployerEntity> getEmployers() {
        return employers;
    }

    public void setEmployers(List<EmployerEntity> emplyers) {
        this.employers = emplyers;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_position")
    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    @Basic
    @Column(name = "positionname")
    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PositionEntity that = (PositionEntity) o;

        if (idPosition != that.idPosition) return false;
        if (salary != that.salary) return false;
        if (positionname != null ? !positionname.equals(that.positionname) : that.positionname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPosition;
        result = 31 * result + (positionname != null ? positionname.hashCode() : 0);
        result = 31 * result + salary;
        return result;
    }
}
