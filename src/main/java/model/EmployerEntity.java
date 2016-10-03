package model;

import javax.persistence.*;

/**
 * Created by Дамир on 15.09.2016.
 */
@Entity
@Table(name = "employer", schema = "public", catalog = "pharmacy")
public class EmployerEntity {
    private int idEmployer;
    private String firstname;
    private String secondname;
    private String patronymic;
    private int inn;
    private int serialofpassport;
    private int numberofpassport;

    private BranchEntity branch;
    private PositionEntity position;

    public EmployerEntity() {
    }

    public EmployerEntity(String firstname, String secondname, String patronymic, int inn, int serialofpassport, int numberofpassport, BranchEntity branch, PositionEntity position) {
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.inn = inn;
        this.serialofpassport = serialofpassport;
        this.numberofpassport = numberofpassport;
        this.branch = branch;
        this.position = position;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_branch", referencedColumnName = "id_branch")
    public BranchEntity getBranch() {
        return branch;
    }

    public void setBranch(BranchEntity branch) {
        this.branch = branch;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name="id_position", referencedColumnName = "id_position")
    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id_employer")
    public int getIdEmployer() {
        return idEmployer;
    }

    public void setIdEmployer(int idEmployer) {
        this.idEmployer = idEmployer;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "secondname")
    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "inn")
    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    @Basic
    @Column(name = "serialofpassport")
    public int getSerialofpassport() {
        return serialofpassport;
    }

    public void setSerialofpassport(int serialofpassport) {
        this.serialofpassport = serialofpassport;
    }

    @Basic
    @Column(name = "numberofpassport")
    public int getNumberofpassport() {
        return numberofpassport;
    }

    public void setNumberofpassport(int numberofpassport) {
        this.numberofpassport = numberofpassport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployerEntity that = (EmployerEntity) o;

        if (idEmployer != that.idEmployer) return false;
        if (inn != that.inn) return false;
        if (serialofpassport != that.serialofpassport) return false;
        if (numberofpassport != that.numberofpassport) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (secondname != null ? !secondname.equals(that.secondname) : that.secondname != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmployer;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + inn;
        result = 31 * result + serialofpassport;
        result = 31 * result + numberofpassport;
        return result;
    }
}
